package week3;
/**
 * Make sure you can 
 */
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GCD_FunctionsTest {

	@Test
	void testGcd5() {
		int x= 12, y=20;
		if(GCD_Functions.gcd0(x, y)!= GCD_Functions.gcd5(x, y)) {
			
			fail("Not yet implemented");
		}
	}
/*
	@Test
	void testGcd6() {
		fail("Not yet implemented");
	}

	@Test
	void testGcd0() {
		fail("Not yet implemented");
	}
*/
	@Test
	void testIsPrime() {
		int[] primes = {2,3,5,3331};
		int[] notPrime = {14,9,33333*3331};
		for(int i=0;i<primes.length;i=i+1) {
			boolean a = GCD_Functions.isPrime(primes[i]);
			if(a==false) {fail();}
		}
		for(int i=0;i<notPrime.length;i=i+1) {
			boolean a = GCD_Functions.isPrime(notPrime[i]);
			if(a==true) {fail();}
		}
	}

}
