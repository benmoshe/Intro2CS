package moed_B_solution;
/** 
 * This class represents a 2D circle in the plane. 
 * Do NOT change this class.
 */
public class Circle2D implements GeoShape{
	private Point2D _center;
	private double _radius;
	
	public Circle2D(Point2D cen, double rad) {
		this._center = new Point2D(cen);
		this._radius = rad;
	}
	public Circle2D(Circle2D c) {
		this(c._center, c._radius);
	}
	public Point2D getCenter() {return _center;}
	public double getRadius() {return this._radius;}
	
	@Override
	public String toString() { return _center.toString()+", "+_radius;}
	
	 @Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._center);
		return dist<=this._radius;
	}
	
	@Override
	public double area() {
		double ans = Math.PI * Math.pow(this._radius, 2);
		return ans;
	}
	@Override
	public double perimeter() {
		double ans = Math.PI * 2 * this._radius;
		return ans;
	}

}
