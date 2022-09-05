/**
 * This class represents a 2D point in the plane.
 * Our first example of Object Oriented Programming
 */

package week8;

public class Point { // the class name should be the same name as the .java file
	public static final double EPS = 0.001;
    private double _x;  // private data members
    private double _y;
    
    /**
     * Constructor
     * @param a
     * @param b
     */
    public Point(double a,double b) {
    	_x=a; _y=b;
    }
   
    /** 
     * Getter for x
     * @return
     */
    public double x() {return _x;}
    public double y() {return _y;}
 
  /** Add a vector */
    public Point add(Point p) {
    	Point a = new Point(p.x()+this.x(),p.y()+this.y());
    	return a;
    }

    public String toString()
    {
        return "("+this.x()+","+_y+")";
    }

    public double distance(Point p2)
    {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        return Math.sqrt(t);
    }

    public boolean close2equals(Point p2) { 
    	return close2equals(p2,EPS);
    }
    public boolean close2equals(Point p2, double eps)
    {
    	double d = this.distance(p2);
    	boolean ans = d<eps;
        return ans;
    }
  
    public static void main(String[] args) {
    	Point pp1 = new Point(1,2);
    	Point pp2 = new Point(5,5);
    	double dist = pp1.distance(pp2);
    	System.out.println("The distance is: "+dist);
    	Point pp3 = pp1.add(pp2); 
    	System.out.println("p3 = "+pp3);
    	Point p12 = pp1.add(pp2); // (6,7)
    	Point p21 = pp2.add(pp1); // (6,7)
    	boolean close = p12.close2equals(p21);
    	boolean eq = p12 == p21;
    //	System.err.println("p3 = "+p3);
   
    }
}
