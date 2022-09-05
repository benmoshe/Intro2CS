package ex4.tests;
import ex4.geometry.Rect2D;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.Ex4_Const;
import ex4.geometry.Point2D;
class Rect2DTest {

	private Point2D _p1 = new Point2D(2,5);
	private Point2D _p2 = new Point2D(5,1);
	private Point2D _p3 = new Point2D(4,3);
	@Test
	void testRect2() {
		Rect2D t1 = new Rect2D(_p1,_p2);
		double area = t1.area();
		assertEquals(area,12,Ex4_Const.EPS);
	}

	@Test
	void testContains() {
		Rect2D t1 = new Rect2D(_p1,_p2);
		Point2D in = t1.centerOfMass();
		assertTrue(t1.contains(in));
		in.move(_p3);
		assertFalse(t1.contains(in));
	}

	@Test
	void testCenterOfMass() {
		Rect2D t1 = new Rect2D(_p1,_p2);
		Point2D in = t1.centerOfMass();
		Point2D c = new Point2D(3.5,3);
		assertTrue(c.distance(in)<Ex4_Const.EPS);
	}

	@Test
	void testArea() {
		Rect2D t1 = new Rect2D(_p1,_p2);
		double area = t1.area();
		assertEquals(area,12,Ex4_Const.EPS);
	}

	@Test
	void testPerimeter() {
		Rect2D t1 = new Rect2D(_p1,_p2);
		double per = t1.perimeter();
		assertEquals(per,14,Ex4_Const.EPS);
	}

	@Test
	void testMove() {
		Rect2D t1 = new Rect2D(_p1,_p2);
		Rect2D t1a = new Rect2D(t1);
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
		Rect2D t1 = new Rect2D(_p1,_p2);
		Point2D[] tt = t1.getPoints();
		Rect2D t2 = new Rect2D(tt[0], tt[1]);
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
