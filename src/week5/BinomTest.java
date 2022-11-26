package week5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
/**
 * binom(8,2) = b(7,1) + b(7,2)
binom(7,2) = b(6,1) + b(6,2)
binom(6,2) = b(5,1) + b(5,2)
binom(5,2) = b(4,1) + b(4,2)
binom(4,2) = b(3,1) + b(3,2)
binom(3,2) = b(2,1) + b(2,2)
binom(2,1) = b(1,0) + b(1,1)
binom(3,1) = b(2,0) + b(2,1)
binom(2,1) = b(1,0) + b(1,1)
binom(4,1) = b(3,0) + b(3,1)
binom(3,1) = b(2,0) + b(2,1)
binom(2,1) = b(1,0) + b(1,1)
binom(5,1) = b(4,0) + b(4,1)
binom(4,1) = b(3,0) + b(3,1)
binom(3,1) = b(2,0) + b(2,1)
binom(2,1) = b(1,0) + b(1,1)
binom(6,1) = b(5,0) + b(5,1)
binom(5,1) = b(4,0) + b(4,1)
binom(4,1) = b(3,0) + b(3,1)
binom(3,1) = b(2,0) + b(2,1)
binom(2,1) = b(1,0) + b(1,1)
binom(7,1) = b(6,0) + b(6,1)
binom(6,1) = b(5,0) + b(5,1)
binom(5,1) = b(4,0) + b(4,1)
binom(4,1) = b(3,0) + b(3,1)
binom(3,1) = b(2,0) + b(2,1)
binom(2,1) = b(1,0) + b(1,1)
28

binom(30,15) took dt=399.28  msec.
binomFast(30,15) took dt=0.061  msec.
binom(30,15)=155117520
 * @author boazben-moshe
 *
 */
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
