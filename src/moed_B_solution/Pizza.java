package moed_B_solution;
/**
 * This class is part of Moed_B (intro to CS) - Q4,
 * The class Pizza represents an angular part of a 2D Circle 
 * (aka Pizza, or Wedge).
 */
public class Pizza implements GeoShape{
	private Circle2D _ci;
	private double _start_ang;
	private double _end_ang;
	
	public Pizza(Circle2D c, double s, double e) {
		_ci = new Circle2D(c);
		_start_ang = s;
		_end_ang = e;
		double da = this.delta_angle();
		if(da<0 | da>360) {
			throw new RuntimeException("ERR: wrong parameters for wedge (Pizza):  ["+s+","+e+"] da: "+da);
		}
	}
	public double delta_angle() {return this._end_ang-this._start_ang;}
	
	@Override
	public boolean contains(Point2D ot) {
		double ang = _ci.getCenter().angle_deg(ot);
		return _ci.contains(ot) && ang>=this._start_ang &&
				ang<= this._end_ang;
	}

	@Override
	public double area() {
		double a = _ci.area();
		a = a*(this.delta_angle())/360;
		return a;
	}

	@Override
	public double perimeter() {
		double a = _ci.perimeter();
		a = a*(this.delta_angle())/360;
		return a + 2*_ci.getRadius();
	}
}
