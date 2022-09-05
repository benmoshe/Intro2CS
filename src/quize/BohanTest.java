package quize;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BohanTest {

	@Test
	void testStringArr2Set() {
		String[][] s = {{}, {"aac", "aac", "aac"}, {"aa", "bb", "aa", "cc"},{"1","22","333","4"}};
		int[] a= {0,1,3,4};
		for(int i=0;i<4;i++) {
			String[] t = Bohan.stringArr2Set(s[i]);
			assertEquals(t.length, a[i]);
		}
	}

	@Test
	void testMaxMonotoneIncArr() {
		double[][] dd = {{}, {1}, {2,1}, {2,2.1}, {1,2,1}, {4,3,3.2,1}, {1,2,2.1,1,2,3,2.03,2.2},{4,2,3,5,3,1}, {1,-4,1,1.1,1.4,0,0.3}};
		int[] aa = {     0 ,  1,   1,     2,        2,       2,          3,                       3,             4};       
		for(int i=0;i<4;i++) {
			int t = Bohan.maxMonotoneIncArr(dd[i]);
			assertEquals(t, aa[i]);
		}
	}

	@Test
	void testSumOf2() {
		int size = 1000;
		double sum = 0;
		for(int i=0;i<size;i++) {
			int s2 = Bohan.sumOf2();
			sum = sum + s2;
		}
		double ave = sum/size;
		assertEquals(ave,7,0.2);
	}

	@Test
	void testEvenSumProb() {
		int size = 1000;
		double c1=0;
		for(int i=0;i<size;i++) {
			int s2 = Bohan.sumOf2();
			if(s2%2==0) {c1 = c1 +1;}
		}
		double p1 = c1/size;
		double p2 = Bohan.evenSumProb();
		assertEquals(p1,p2,0.1);
	}

	@Test
	void testIntersectionSetSize() {
		int[][] a = {{4,2,4,2,4,2}, {3,2,2,3,2,4,4}, {4,2}, {3,3,3,3}}; // {2,3,4}
		int[][] b = {{0,2,3}, {3,3,3,3,2,3,2,2,3,5,6,7,6,7}, {0}, {3,3,3,3},{0,0},{5,5,0,5}}; //{0,2,3,5,6,7}
		int ans = Bohan.intersectionSetSize(a, b); //{2,3}
		assertEquals(ans,2);
	}

}

