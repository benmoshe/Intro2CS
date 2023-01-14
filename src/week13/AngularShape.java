package week13;
import week7.Point2D;

public class AngularShape {
	private Function2D _func;
	private Point2D _center;
	
	
	public AngularShape(Function2D f, Point2D c) {
		_func=f;
		_center = new Point2D(c);
	}
	public Point2D[] getPoly(int n) {
		Point2D[] ans = new Point2D[n];
		double da = 360.0/n;
		da = Math.toRadians(da);
		double aa = 0;
		for(int i=0;i<n;i++) {
			double a = _func.f(aa);
			double dx = a*Math.cos(aa);
			double dy = a*Math.sin(aa);
			Point2D curr = new Point2D(this._center.x()+dx, this._center.y()+dy);
			ans[i] = curr;
			aa+=da;
		}
		return ans;
	}
}
