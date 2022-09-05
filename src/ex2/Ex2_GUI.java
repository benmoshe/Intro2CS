package ex2;
import week4.StdDraw;
/** 
 * This class is a very simple GUI (Graphic User Interface) main which 
 * uses the STDDraw (see: https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html) 
 * in order to draw a polynom in a defined range.
 * @author boaz.benmoshe
 *
 */
public class Ex2_GUI {
	public static void main(String[] a) {
		double min = -10, max=10;
		StdDraw.setScale(min, max);
		StdDraw.clear();
		StdDraw.setPenColor(StdDraw.BLACK);
		StdDraw.line(min,0,max,0);
		StdDraw.line(0,min,0,max);
		double[] po = {3,1,-0.7, -0.02,0.02};
		double eps = 0.02;
		StdDraw.setPenColor(StdDraw.BLUE);
		double x0 = min;
		double y0 = Ex2.f(po, x0);
		for(double x = min+eps; x<max;x+=eps) {
			double y = Ex2.f(po, x);
			StdDraw.line(x0, y0, x, y);
			x0=x;y0=y;
			StdDraw.show();
		}
	} 
}
