package week9;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Circle2DTest {

	@Test
	void testCircle2DPoint2DDouble() {
		double x=1,y=2, r=3;
		Point2D p = new Point2D(x,y);
		Circle2D c = new Circle2D(p, r);
		assertEquals(c.getRadius(), r);
		assertEquals(c.getCenter(), p);
		if(p==c.getCenter()) {
			fail("ERR: Note: p & the center should be pointing to different memory addresses!");
		}
	}

	@Test
	void testCircle2DCircle2D() {
//		fail("Not yet implemented");
	}


	@Test
	void testIsIn() {
		double x=1,y=2, r=3;
		Point2D p = new Point2D(x,y);
		Point2D p1 = new Point2D(2,3); // should be inside;
		Point2D p2 = p1.add(p1).add(p1); // ????
		Circle2D c = new Circle2D(p, r);
		boolean b1 = c.isIn(p1); // should be inside;
		assertTrue(b1);
		boolean b2 = c.isIn(p2); // should be outside;
		assertFalse(b2);
	}

}
