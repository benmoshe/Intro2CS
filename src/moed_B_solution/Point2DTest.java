package moed_B_solution;
import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;
class Point2DTest {


	@Test
	void testAngle_deg() {
		Point2D p0 = Point2D.ORIGIN;
		double res = 36;
		double da = 2*Math.PI/res;
		for(double a = 0;a<2*Math.PI;a=a+da) {
			double d_deg = Math.toDegrees(a);
			double x = Math.cos(a), y = Math.sin(a);
			Point2D p1 = new Point2D(x,y);
			double ang = p0.angle_deg(p1);
			assertEquals(ang,d_deg,0.001);
			System.out.println(a+","+d_deg+","+ang);
		}
	}

}
