package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.Ex4_Const;
import ex4.geometry.Point2D;
import ex4.geometry.Segment2D;

class Segment2DTest {

	private Point2D _p1 = new Point2D(2,5);
	private Point2D _p2 = new Point2D(5,1);
	private Point2D _p3 = new Point2D(4,3);
	@Test
	void testRect2() {
		Segment2D t1 = new Segment2D(_p1,_p2);
		double area = t1.area();
		assertEquals(area,0,Ex4_Const.EPS);
	}

	@Test
	void testCenterOfMass() {
		Segment2D t1 = new Segment2D(_p1,_p2);
		Point2D in = t1.centerOfMass();
		Point2D c = new Point2D(3.5,3);
		assertTrue(c.distance(in)<Ex4_Const.EPS);
	}

	@Test
	void testArea() {
		Segment2D t1 = new Segment2D(_p1,_p2);
		double area = t1.area();
		assertEquals(area,0,Ex4_Const.EPS);
	}

	@Test
	void testPerimeter() {
		Segment2D t1 = new Segment2D(_p1,_p2);
		double per = t1.perimeter();
		assertEquals(per,14,Ex4_Const.EPS);
	}

	@Test
	void testMove() {
		Segment2D t1 = new Segment2D(_p1,_p2);
		Segment2D t1a = new Segment2D(t1);
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
		Segment2D t1 = new Segment2D(_p1,_p2);
		Point2D[] tt = t1.getPoints();
		Segment2D t2 = new Segment2D(tt[0], tt[1]);
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
