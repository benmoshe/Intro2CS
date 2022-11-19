package week5;
import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
class GCD4Test {
	public static final long A = 2L*3*5*11*19*31*47, B = 3L*7*13*19*47*331, EXP1 = 3*19*47;;
	public static final long AA = A*A, BB = B*B, EXP2 = EXP1*EXP1;
	@Test
	void testGcd1() {
		GCD4.debug_flag = true;
		int a = 21;
		int b = 34;
		long g1 = GCD4.gcd1(a, b);
		if(g1!=1) {
			fail("Wrong answer the GCD("+a+","+b+") should be 1, got "+g1);
		}
	}
	@Test
	void testGcd1b() {
		GCD4.debug_flag = true;
		int a = 21;
		long g1 = GCD4.gcd1(a, a);
		if(g1!=a) {
			fail("Wrong answer the GCD("+a+","+a+") should be 1, got "+g1);
		}
	}

	@Test
	void testGcd1c() {
		GCD4.debug_flag = true;
		int a = 2*3*5*11*19*31;
		int b = 3*7*13*19*47;
		int exp = 3*19;
		long g1 = GCD4.gcd1(a, b);
		if(g1!=exp) {
			fail("Wrong answer the GCD("+a+","+b+") should be "+exp+", got "+g1);
		}

	}
	@Test
	void testGcd12() {
		GCD4.debug_flag = true;
		long g1 = GCD4.gcd1(A, B);
		long g2 = GCD4.gcd2(A, B);
		if(g1!=g2  ) {
			fail("Wrong answer the GCD("+A+","+B+") should have the same answer via gcd1 & gcd2 :, g1= "+g1+"  g2="+g2);
		}
		assertEquals(g1,EXP1); // if(g1!=exp ) fail("Wrong answer the GCD("+a+","+b+") should be "+exp);
	}
	@Test
	void testGcd123() {
		GCD4.debug_flag = false;
		long g1 = GCD4.gcd1(AA, BB);
		long g2 = GCD4.gcd2(AA, BB);
		long g3 = GCD4.gcd3(AA, BB);
		assertEquals(g1,g2);//if(g1!=g3 ) fail("Wrong answer the GCD("+a+","+b+") should have the same answer via gcd1 & gcd2 :, g1= "+g1+"  g2="+g3);
		assertEquals(g1,g3);
		assertEquals(g1,EXP2);
	}
	@Test
	void testGcd2Time2() {
		GCD4.debug_flag = false;
		long start = System.nanoTime();
		long g3 = GCD4.gcd2(AA, BB);
		long end = System.nanoTime();
		double dt = (end-start)/(1000.0*1000);
		System.out.println();
		System.out.println("gcd2("+AA+","+BB+") took  dt="+dt+"  msec.");
		assertTrue(dt<10);
	}
	@Test
	void testGcd3Time1() {
		GCD4.debug_flag = false;
		long start = System.nanoTime();
		long g3 = GCD4.gcd3(AA, BB);
		long end = System.nanoTime();
		double dt = (end-start)/(1000.0*1000);
		assertTrue(dt<1);
		System.out.println();
		System.out.println("gcd3("+AA+","+BB+") took dt="+dt+"  msec.");
	
	}
	@Test
	@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
	void testGcd3Time2() {
		GCD4.debug_flag = false;
		long g3 = GCD4.gcd3(A, B);
	}
}
