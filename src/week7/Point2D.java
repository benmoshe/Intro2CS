/**
 * This class represents a 2D point in the plane.

 * Our first example of Object Oriented Programming:
 * output:
 * The distance is: 5.0
p3 is 6.0,7.0

 */

package week7;

public class Point2D {
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    public static final Point2D ORIGIN = new Point2D(0,0);
    
    private double _x;
    private double _y;
    
    /**
     * Standard Constructor  
     * @param a - first parameter (x)
     * @param b - second parameter (y)
     */
    public Point2D(double a,double b) {
    	_x=a; _y=b;
    }
    /**
     * Copy Constructor  
     * @param p - the original point (to be copied).
      */
    public Point2D(Point2D p) {
       this(p.x(), p.y());
    //	_x = p.x();
    //	this._y = p.y();
    }
    /**
     * String Constructor  
     * @param s - assuming the point is in the following (String) structure: 
     * "-1.2,5.3" --> (-1.2,5.3) ;
     */
    public Point2D(String s) {
    	String[] a = s.split(",");
    	_x = Double.parseDouble(a[0]);
    	_y = Double.parseDouble(a[1]);
    }
    public double x() {return _x;}
    public double y() {return _y;}
 
    public int ix() {return (int)_x;}
    public int iy() {return (int)_y;}
  
    public Point2D add(Point2D p) {
    	Point2D a = new Point2D(p.x()+x(),p.y()+this.y());
    	return a;
    }
    /**
     * This method translate this point by a vector like representation of p.
     * @param p
     * Example 
     * Point2D p5 = new Point2D(1,2);
     * Point2D v = new Point2D(5,-4);
     * p5.move(v);
     */
    public void move(Point2D p) {
    	this._x += p.x();
    	_y += p.y();
    }

    public String toString()
    {
        return _x+","+_y;
    }

    public double distance()
    {
        return this.distance(ORIGIN);
    }
    /**
     * dist(this,p2) = Math.sqrt(dx^2 + dy^2)
     * @param p2 - the other point from which the distance to this point is computed.
     * @return
     */
    public double distance(Point2D p2) {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        return Math.sqrt(t);
    }
     public static double distance(Point2D p1, Point2D p2) {
         double dx = p1.x() - p2.x();
         double dy = p2.y() - p2.y();
         double t = (dx*dx+dy*dy);
         return Math.sqrt(t);
     }
    /**
     *  return true iff: this point equils to p.
     */
    public boolean equals(Object p)
    {
        if(p==null || !(p instanceof Point2D)) {return false;}
        Point2D p2 = (Point2D)p;
        return ( (_x==p2._x) && (_y==p2.y()));
    }
    public boolean equals(Point2D p)
    {
        if(p==null) {return false;}
        return ( (_x==p._x) && (_y==p._y));
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
    	Point2D e = p1;
    	double dist = p1.distance(p2);
    	System.out.println("The distance is: "+dist);
    	Point2D p3 = p1.add(p2);
    	System.out.println("p3 is "+p3);
    }
}
