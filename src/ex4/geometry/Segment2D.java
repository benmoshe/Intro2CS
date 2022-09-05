package ex4.geometry;

import ex4.Ex4_Const;
/**
 * This class represents a 2D segment on the plane, 
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Segment2D implements GeoShape{
	private Point2D _p1, _p2;
	public Segment2D(Point2D a, Point2D b) {
		_p1=new Point2D(a);
		_p2=new Point2D(b);
	}
	public Segment2D(Segment2D t1) {
		this(t1._p1, t1._p2);
	}
	@Override
	public boolean contains(Point2D ot) {
		boolean ans = false;
		double d12 = _p1.distance(_p2);
		double dd = _p1.distance(ot)+ot.distance(_p2);
		ans = d12+Ex4_Const.EPS>= dd;
		return ans;
	}

	@Override
	public Point2D centerOfMass() {
		double x=0,y=0;
		x += _p1.x() + _p2.x();
		y += _p1.y() + _p2.y();
	
		return new Point2D(x/2,y/2);
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */
	@Override
	public double area() {
		return 0;
	}

	@Override
	public double perimeter() {
		double ans = _p1.distance(_p2);
		return ans*2;
	}

	@Override
	public void move(Point2D vec) {
		_p1.move(vec);
		_p2.move(vec);
	}

	@Override
	public GeoShape copy() {
		return new Segment2D(_p1,_p2);
	}
	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = {new Point2D(_p1), new Point2D(_p2)};
		return ans;
	}
	@Override
	public String toString() {
		String ans = _p1+","+_p2;//
		return ans;
	}
	@Override 
	public boolean equals(Object t) {
		if(t==null || !(t instanceof Segment2D)) {return false;}
		Segment2D ot = (Segment2D)t;
		double d11 = this._p1.distance(ot._p1);
		double d22 = this._p2.distance(ot._p2);
		double d12 = this._p1.distance(ot._p2);
		double d21 = this._p2.distance(ot._p1);
		
		boolean ans = (d11<Ex4_Const.EPS && d22<Ex4_Const.EPS) | (d12<Ex4_Const.EPS && d21<Ex4_Const.EPS);
		return ans;
	}
}