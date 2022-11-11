package Exe.Ex2;
/** 
 * This class is a very simple GUI (Graphic User Interface) main class for Ex2 (Intro2CS, Ariel Uni'). 
 * This class uses the StdDraw (see: https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html) 
 * in order to draw two polynoms in a defined range.
 * Note: Do NOT change this class as it should run your Ex2.java solution and present 
 * a GUI as shown in the definition of Ex2.
 * 
 * @author boaz.benmoshe
 */
public class Ex2_GUI {
	public static void main(String[] a) {
		double min = -10, max=10;
		StdDraw.setScale(min, max);
		StdDraw.clear();
		
		double[] po1 = {2,1,-0.7, -0.02,0.02};
		double eps = 0.02;
		double[] po2 = {-3, 0.61, 0.2};
		double[] xx= new double[3];
		double[] yy= new double[3];
		
		//////////////////////////////////////////
		double x1 = Ex2.sameValue(po1,po2, -5,0,Ex2.EPS);
		double x2 = Ex2.sameValue(po1,po2, 0,5,Ex2.EPS);
		double area1 = 0;
		StdDraw.setPenColor(StdDraw.YELLOW);
		int numberOfBoxes = 13;
		double delta = (x2-x1)/numberOfBoxes;
		for(double x = x1;x<x2;x+=delta) {
			double y1 = Ex2.f(po1, x);
			double y2 = Ex2.f(po2, x);
			double y12 = (y1+y2)/2;
			double dist = Math.abs(y1-y2);
			area1 += dist*delta;
			StdDraw.filledRectangle(x+delta/2, y12, delta/2, dist/2);
		}
		double area2 = Ex2.area(po1, po2, x1, x2, numberOfBoxes);
		System.out.println("area: "+area2+"  delta area: "+Math.abs(area1-area2));
		
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(min,0,max,0);
		StdDraw.line(0,min,0,max);
		
		//////////////////////////////////////////
		StdDraw.setPenColor(StdDraw.BLUE);
		double x0 = min;
		double y0 = Ex2.f(po1, x0);
		String pps = Ex2.poly(po1);
		StdDraw.text(0, 4, pps);
		for(double x = min+eps; x<max;x+=eps) {
			double y = Ex2.f(po1, x);
			StdDraw.line(x0, y0, x, y);
			x0=x;y0=y;
			StdDraw.show();
		}
		//////////////////////////////////////////
		for(int x = 1;x<=3;x++) {
			xx[x-1] = x;
			yy[x-1] = Ex2.f(po2,x);
		}
		StdDraw.setPenColor(StdDraw.RED);
		double[] pp = Ex2.PolynomFromPoints(xx, yy);
		double y10 = Ex2.f(pp, x0);
		for(double x = min+eps; x<max;x+=eps) {
			double y1 = Ex2.f(pp, x);
			StdDraw.line(x0, y10, x, y1);
			x0=x;
			y10 = y1;
			StdDraw.show();
		}
		pps = Ex2.poly(po2);
		StdDraw.text(0, -4, pps);
		
		//////////////////////////////////////////
		StdDraw.setPenColor(StdDraw.BLACK);
		double[] ranges = {-10,-5,0,5,10};
		for(int i=0;i<ranges.length-1;i++) {
			double eq = Ex2.sameValue(po1,po2, ranges[i],ranges[i+1],Ex2.EPS);
			double yeq = Ex2.f(po1, eq);
			System.out.println("eq#"+i+"= ["+eq+","+yeq+"]");
			StdDraw.circle(eq, yeq, 0.2);
		}
	} 
}
