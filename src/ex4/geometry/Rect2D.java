package ex4.geometry;

import ex4.Ex4_Const;

/**
 * This class represents a 2D axis parallel rectangle.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Rect2D implements GeoShape{
	private Point2D _min, _max;
	public Rect2D(Point2D p1, Point2D p2) {
		double x0 = Math.min(p1.x(), p2.x());
		double y0 = Math.min(p1.y(), p2.y());
		double x1 = Math.max(p1.x(), p2.x());
		double y1 = Math.max(p1.y(), p2.y());
		_min = new Point2D(x0,y0);
		_max = new Point2D(x1,y1);
	}
	public Rect2D(Rect2D t1) {this(t1._min, t1._max);
		// TODO Auto-generated constructor stub
	}
	public double width() {return _max.x()-_min.x();}
	public double height() {return _max.y()-_min.y();}
	@Override
	public boolean contains(Point2D ot) {
		boolean ans = false;
		if(ot!=null) {
			if(ot.x()>=_min.x() && ot.y()>=_min.y() &&
				ot.x()<=_max.x() && ot.y()<=_max.y()) {
				ans = true;
			}
		}
		return ans;
	}

	@Override
	public Point2D centerOfMass() {
		double x = (_min.x()+_max.x())/2;
		double y = (_min.y()+_max.y())/2;
		return new Point2D(x,y);
	}

	@Override
	public double area() {
		double ans = width() * height();
		return ans;
	}
	
	@Override
	public double perimeter() {
		double ans = width() + height();
		return ans*2;
	}

	@Override
	public void move(Point2D vec) {
		_min.move(vec);
		_max.move(vec);
	}
	@Override
	public GeoShape copy() {
		return new Rect2D(_min,_max);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = {new Point2D(_min), new Point2D(_max)};
		return ans;
	}
	@Override
	public String toString() {
		String ans = _min+","+_max;
		return ans;
	}
	@Override 
	public boolean equals(Object t) {
		if(t==null || !(t instanceof Rect2D)) {return false;}
		Rect2D ot = (Rect2D)t;
		boolean ans = this._min.equals(ot._min);
		ans &= this._max.equals(ot._max);
		return ans;
	}

}
