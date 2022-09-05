package ex4.tests;
import ex4.Ex4;
import ex4.Ex4_Const;
import ex4.geometry.Point2D;
import ex4.geometry.Triangle2D;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/** this is a simple JUnit test class for Triangle2D
 * 
 * @author boaz.ben-moshe
 *
 */
class Triangle2DTest {
	private Point2D _p1 = new Point2D(0,0);
	private Point2D _p2 = new Point2D(8,0);
	private Point2D _p3 = new Point2D(4,3);
	@Test
	void testTriangle2D() {
		Triangle2D t1 = new Triangle2D(_p1,_p2,_p3);
		double area = t1.area();
		assertEquals(area,12,Ex4_Const.EPS);
	}

	@Test
	void testContains() {
		Triangle2D t1 = new Triangle2D(_p1,_p2,_p3);
		Point2D in = t1.centerOfMass();
		assertTrue(t1.contains(in));
		in.move(_p3);
		assertFalse(t1.contains(in));
	}

	@Test
	void testCenterOfMass() {
		Triangle2D t1 = new Triangle2D(_p1,_p2,_p3);
		Point2D in = t1.centerOfMass();
		Point2D c = new Point2D(4,1);
		assertTrue(c.distance(in)<Ex4_Const.EPS);
	}

	@Test
	void testArea() {
		Triangle2D t1 = new Triangle2D(_p1,_p2,_p3);
		double area = t1.area();
		assertEquals(area,12,Ex4_Const.EPS);
	}

	@Test
	void testPerimeter() {
		Triangle2D t1 = new Triangle2D(_p1,_p2,_p3);
		double per = t1.perimeter();
		assertEquals(per,18,Ex4_Const.EPS);
	}

	@Test
	void testMove() {
		Triangle2D t1 = new Triangle2D(_p1,_p2,_p3);
		Triangle2D t1a = new Triangle2D(t1);
		assertEquals(t1, t1a);
		Point2D p1 = new Point2D(0,0.1);
		t1a.move(p1);
		assertNotEquals(t1, t1a);
		Point2D p11 = new Point2D(-p1.x(), -p1.y());
		t1a.move(p11);
		assertEquals(t1, t1a);
	}

	@Test
	void testCopy() {
	//	fail("Not yet implemented");
	}

	@Test
	void testGetPoints() {
		Triangle2D t1 = new Triangle2D(_p1,_p2,_p3);
		Point2D[] tt = t1.getPoints();
		Triangle2D t2 = new Triangle2D(tt[1],tt[0],tt[2]);
		assertEquals(t1,t2);
		assertEquals(t1.area(),t2.area(), Ex4_Const.EPS);
		assertEquals(t1.perimeter(),t2.perimeter(), Ex4_Const.EPS);
		t2.move(_p2);
		assertNotEquals(t1, t2);
		assertEquals(t1.area(),t2.area(), Ex4_Const.EPS);
		assertEquals(t1.perimeter(),t2.perimeter(), Ex4_Const.EPS);
	}

	@Test
	void testToString() {
	//	fail("Not yet implemented");
	}

}
