package week4;
/** This is NOT a Junit class - as it tests GUI components which 
 * should not be tested using Junit.
 * 
 * The Code uses the STDDraw class: 
 * https://introcs.cs.princeton.edu/java/stdlib/javadoc/StdDraw.html
 * @author boaz.benmoshe
 *
 */
public class StdDrawTest {
	public static void main(String[] a) {
		testSimpleGUI();
		testClip();
		testDrawGraphs();
		
	}
	public static void testSimpleGUI() {
		StdDraw.setScale(-2, +2);
		 StdDraw.square(.2, .8, .1);
		  StdDraw.filledSquare(.8, .8, .2);
		  StdDraw.circle(.8, .2, .2);
		  StdDraw.setPenColor(StdDraw.BOOK_RED);
		  StdDraw.setPenRadius(.02);
		  StdDraw.arc(.8, .2, .1, 200, 45);
		  // draw a blue diamond
		  StdDraw.setPenRadius();
		  StdDraw.setPenColor(StdDraw.BOOK_BLUE);
		  double[] x = { .1, .2, .3, .2 };
		  double[] y = { .2, .3, .2, .1 };
		  StdDraw.filledPolygon(x, y);
		  // text
		  StdDraw.setPenColor(StdDraw.BLACK);
		  StdDraw.text(0.2, 0.5, "black text");
		  StdDraw.setPenColor(StdDraw.WHITE);
		  StdDraw.text(0.8, 0.8, "white text");
		  StdDraw.show();
		  StdDraw.pause(2000);
		  StdDraw.clear();
	}
	public static void testClip() {
		//StdDraw.setScale(-2, +2);
		StdDraw.enableDoubleBuffering();
		for (double t = 0.0; t<2*Math.PI; t += 0.02) {
			double x = Math.sin(t);
			double y = Math.cos(t);
			StdDraw.clear();
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.filledCircle(x, y, 0.1);
			StdDraw.setPenColor(StdDraw.BLACK);
			StdDraw.filledCircle(-x, -y, 0.05);
			StdDraw.show();
			StdDraw.pause(20);
		}
	}
	public static void testDrawGraphs() {
		StdDraw.clear();
		double eps = 0.02;
		for(double x = -2; x<2;x+=eps) {
			double x0 = x;
			double x1 = x0+eps;
			double y0 = Math.sin(x0);
			double y1 = Math.sin(x1);
			double t0 = 1.5*Math.cos(x0*3);
			double t1 = 1.5*Math.cos(x1*3);
			double z0 = 1.5*Math.cos(x0*x0*3);
			double z1 = 1.5*Math.cos(x1*x1*3);
			StdDraw.setPenColor(StdDraw.RED);
			StdDraw.line(x0, y0, x1, y1);
			StdDraw.setPenColor(StdDraw.BLUE);
			StdDraw.line(x0, t0, x1, t1);
			StdDraw.setPenColor(StdDraw.CYAN);
			StdDraw.line(x0, z0, x1, z1);
			StdDraw.show();
			StdDraw.pause(10);
		}
	}
	 
}
