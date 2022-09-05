package ex4;
import java.awt.Color;
import ex4.geometry.*;
/**
 * This class is the "main" class which will be constructed and run as in (Test_Ex4).
 * Ex4: you should implement this class!
 * @author boaz.benmoshe
 *
 */
public class Ex4 implements Ex4_GUI{
	private GUI_Shape_Collection _gsc;
	public Ex4() {
		_gsc = new Shape_Collection();
	}
	@Override
	public void init(GUI_Shape_Collection g) {
		_gsc = g;
	}
	
	@Override
	public GUI_Shape_Collection getShape_Collection() {
		return _gsc;
	}

	@Override
	public void show() {
		StdDraw.clear();
		for(int i=0;i<_gsc.size();i++) {
			GUI_Shape cr = _gsc.get(i);
			Color c = cr.getColor();
			StdDraw.setPenColor(c);
			StdDraw.setPenRadius(0.01);
			boolean f = cr.isFilled();
			GeoShape g = cr.getShape();
			if(g instanceof Point2D) {
				drawPoint((Point2D)g);
			}
			if(g instanceof Circle2D) {
				drawCircle((Circle2D)g, f);
			}
			if(g instanceof Rect2D) {
				drawRect((Rect2D)g, f);
			}
			if(g instanceof Triangle2D) {
				drawPolygon((Triangle2D)g, f);
			}
			if(g instanceof Segment2D) {
				drawSegment((Segment2D)g);
			}
		}
		StdDraw.show();
	}
	private void drawPoint(Point2D p) {
		StdDraw.point(p.x(), p.y());
	}
	private void drawSegment(Segment2D s) {
		Point2D[] ps = s.getPoints();
		StdDraw.line(ps[0].x(),ps[0].y(), ps[1].x(), ps[1].y());
	}
	private void drawCircle(Circle2D c, boolean fill) {
		//_std.setPenRadius(0.01);
		Point2D p = c.centerOfMass();
		if(fill) {
			StdDraw.filledCircle(p.x(), p.y(), c.getRadius());}
		else {
			StdDraw.circle(p.x(), p.y(), c.getRadius());}
	}
	private void drawRect(Rect2D c, boolean fill) {
		//_std.setPenRadius(0.01);
		Point2D p = c.centerOfMass();
		if(fill) {
			StdDraw.filledRectangle(p.x(), p.y(),c.width()/2,c.height()/2);}
		else {
			StdDraw.rectangle(p.x(), p.y(),c.width()/2,c.height()/2);}
	}
	private void drawPolygon(Triangle2D c, boolean fill) {
		//_std.setPenRadius(0.01);
		Point2D[] p = c.getPoints();
		double[] xx = new double[p.length];
		double[] yy = new double[p.length];
		for(int i=0;i<xx.length;i=i+1) {
			xx[i] = p[i].x();
			yy[i] = p[i].y();
		}
		if(fill) {
			StdDraw.filledPolygon(xx, yy);}
		else {
			StdDraw.polygon(xx, yy);}
	}
	@Override
	public String getInfo() {
		return this._gsc.toString();
	}
}
