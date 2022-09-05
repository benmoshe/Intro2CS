package week10;
/** 
 * This class represents a 2D circle in the plane. Please make sure you update it 
 * according to the GeoShape interface.
 * @author boaz.benmoshe
 *
 */
public class Ellipse2D implements GeoShape{
	private Point2D _c1,_c2;
	private double _radius;
	
	public Ellipse2D(Point2D c1, Point2D c2, double rad) {
		this._c1 = new Point2D(c1);
		this._c2 = new Point2D(c2);
		if(rad<0) {
			throw new RuntimeException("Err got a negative radius for Circle init");
		}
		this._radius = rad;
	}
	public double getRadius() {return this._radius;}
	 @Override
	    public String toString()
	    { return "Ellipse2D: ("+_c1.toString()+", "+_c2+"   rad: "+_radius;}
	@Override
	public boolean contains(Point2D ot) {
		double dist = ot.distance(this._c1) + ot.distance(this._c2);
		return dist<=this._radius;
	}
	@Override
	public Point2D centerOfMass() {
		return new Point2D(this._c1);
	}
	@Override
	public double area() {
		return -1;
	}
	@Override
	public double perimeter() {
		return -1;
	}
	@Override
	public void move(Point2D vec) {
		_c1.move(vec);
		_c2.move(vec);
	}
	@Override
	public GeoShape copy() {
		return new Ellipse2D(_c1,_c2, _radius);
	}
	@Override
	public Point2D[] getPoints() {
		return null;
	}

}
