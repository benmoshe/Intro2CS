package week7;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class Circle2DTest {

	@Test
	void testCircle2DPoint2DDouble() {
		double x =1, y =2, r = 3.1;
		Point2D c = new Point2D(x,y);
		Circle2D cc = new Circle2D(c, r);
		assertEquals(cc.getRad(), r, Point2D.EPS);
		if(!c.close2equals(cc.getCenter())) {
			fail("Wrong centers - should be the same");
		}
	}

	@Test
	void testCircle2DString() {
		double x =1, y =2, r = 3.1;
		Point2D c = new Point2D(x,y);
		Circle2D cc = new Circle2D(c, r);
		String s = cc.toString();
		Circle2D cc2 = new Circle2D(s);
		assertEquals(s, cc2.toString());
	}

	@Test
	void testPointsInCircle() {
		int size =1000;
		ArrayList<Point2D> arr2 = new ArrayList<Point2D>();
		Point2D[] arr = new Point2D[size];
		double x =1, y =2, r = 3.1;
		Point2D c = new Point2D(x,y);
		Circle2D cc = new Circle2D(c, r);
		for(int i=0;i<size;i=i+1) {
			arr[i] = cc.getRandomInnerPoint2();
			System.out.println(arr[i]);
		}	
	}
/*
	@Test
	void testGetCenter() {
		fail("Not yet implemented");
	}

	@Test
	void testToString() {
		fail("Not yet implemented");
	}

	@Test
	void testArea() {
		fail("Not yet implemented");
	}

	@Test
	void testPeremiter() {
		fail("Not yet implemented");
	}

	@Test
	void testIsIn() {
		fail("Not yet implemented");
	}
*/
}
