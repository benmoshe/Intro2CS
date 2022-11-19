package week4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Week4ClassExamplesTest {

	@Test
	void testIsPerfect() {
		int[] perfects = {6,28};
		for(int i=0;i<perfects.length;i=i+1) {
			boolean ip = Week4ClassExamples.isPerfect(perfects[i]);
			if(ip == false) {
				fail("Should be a perfect number "+perfects[i]);
			}
		}
		
	}
	@Test
	void testIsNotPerfect() {
		int[] none_perfects = {1,12, 13};
		for(int i=0;i<none_perfects.length;i=i+1) {
			boolean ip = Week4ClassExamples.isPerfect(none_perfects[i]);
			if(ip == true) {
				fail("Should be a perfect number "+none_perfects[i]);
			}
		}
		
	}

}
