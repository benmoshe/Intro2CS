package ex4.geometry;

import ex4.Ex4_Const;

/**
 * This class represents a 2D Triangle in the plane.
 * Ex4: you should implement this class!
 * @author I2CS
 *
 */
public class Triangle2D implements GeoShape{
	private Point2D[] _ps;
	public Triangle2D(Point2D p1, Point2D p2, Point2D p3) {
		_ps = new Point2D[3];
		_ps[0]=new Point2D(p1);
		_ps[1]=new Point2D(p2);
		_ps[2]=new Point2D(p3);
	}
	public Triangle2D(Triangle2D t1) {
		this(t1._ps[0], t1._ps[1], t1._ps[2]);
	}
	@Override
	public boolean contains(Point2D ot) {
		boolean ans = false;
		double area = this.area(), a1=0;
		for(int i=0;i<_ps.length;i=i+1) {
			int i1 = (i+1)%3;
			Triangle2D t = new Triangle2D(_ps[i], _ps[i1], ot);
			a1+=t.area();
		}
		double da = a1-area;
		ans = da<Point2D.EPS; // ZZZZ should be a Constant class;
		return ans;
	}

	@Override
	public Point2D centerOfMass() {
		Point2D ans = null;
		double x=0,y=0;
		for(int i=0;i<_ps.length;i=i+1) {
			x += _ps[i].x();
			y += _ps[i].y();
		}
		ans = new Point2D(x/3,y/3);
		return ans;
	}

	/**
	 * https://en.wikipedia.org/wiki/Heron%27s_formula
	 * d = peremiter/2;
	 * area = Math.sqrt((d-a)(d-b)(d-c)),  a,b,c are the edges length
	 */
	@Override
	public double area() {
		double d = this.perimeter()/2;
		double ans = d;
		for(int i=0;i<_ps.length;i=i+1) {
			int i1 = (i+1)%3;
			double abc = _ps[i].distance(_ps[i1]);
			ans *= (d-abc);
		}
		return Math.sqrt(ans);
	}

	@Override
	public double perimeter() {
		double ans = 0;
		for(int i=0;i<_ps.length;i=i+1) {
			int i1 = (i+1)%3;
			double d = _ps[i].distance(_ps[i1]);
			ans += d;
		}
		return ans;
	}

	@Override
	public void move(Point2D vec) {
		for(int i=0;i<_ps.length;i=i+1) {
			_ps[i].move(vec);
		}
	}

	@Override
	public GeoShape copy() {
		return new Triangle2D(_ps[0], _ps[1], _ps[2]);
	}

	@Override
	public Point2D[] getPoints() {
		Point2D[] ans = new Point2D[3];
		for(int i=0;i<_ps.length;i=i+1) {
			ans[i] = new Point2D(_ps[i]);
		}
		return ans;
	}
	@Override
	public String toString() {
		String ans = "";//
		for(int i=0;i<_ps.length;i=i+1) {
			ans += _ps[i];
			if(i<2) {ans+=",";}
		}
		return ans;
	}
	@Override 
	public boolean equals(Object t) {
		if(t==null || !(t instanceof Triangle2D)) {return false;}
		Triangle2D ot = (Triangle2D)t;
		boolean ans = true;
		for(int i=0;i<3 & ans;i=i+1) {
			if(this.minNodeDist(ot._ps[i])>Ex4_Const.EPS) {
				ans = false;
			}
		}
		return ans;
	}
	private double minNodeDist(Point2D p) {
		double ans = Double.MAX_VALUE;
		for(int i=0;i<3;i=i+1) {
			double d1 = this._ps[i].distance(p);
			if (d1<ans) {ans = d1;}
		}
		return ans;
	}
}
