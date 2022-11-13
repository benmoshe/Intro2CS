package week4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Week4ClassExamplesTest {

	@Test
	void testIsPerfect() {
		int[] perfect = {6,28};

		boolean shouldBeTrue = true;
		for(int i=0;i<perfect.length;i=i+1) {
			int nn = perfect[i];
			boolean t = Week4ClassExamples.isPerfect(nn);
			//shouldBeTrue = shouldBeTrue & t;
			if(t==false) {shouldBeTrue=false;}
		}
		if(!shouldBeTrue) {
			fail("Err: should be true - an array of perfect numbers!");}
	}
	@Test
	void testIsNotPerfect() {
		int[] notPerfect = {1,2,12};

		boolean sh = false;
		for(int i=0;i<notPerfect.length;i=i+1) {
			int nn = notPerfect[i];
			boolean t = Week4ClassExamples.isPerfect(nn);
			sh = sh | t;
		}
		if(sh) {
			fail("Err: should be false - an array of perfect numbers!");}
	}
}
