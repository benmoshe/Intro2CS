package ExeEx2Solution;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * This JUnit class represents a JUnit (unit testing) for Ex2 - 
 * It contains testing functions for the polynum functions as define in Ex2.
 * @author boaz.ben-moshe
 *
 */

class Ex2Test {
	static final double[] P1 ={2,0,3, -1,0}, P2 = {0.1,0,1, 0.1,3};
	static double[] po1 = null, po2 = null;
	static double[] po3 = {2,1,-0.7, -0.02,0.02};
	static double[] po4 = {-3, 0.61, 0.2};
	
	@BeforeEach
	public void initPrameters() {
		po1 = Ex2.compactCopy(P1); 
		po2 = Ex2.compactCopy(P2); 
	}
	@Test
	/**
	 * Tests that f(x) == poly(x).
	 */
	void testF() {
		double fx0 = Ex2.f(po1, 0);
		double fx1 = Ex2.f(po1, 1);
		double fx2 = Ex2.f(po1, 2);
		assertEquals(fx0, 2, Ex2.EPS);
		assertEquals(fx1, 4, Ex2.EPS);
		assertEquals(fx2, 6, Ex2.EPS);
	}
	@Test
	/**
	 * Tests that p1(x) + p2(x) == (p1+p2)(x)
	 */
	void testF2() {
		double x = Math.PI;
		double[] po12 = Ex2.add(po1, po2);
		double f1x = Ex2.f(po1, x);
		double f2x = Ex2.f(po2, x);
		double f12x = Ex2.f(po12, x);
		assertEquals(f1x + f2x, f12x, Ex2.EPS);
	}
	@Test
	/**
	 * Tests that |po1(3.1958)| < EPS
	 */
	void testRoot() {
		double x12 = Ex2.root(po1, 0, 10, Ex2.EPS);
		assertEquals(x12, 3.1958, Ex2.EPS);
	}
	@Test
	/**
	 * Tests that both root functions (recursive & iterative) computes
	 * the same root. 
	 */
	void testRoot2() {
		double x12 = Ex2.root(po1, 0, 10, Ex2.EPS);
		double x12a = Ex2.root_rec(po1, 0, 10, Ex2.EPS);
		assertEquals(x12, x12a, Ex2.EPS);
	}
	
	@Test
	/**
	 * Tests that p1+p2+ (-1*p2) == p1
	 */
	void testAdd() {
		double[] p12 = Ex2.add(po1, po2);
		double[] minus1 = {-1};
		double[] pp2 = Ex2.mul(po2, minus1);
		double[] p1 = Ex2.add(p12, pp2);
		assertTrue(Ex2.equals(p1, po1));
	}
	@Test
	/**
	 * Tests that p1+p2 == p2+p1
	 */
	void testAdd2() {
		double[] p12 = Ex2.add(po1, po2);
		double[] p21 = Ex2.add(po2, po1);
		assertTrue(Ex2.equals(p12, p21));
	}
	@Test
	/**
	 * Tests that p1+0 == p1
	 */
	void testAdd3() {
		double[] p1 = Ex2.add(po1, Ex2.ZERO);
		assertTrue(Ex2.equals(p1, po1));
	}
	@Test
	/**
	 * Tests that p1*0 == 0 
	 */
	void testMul1() {
		double[] p1 = Ex2.mul(po1, Ex2.ZERO);
		assertTrue(Ex2.equals(p1, Ex2.ZERO));
	}
	@Test
	/**
	 * Tests that p1*p2 == p2*p1
	 */
	void testMul2() {
		double[] p12 = Ex2.mul(po1, po2);
		double[] p21 = Ex2.mul(po2, po1);
		assertTrue(Ex2.equals(p12, p21));
	}
	@Test
	/**
	 * Tests that p1(x) * p2(x) = (p1*p2)(x), 
	 */
	void testMulDoubleArrayDoubleArray() {
		double[] xx = {0,1,2,3,4.1,-15.2222};
		double[] p12 = Ex2.mul(po1, po2);
		for(int i = 0;i<xx.length;i=i+1) {
			double x = xx[i];
			double f1x = Ex2.f(po1, x);
			double f2x = Ex2.f(po2, x);
			double f12x = Ex2.f(p12, x);
			assertEquals(f12x, f1x*f2x, Ex2.EPS);
		}
	}
	@Test
	/**
	 * Tests a simple derivetive examples - till ZERO.
	 */
	void testDerivativeArrayDoubleArray() {
		double[] p = {1,2,3}; // 3X^2+2x+1
		double[] pt = {2,6}; // 6x+2
		double[] dp1 = Ex2.derivative(p); // 2x + 6
		double[] dp2 = Ex2.derivative(dp1); // 2
		double[] dp3 = Ex2.derivative(dp2); // 0
		double[] dp4 = Ex2.derivative(dp3); // 0
		assertTrue(Ex2.equals(dp1, pt));
		assertTrue(Ex2.equals(Ex2.ZERO, dp3));
		assertTrue(Ex2.equals(dp4, dp3));
	}
	@Test
	/** 
	 * Tests the parsing of a polynom in a String like form.
	 */
	public void testFromString() {
		double[] p = {-1.1,2.3,3.1}; // 3.1X^2+ 2.3x -1.1
		String sp2 = "3.1x^2 +2.3x -1.1";
		String sp = Ex2.poly(p);
		double[] p1 = Ex2.getPolynomFromString(sp);
		double[] p2 = Ex2.getPolynomFromString(sp2);
		boolean isSame1 = Ex2.equals(p1, p);
		boolean isSame2 = Ex2.equals(p2, p);
		if(!isSame1) {fail();}
		if(!isSame2) {fail();}
		assertEquals(sp, Ex2.poly(p1));
	}
	@Test
	/**
	 * Tests the equality of pairs of arrays.
	 */
	public void testEquals() {
		double[][] d1 = {{0}, {1}, {1,2,0,0}};
		double[][] d2 = {Ex2.ZERO, {1+Ex2.EPS/2}, {1,2}};
		double[][] xx = {{-2*Ex2.EPS}, {1+Ex2.EPS*1.2}, {1,2,Ex2.EPS/2}};
		for(int i=0;i<d1.length;i=i+1) {
			assertTrue(Ex2.equals(d1[i], d2[i]));
		}
		for(int i=0;i<d1.length;i=i+1) {
			assertFalse(Ex2.equals(d1[i], xx[i]));
		}
	}
	@Test
	/**
	 * Tests if the intersection between a polynom and the Zero function is 
	 * the same as the root function.
	 */
	public void testSameValue() {
		double x1=0, x2=4;
		double r1 = Ex2.root(po1, x1, x2, Ex2.EPS);
		double r2 = Ex2.root(po2, x1, x2, Ex2.EPS);
		double rs1 = Ex2.sameValue(po1,Ex2.ZERO, x1, x2, Ex2.EPS);
		double rs2 = Ex2.sameValue(po2,Ex2.ZERO, x1, x2, Ex2.EPS);
		assertEquals(r1,rs1,Ex2.EPS);
		assertEquals(r2,rs2,Ex2.EPS);
	}
	@Test
	/**
	 * Tests is the sameValue function is symetric.
	 */
	public void testSameValue2() {
		double x1=0, x2=4;
		double rs1 = Ex2.sameValue(po1,po2, x1, x2, Ex2.EPS);
		double rs2 = Ex2.sameValue(po2,po1, x1, x2, Ex2.EPS);
		assertEquals(rs1,rs2,Ex2.EPS);
	}
	@Test
	/**
	 * Test the area function - it should be symetric.
	 */
	public void testArea() {
		double x1=0, x2=4;
		double a1 = Ex2.area(po1, po2, x1, x2, 1000);
		double a2 = Ex2.area(po2, po1, x1, x2, 1010);
		assertEquals(a1,a2,	Ex2.EPS);
	}
	////////////////// Testing util functions ///////////////
	@Test
	public void testGetCoef() {
		String[] coefs = {"x", "-x", "-3x", "-.13x^4"};
		double[] coefn = {1, -1, -3, -0.13};
		for(int i=0;i<coefs.length;i=i+1) {
			double d = Ex2.getCoef(coefs[i]);
			assertEquals(d, coefn[i], Ex2.EPS);
		}
	}
	@Test
	public void testGetPower() {
		String[] powerS = {"x", "-x", "+3.1", "-.13x^4"};
		double[] powerN = {1, 1, 0, 4};
		for(int i=0;i<powerS.length;i=i+1) {
			double d = Ex2.getPower(powerS[i]);
			assertEquals(d, powerN[i]);
		}
	}

}
