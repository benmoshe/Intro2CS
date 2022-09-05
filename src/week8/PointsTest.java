package week8;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointsTest {

	@Test
	void testPoints() {
		Points ps = new Points();
		assertNotNull(ps);
	}

	@Test
	void testSize() {
		int size = 10;
		Points ps = new Points();
		for(int i=0;i<size;i=i+1) {
			Point p = randomPoint(100,100);
			ps.add(p);
		}
		assertEquals(ps.size(), size);
	}

	@Test
	void testGet() {
		Point p = randomPoint(100,100);
		Points ps = new Points();
		ps.add(p);
		Point p0 = ps.get(0);
		assertEquals(p,p0);
	}

	@Test
	void testAdd() {
		int size = 1000;
		Points ps = new Points();
		for(int i=0;i<size;i=i+1) {
			Point p = randomPoint(10,10);
			ps.add(p);
		}
		assertEquals(ps.size(), size);
	}
	private static Point randomPoint(double x, double y) {
		double x0 = Math.random()*x;
		double y0 = Math.random()*y;
		Point ans = new Point(x0,y0);
		return ans;
	}
}
