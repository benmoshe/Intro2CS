package week8;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import week7.Point2D;

class PointContainerTest {

	@Test
	void testPoints() {
		PointContainer ps = new PointContainer();
		assertNotNull(ps);
	}

	@Test
	void testSize() {
		int size = 10;
		PointContainer ps = new PointContainer();
		for(int i=0;i<size;i=i+1) {
			Point2D p = randomPoint(100,100);
			ps.add(p);
		}
		assertEquals(ps.size(), size);
	}

	@Test
	void testGet() {
		Point2D p = randomPoint(100,100);
		PointContainer ps = new PointContainer();
		ps.add(p);
		Point2D p0 = ps.get(0);
		assertEquals(p,p0);
	}

	@Test
	void testAdd() {
		int size = 1000;
		PointContainer ps = new PointContainer();
		for(int i=0;i<size;i=i+1) {
			Point2D p = randomPoint(10,10);
			ps.add(p);
		}
		assertEquals(ps.size(), size);
	}
	private static Point2D randomPoint(double x, double y) {
		double x0 = Math.random()*x;
		double y0 = Math.random()*y;
		Point2D ans = new Point2D(x0,y0);
		return ans;
	}
}
