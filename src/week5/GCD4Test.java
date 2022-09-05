package week5;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class GCD4Test {
	@Test
	void testGcd1() {
		int a = 21;
		int b = 34;
		int g1 = GCD4.gcd1(a, b);
		if(g1!=1) {
			fail("Wrong answer the GCD("+a+","+b+") should be 1, got "+g1);
		}
	}
	@Test
	void testGcd1b() {
		int a = 21;
		int g1 = GCD4.gcd1(a, a);
		if(g1!=a) {
			fail("Wrong answer the GCD("+a+","+a+") should be 1, got "+g1);
		}
	}

	@Test
	void testGcd1c() {
		int a = 2*3*5*11*19*31;
		int b = 3*7*13*19*47;
		int exp = 3*19;
		int g1 = GCD4.gcd1(a, b);
		if(g1!=exp) {
			fail("Wrong answer the GCD("+a+","+b+") should be "+exp+", got "+g1);
		}
		
	}
	@Test
	void testGcd12() {
		int a = 2*3*5*11*19*31*47;
		int b = 3*7*13*19*47*331;
		int exp = 3*19*47;
		int g1 = GCD4.gcd1(a, b);
		int g2 = GCD4.gcd2(a, b);
		if(g1!=g2 ) {
			fail("Wrong answer the GCD("+a+","+b+") should have the same answer via gcd1 & gcd2 :, g1= "+g1+"  g2="+g2);
		}
		
	}
}
