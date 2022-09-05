package week9;
/**
 * This class represents a 2D circle in the plane, with the following methods:
 * ZZZZZ TBD
 * @author boaz.benmoshe
 *
 */
public class Circle2D {
	
	
	private Point2D _center;
	private double _radius;
	
	
	public Circle2D(Point2D cen, double rad) {
		if(rad<0) {
			System.err.println("ERR: got negative radius: "+rad);
			System.exit(-1);
		}
		this.setRadius(rad);
		setCenter(cen);
	}
	public Circle2D( Circle2D c) {
		this(c.getCenter(), c.getRadius());
	//	this.setCenter(c.getCenter());
	//	this.setRadius(c.getRadius());
	}
	public Circle2D(double x, double y, double rad) {
		this(new Point2D(x,y),rad);
	}
	public String toString() {
		String ans = "";
		ans = "Circle2D: center: "+this.getCenter()+"  rad: "+this.getRadius();
		return ans;
	}
	
	/**
	 * Note: address this Circle as a CLOSE shape (aka: d<=this.getRadius();)
	 * @param p
	 * @return
	 */
	public boolean isIn(Point2D p) {
		double d = this.getCenter().distance(p);
		boolean isIn = d<=this.getRadius();
		return isIn;
	}
	public Point2D getCenter() {return this._center;}
	public double getRadius() {
		return _radius;
	}
	///////////////////// Private ///////////////////
	private void setRadius(double r) {this._radius = r;}
	private void setCenter(Point2D p) {
		_center = new Point2D(p); // Note: a new Point was constructed
	}
}
