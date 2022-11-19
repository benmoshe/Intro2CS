package week5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class BinomTest {

	@Test
	void testBinom() {
		int n = 8, k = 2;
	//	System.out.println("binomFast("+n+","+k+") = ");
		int t = Binom.binom_debug(n,k);
		System.out.println(t);
		assertEquals(t,28);
	}

	@Test
	void testBinomFastIntInt() {
		int n = 30, k=15;
		long start = System.nanoTime();
		int b1 = Binom.binom(n,k);
		long end = System.nanoTime();
		double dt = (end-start)/(1000.0*1000);
		//assertTrue(dt<1);
	//	System.out.println();
		System.out.println("binom("+n+","+k+") took dt="+dt+"  msec.");
	
		start = System.nanoTime();
		int b2 = Binom.binomFast(n,k);
		end = System.nanoTime();
		dt = (end-start)/(1000.0*1000);
		System.out.println("binomFast("+n+","+k+") took dt="+dt+"  msec.");
		assertEquals(b1,b2);
	}
	@Test
	@Timeout(value = 1, unit = TimeUnit.MILLISECONDS)
	void testBinomFast2() {
		int n=30, k=15;
		int b = Binom.binomFast(n,k);
		System.out.println("binom("+n+","+k+")="+b);
	}
}
