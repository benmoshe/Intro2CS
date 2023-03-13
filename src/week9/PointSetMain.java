package week9;

import java.util.ArrayList;

import week7.Point2D;
/**
 * @author boazben-moshe
 * 0) 1.0,2.0
1) 1.0,2.0
2) 1.0,2.0
3) 1.0,2.0
4) 1.0,2.0
5) 1.0,2.0
6) 1.0,2.0
7) 1.0,2.0
8) 1.0,2.0
9) 1.0,2.0


0) 1.0,2.0

 */
public class PointSetMain {

	public static void main(String[] args) {
		ArrayList<Point2D> ps = new MySet<Point2D>();
	//	ArrayList<Point2D> ps = new ArrayList<Point2D>();
		for(int i=0;i<10;i++) {
			Point2D p = new Point2D(1,2);
			ps.add(p);
		//	ps.add("12");
		}
		for(int i=0;i<ps.size();i++) {
			Point2D p = ps.get(i);
			System.out.println(i+") "+p.toString());
		}
	}
	

}
