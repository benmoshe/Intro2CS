
package moed_B_solution;
/**
 * This class represents a 2D point in the plane.
 * Do NOT change this class! It would be used as is for testing.
 */

public class Point2D implements GeoShape{
    public static final double EPS1 = 0.001, EPS2 = Math.pow(EPS1,2), EPS=EPS2;
    public static final Point2D ORIGIN = new Point2D(0,0);
    private double _x,_y;
    public Point2D(double x,double y) {
    	_x=x; _y=y;
    }
    public Point2D(Point2D p) {
       this(p.x(), p.y());
    }
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
 
    public Point2D add(Point2D p) {
    	Point2D a = new Point2D(p.x()+x(),p.y()+y());
    	return a;
    }
    @Override
    public String toString() {return _x+","+_y;}

    public double distance() {
        return this.distance(ORIGIN);
    }
    public double distance(Point2D p2) {
        double dx = this.x() - p2.x();
        double dy = this.y() - p2.y();
        double t = (dx*dx+dy*dy);
        return Math.sqrt(t);
    }
    /**
     * This method returns the angle (in Degrees) of the vector this-->ot.
     * @param ot the end of the vector.
     * @return the angle (in Degrees) of the vector this-->ot.
     */
    public double angle_deg(Point2D ot) {
    	double d = Math.toDegrees(angle_rad(ot));
    	if (d<0) {d = 360+d;}
    	return d;
    }
    public double angle_rad(Point2D ot) {
    	double dx = ot.x()-this.x();
    	double dy = ot.y()-this.y();
    	double angle = Math.atan2(dy, dx);
    	return angle;
    }
  

    public boolean equals(Object p)
    {
        if(p==null || !(p instanceof Point2D)) {return false;}
        Point2D p2 = (Point2D)p;
        return ( (_x==p2._x) && (_y==p2._y));
    }
    public boolean close2equals(Point2D p2, double eps)  {
        return ( this.distance(p2) < eps );
    }
    public boolean close2equals(Point2D p2) {
        return close2equals(p2, EPS);
    }
  
    @Override
	public boolean contains(Point2D ot) {
		return this.equals(ot);
	}

	@Override
	public double area() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public double perimeter() {
		// TODO Auto-generated method stub
		return 0;
	}
}
