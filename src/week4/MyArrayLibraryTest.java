package week5;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyArrayLibraryTest {

	/**
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
*/
	@Test
	void testMax() {
		int[] arr = {0,1,2,3,4,5,6,1,2,3,4};
		int maxInd = MyArrayLibrary.maxIndex(arr);
		if(maxInd!=6) {
			fail("Wrong maxIndex  - should be 6");
		}
	}
	@Test
	void testMin() {
		int[] arr = {0,1,2,3,4,-3,5,6,1,2,3,4};
		int maxInd = MyArrayLibrary.minIndex(arr);
		if(maxInd!=5) {
			fail("Wrong maxIndex  - should be 6");
		}
	}
	@Test
	void testAve1() {
		int[] arr = {1};
		double ave = MyArrayLibrary.average(arr);
		assertEquals(ave, 1, 0.000001);
	}
	@Test
	void testAve2() {
		int[] arr = {1,2};
		double ave = MyArrayLibrary.average(arr);
		assertEquals(ave, 1.5, 0.000001);
	}
	@Test
	void testRandomIntArrayIntInt() {
		int max_value = 100, size = 1000;
		int[]  arr1 = MyArrayLibrary.randomIntArray(size, max_value);
		double ave = MyArrayLibrary.average(arr1);
		double exp_ave = max_value/2.0;
		double err = Math.abs(exp_ave - ave);
		assertEquals(exp_ave, ave, max_value/10.0);
		// if(err>max_value/10.0) {
			// fail("Wrong average");}
	}

	@Test
	void testRandomIntArrayIntIntInt() {
		int size = 1000, min = 1, max = 6;
		int[]  arr1 = MyArrayLibrary.randomIntArray(size, min, max);
		double ave = MyArrayLibrary.average(arr1);
		double exp_ave = (max+min)/2.0;
		double err = Math.abs(exp_ave - ave);
		assertEquals(exp_ave, ave, 0.1);
		// if(err>max_value/10.0) {
			// fail("Wrong average");}
	}
}
