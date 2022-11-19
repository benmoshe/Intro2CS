
package Exe.EX3;
/**
 * Introduction to Computer Science, Ariel University, Ex3:
 * This class represents a 2D point in the plane.
 * Do NOT change this class! It would be used as is for testing.
 * @author boaz.benmoshe
 */


public class Point2D{
	/**
	 * Standard (large) epsilon for numerical computation: 1/1000.
	 */
    public static final double EPS1 = 0.001;
    /**
	 * Standard (small) epsilon for numerical computation 10^{-6}.
	 */
    public static final double EPS2 = Math.pow(EPS1,2);
    /**
	 * Standard epsilon for numerical computation.
	 */
    public static final double EPS=EPS2;
    /**
	 * static final reference for the origin: [0,0].
	 */
    public static final Point2D ORIGIN = new Point2D(0,0);
    /** The private (double ) 2D coordinates */
    private double _x,_y;
    
    /** Standard constructor. */
    public Point2D(double x,double y) {_x=x; _y=y; }
    /** Copy constructor. */
    public Point2D(Point2D p) {this(p.x(), p.y());    }
    /** Constructor from String <x,y>. */
    public Point2D(String s) {
        try {
            String[] a = s.split(",");
            _x = Double.parseDouble(a[0]);
            _y = Double.parseDouble(a[1]);
        }
        catch(IllegalArgumentException e) {
            System.err.println("ERR: got wrong format string for Point2D init, got:"+s+"  should be of format: x,y");
            throw(e);
        }
    }
    
    public double x() {return _x;}
    public double y() {return _y;}
 /**
  * returns the "rounded" int value of the x coordinate
  * @return (int)Math.round(_x)
  */
    public int ix() {return (int)Math.round(_x);}
    /**
     * returns the "rounded" int value of the y coordinate
     * @return (int)Math.round(_y)
     */
    public int iy() {return (int)Math.round(_y);}
  
    /**
     * Compute a new Point as the sum of this Point and p.
     * @param p
     * @return
     */
    public Point2D add(Point2D p) {
    	Point2D a = new Point2D(p.x()+x(),p.y()+y());
    	return a;
    }
    @Override
    public String toString()
    {
        return _x+","+_y;
    }
    public String toStringInt()
    {
        return "["+ix()+","+iy()+"]";
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
    /**
     * This method returns the vector between this point and the target point. 
     * The vector is represented as a Point2D.
     * @param target - the new vector this-->target
     * @return a new vector this-->target
     */
    public Point2D vector(Point2D target) {
    	double dx = target.x() - this.x();
    	double dy = target.y() - this.y();
    	return new Point2D(dx,dy);
    }
	/**
	 * Note: this code was updated (in v0.2) in order to follow the notion of "close shapes".
	 */
	public boolean contains(Point2D ot) {
		return this.equals(ot);
	}
	/**
	 * Translates this point by a vector (represented as a point).
	 * @param vec a vector [0,0]-->vec
	 */
	public void move(Point2D vec) {
		this._x += vec.x();
		this._y += vec.y();
	}
}
