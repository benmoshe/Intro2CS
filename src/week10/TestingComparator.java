package week10;

import java.util.Arrays;

public class TestingComparator {
	public static void main(String[] a) {
		int size = 10;
		Point2D[] ps = new Point2D[size];
		Point2D p1 = new Point2D(3,2);
		Circle2D c1 = new Circle2D(p1, 5); 
		for(int i=0;i<size;i=i+1) {
			ps[i] = randomPoint2(c1);
			System.out.println(ps[i]+" , norm: "+ps[i].distance());
		}	
		Point2DComparator comp = new Point2DComparator(); 
		Arrays.sort(ps, comp);
		System.out.println("**** Now Sorted ****");
		for(int i=0;i<size;i=i+1) {
			System.out.println(ps[i]+" , norm: "+ps[i].distance());
		}
	}
	/**
	 * This static function computes a random point within the given circle (c).
	 * @param c
	 * @return
	 */
	public static Point2D randomPoint(Circle2D c) {
		Point2D ans = null;
		Point2D p0 = c.centerOfMass();
		double rad = c.getRadius();
		while(ans == null) {
			double x = random(p0.x()-rad, p0.x()+rad);
			double y = random(p0.y()-rad, p0.y()+rad);
			Point2D p = new Point2D(x,y);
			if(c.contains(p)) {ans=p;}
		}
		return ans;
	}
	/**
	 * This static function computes a random point within the given circle (c).
	 * @param c
	 * @return
	 */
	public static Point2D randomPoint2(Circle2D c) {
		Point2D ans = null;
		double rad = c.getRadius();
		double r = random(0, 1);
		r = Math.pow(r, 0.5); // this is the trick!!
		double ang = random(0, Math.PI*2);
		double x = rad*Math.cos(ang);
		double y = rad*Math.sin(ang);
		ans = new Point2D(x,y);
		ans.move(c.centerOfMass());
		return ans;
	}
	public static double random(double min, double max) {
		if(min>=max) {throw new RuntimeException("Err: the random function got aan empty range: ("+min+","+max+") should not be empty!");}
		double dx = max-min;
		double ans = min + Math.random()*dx;
		return ans;
	}
	
}
