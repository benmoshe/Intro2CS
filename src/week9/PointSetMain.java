package week9;

import java.util.ArrayList;

import week7.Point2D;
/**
 * @author boazben-moshe
 *
 */
public class PointSetMain {

	public static void main(String[] args) {
	//	ArrayList<Point2D> ps = new MySet<Point2D>();
		ArrayList<Point2D> ps = new ArrayList<Point2D>();
		for(int i=0;i<10;i++) {
			Point2D p = new Point2D(1,2);
			ps.add(p);
		}
		for(int i=0;i<ps.size();i++) {
			Point2D p = ps.get(i);
			System.out.println(i+") "+p.toString());
		}
	}

}
