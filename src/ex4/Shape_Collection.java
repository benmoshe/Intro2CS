package ex4;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
/**
 * This class represents a collection of GUI_Shape.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Shape_Collection implements GUI_Shape_Collection{
	private ArrayList<GUI_Shape> _shapes;
	
	public Shape_Collection() {
		_shapes = new ArrayList<GUI_Shape>();
	}
	@Override
	public GUI_Shape get(int i) {
		return _shapes.get(i);
	}

	@Override
	public int size() {
		return _shapes.size();
	}

	@Override
	public GUI_Shape removeElementAt(int i) {
		return _shapes.remove(i);
	}

	@Override
	public void addAt(GUI_Shape s, int i) {
		_shapes.add(i, s);
	}
	@Override
	public void add(GUI_Shape s) {
		_shapes.add(s);
	}
	@Override
	public GUI_Shape_Collection copy() {
		GUI_Shape_Collection ans = new Shape_Collection();
		for(int i=0;i<this.size();i++) {
			GUI_Shape s = this.get(i).copy();
			ans.addAt(s, i);
		}
		return ans;
	}

	@Override
	public void sort(Comparator comp) {
		_shapes.sort(comp);
	}

	@Override
	public void removeAll() {
		_shapes.clear();
	}

	@Override
	public void save(String file) {
		 try {
		      FileWriter myWriter = new FileWriter(file);
		      for(int i=0;i<size();i=i+1) {
		    	  myWriter.write(get(i).toString()+"\n");
		      }
		      myWriter.close();
		 }
		 catch(Exception e) {
			 e.printStackTrace();
		 }
		
	}

	@Override
	public void load(String file) {
		try {
		     File myObj = new File(file);
		      Scanner myReader = new Scanner(myObj);
		      this._shapes.clear();
		      while (myReader.hasNextLine()) {
		        String data = myReader.nextLine();
		        GUI_Shape g = new GUIShape(data);
		        this._shapes.add(g);
		      }
		      myReader.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public Rect2D getBoundingBox() {
		Rect2D ans = null;
		double x0=0,x1=0,y0=0,y1=0;
		boolean first = true;
		for(int i=0;i<size();i=i+1) {
			GeoShape g = this.get(i).getShape();
			Point2D[] arr = g.getPoints();
			if(g instanceof Circle2D) {
				double r = arr[0].distance(arr[1]);
				Point2D min = new Point2D(arr[0].x()-r, arr[0].y()-r);
				Point2D max = new Point2D(arr[0].x()+r, arr[0].y()+r);
				arr[0] = min; arr[1]=max;
			}
			System.out.println(g+" "+arr.length);
			for(int a = 0;a<arr.length;a=a+1) {
				if(first) {x0=arr[0].x();x1=x0;y0=arr[0].y();y1=y0;first=false;}
				double x = arr[a].x();
				double y = arr[a].y();
				if(x<x0) {x0=x;}
				if(x>x1) {x1=x;}
				if(y<y0) {y0=y;}
				if(y>y1) {y1=y;}
			}
		}
		Point2D min = new Point2D(x0,y0);
		Point2D max = new Point2D(x1,y1);
		ans = new Rect2D(min,max);
		return ans;
	}
	@Override
	public String toString() {
		String ans = "";
		for(int i=0;i<size();i=i+1) {
			ans += this.get(i);
		}
		return ans;
	}
	

}
