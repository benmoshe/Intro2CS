package ex4;
/**
 * This class implements the GUI_shape.
 * Ex4: you should implement this class!
 * @author I2CS
 */
import java.awt.Color;

import ex4.geometry.Circle2D;
import ex4.geometry.GeoShape;
import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;
import ex4.geometry.Segment2D;
import ex4.geometry.Triangle2D;

public class GUIShape implements GUI_Shape{
	private GeoShape _g = null;
	private boolean _fill;
	private Color _color;
	private int _tag;
	
	public GUIShape(GeoShape g, boolean f, Color c, int t) {
		_g = null;
		if (g!=null) {_g = g.copy();}
		_fill= f;
		_color = c;
		_tag = t;
	}
	public GUIShape(GUIShape ot) {
		this(ot._g, ot._fill, ot._color, ot._tag);
	}
	public GUIShape(String s) {
		String[] ww = s.split(",");
		int co = Integer.parseInt(ww[1]);
		_color = new Color(co);
		_fill = Boolean.parseBoolean(ww[2]);
		_tag = Integer.parseInt(ww[3]);
		init(ww);
	}
	@Override
	public GeoShape getShape() {
		return _g;
	}

	@Override
	public void setShape(GeoShape g) {
		_g = g;
	}

	@Override
	public boolean isFilled() {
		return _fill;
	}

	@Override
	public void setFilled(boolean filled) {
		_fill = filled;
	}

	@Override
	public Color getColor() {
		return _color;
	}

	@Override
	public void setColor(Color cl) {
		_color = cl;
	}

	@Override
	public int getTag() {
		return _tag;
	}

	@Override
	public void setTag(int tag) {
		_tag = tag;
		
	}

	@Override
	public GUI_Shape copy() {
		GUI_Shape cp = new GUIShape(this);
		return cp;
	}
	@Override
	public String toString() {
		int co = _color.getBlue();
		co += _color.getGreen()*256;
		co += _color.getRed()*256*256;
		String ans = ""+this.getClass().getSimpleName()+","+co+","+_fill+","+_tag+","+this._g.getClass().getSimpleName()+","+_g;
		return ans;
	}
	private void init(String[] ww) {
		if(ww[4].contentEquals("Point2D")) {_g = new Point2D(ww[5]+","+ww[6]);}
		if(ww[4].contentEquals("Circle2D")) {
			Point2D cen = new Point2D(ww[5]+","+ww[6]);
			double r = Double.parseDouble(ww[7]);
			_g = new Circle2D(cen,r);}
		if(ww[4].contentEquals("Rect2D")) {
			Point2D m1 = new Point2D(ww[5]+","+ww[6]);
			Point2D m2 = new Point2D(ww[7]+","+ww[8]);
			_g = new Rect2D(m1,m2);}
		if(ww[4].contentEquals("Triangle2D")) {
			Point2D p1 = new Point2D(ww[5]+","+ww[6]);
			Point2D p2 = new Point2D(ww[7]+","+ww[8]);
			Point2D p3 = new Point2D(ww[9]+","+ww[10]);
			_g = new Triangle2D(p1,p2,p3);}
		if(ww[4].contentEquals("Segment2D")) {
			Point2D m1 = new Point2D(ww[5]+","+ww[6]);
			Point2D m2 = new Point2D(ww[7]+","+ww[8]);
			_g = new Segment2D(m1,m2);}
	}
}
