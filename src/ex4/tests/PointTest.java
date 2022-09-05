package ex4.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import ex4.geometry.Point2D;
import ex4.geometry.Rect2D;

class PointTest {

	@Test
	void test0() {
		Point2D p1 = new Point2D(1,2.1);
		Point2D p2 = new Point2D(1,2.1);
		Point2D p3 = new Point2D(1,2.1);
		assertEquals(p1,p1);
		assertEquals(p1,p2);
		assertEquals(p1,p3);
		assertEquals(p3,p2);
		Point2D eps = new Point2D(Point2D.EPS, Point2D.EPS);
		p1.move(eps);
		assertNotEquals(p1,p2);
		
	}
	@Test
	void test1() {
		Point2D p1 = new Point2D(1,2.1);
		Point2D p2 = new Point2D(1,2.1);
		Point2D p3 = new Point2D(1,2.1);
		
		assertTrue(p1.contains(p2));
		assertTrue(p1.contains(p1));
		assertTrue(p2.contains(p1));
		
		Point2D eps = new Point2D(Point2D.EPS, Point2D.EPS);
		p1.move(eps);
		assertFalse(p1.contains(p2));
		
	}
	@Test
	void test2() {
		Point2D p1 = new Point2D(1,2.1);
		Point2D p2 = new Point2D(1,2.1);
		Point2D p3 = new Point2D(1,2.1);
		
		Rect2D r1 = new Rect2D(p1,p2);
		assertTrue(r1.contains(p1));
		assertTrue(r1.contains(p2));
		
		Point2D eps = new Point2D(Point2D.EPS, Point2D.EPS);
		p1.move(eps);
		assertFalse(r1.contains(p1));
	}
}
