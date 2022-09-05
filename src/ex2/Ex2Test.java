package ex2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class Ex2Test {
	static double[] po1={2,0,3, -1,0}, 
			po2 = {0.1,0,1, 0.1,3};
	static double[][] polys = {{-1}, {1,2,3,4}, {-1,-2,-3,-4}};
	static final double EPS = 0.0001;

	@Test
	void testF() {
		double fx0 = Ex2.f(po1, 0);
		double fx1 = Ex2.f(po1, 1);
		double fx2 = Ex2.f(po1, 2);
		assertEquals(fx0,2);
		assertEquals(fx1,4);
		assertEquals(fx2,6);
	}

	@Test
	void testRoot() {
		double x12 = Ex2.root_itertive(po1, 0, 10, EPS);
		double fx12 = Ex2.f(po1, x12);
		assertEquals(fx12, 0, EPS);
	}
	@Test
	void testRoot2() {
		double x12 = Ex2.root_itertive(po1, 0, 100000, EPS/1000);
		double fx12 = Ex2.f(po1, x12);
		assertEquals(fx12, 0, EPS);
	}
	
	@Test
	void testAdd() {
		double[] p12 = Ex2.add(po1, po2);
		double[] minus1 = {-1};
		double[] pp2 = Ex2.mul(po2, minus1);
		double[] p1 = Ex2.add(p12, pp2);
		assertEquals(Ex2.poly(po1), Ex2.poly(p1));
	}

	@Test
	void testMulDoubleArrayDoubleArray() {
		double[] p12 = Ex2.add(po1, po2);
		double dd = Ex2.f(p12, 5);
		assertEquals(dd, 1864.6, EPS);
	}
	@Test
	void testDerivativeArrayDoubleArray() {
		double[] p = {1,2,3}; // 3X^2+2x+1
		double[] dp1 = {2,6}; // 6x+2
		double[] dp2 = Ex2.derivative(p);
		assertEquals(dp1[0], dp2[0],EPS);
		assertEquals(dp1[1], dp2[1],EPS);
		assertEquals(dp1.length, dp2.length);
	}

	@Test
	void testZero() {
		double[] p = {};
		double[] p0 = {0};
		double[] p00 = {0,0};
		double[] p000000 = {0,0,0,0,0,0};
		for(int i=0;i<10;i=i+1) {
			assertEquals(Ex2.f(p,i),0 );
			assertEquals(Ex2.f(p0,i),0 );
			assertEquals(Ex2.f(p00,i),0 );
			assertEquals(Ex2.f(p000000,i),0 );
		}
	}
	@Test
	void testCompact() {
		double[] pp2 = {1};
		for(int i=0;i<10;i=i+1) {
			 pp2 = Ex2.mul(po2, pp2);
		}
		double[] minus1 = {-1};
		double[] pp3 = Ex2.mul(pp2, minus1);
		pp2 = Ex2.add(pp2, pp3);
		pp2 = Ex2.compact(pp2);
		int l = pp2.length;
		assertTrue(l<2);
	}
} 
