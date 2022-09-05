/**
 * This class represents a 2D point in the plane.
 * Our first example of Object Oriented Programming
 */

package week8;

public class Point2D { // the class name should be the same name as the .java file
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    public static final Point2D ORIGIN = new Point2D(0,0);
    
    private double _x;  // private data members
    private double _y;
    
    /**
     * Constructor
     * @param a
     * @param b
     */
    public Point2D(double a,double b) {
    	_x=a; _y=b;
    }
    /** Copy Constructor */
    public Point2D(Point2D p) {
       this(p.x(), p.y());
       // _x = p.x(); _y = p.y();
    }
    /**
     * String sp = "2.3,-3.1";
     * Point2D p = new Point2D(sp);
     * @param s
     */
    public Point2D(String s) {
        try { //?
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for Point2D init, got:"+s+"  should be of format: x,y");
            throw(e);
        }
    }
    /** 
     * Getter for x
     * @return
     */
    public double x() {return _x;}
    public double y() {return _y;}
 
    public int ix() {return (int)_x;}
    public int iy() {return (int)_y;}
  /** Add a vector */
    public Point2D add(Point2D p) {
    	Point2D a = new Point2D(p.x()+x(),p.y()+this.y());
    	return a;
    }

    public String toString()
    {
        return _x+","+_y;
    }

    public double distance()
    {
        return this.distance(ORIGIN);
    }
    public double distance(Point2D p2)
    {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        return Math.sqrt(t);
    }

    public boolean equals(Object p)
    {
        if(p==null || !(p instanceof Point2D)) {return false;}
        Point2D p2 = (Point2D)p;
        return ( (_x==p2._x) && (_y==p2._y));
    }
    public boolean close2equals(Point2D p2, double eps)
    {
        return ( this.distance(p2) < eps );
    }
    public boolean close2equals(Point2D p2)
    {
        return close2equals(p2, EPS);
    }
    
    public static void main(String[] args) {
    	Point2D p1 = new Point2D(1,2);
    	Point2D p2 = new Point2D(5,5);
    	double dist = p1.distance(p2);
    	System.out.println("The distance is: "+dist);
    	Point2D p3 = p1.add(p2);
    	System.out.println("p3 is "+p3);
    }
}
