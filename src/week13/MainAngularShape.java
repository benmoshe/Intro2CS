package week13;

import java.awt.Color;

import week4.StdDraw;
import week7.Point2D;

public class MainAngularShape {

	public static void main(String[] args) {
		f1();
		f2();
	}
	public static void f1() {
		// TODO Auto-generated method stub
		Function2D f1 = new F1(0.6,1,3); // f(x) =1+0.6*(cos(3x));
		Point2D p0 = new Point2D(2,2);
		AngularShape as = new AngularShape(f1, p0);
		Point2D[] pp = as.getPoly(130);
		double[] xx = new double[pp.length];
		double[] yy = new double[pp.length];
		for(int i=0;i<pp.length;i++) {
			xx[i] = pp[i].x();
			yy[i] = pp[i].y();
		}
		StdDraw.setScale(0, 10);
		StdDraw.clear();
		StdDraw.filledPolygon(xx, yy);
		StdDraw.show();
	}
	public static void f2() {
		// TODO Auto-generated method stub
		Function2D f1 = new F1(1,2,3);
		Function2D f2 = new F1(0.4,0.1,13);
		Function2D f12 = new ADD_F(f1,f2);
		Point2D p0 = new Point2D(6,6);
		AngularShape as = new AngularShape(f12, p0);
		
		Point2D[] pp = as.getPoly(120);
		double[] xx = new double[pp.length];
		double[] yy = new double[pp.length];
		for(int i=0;i<pp.length;i++) {
			xx[i] = pp[i].x();
			yy[i] = pp[i].y();
		}
	//	StdDraw.setScale(0, 10);
	//	StdDraw.clear();
		StdDraw.setPenColor(Color.BLUE);
		StdDraw.filledPolygon(xx, yy);
		StdDraw.show();
	}
}
