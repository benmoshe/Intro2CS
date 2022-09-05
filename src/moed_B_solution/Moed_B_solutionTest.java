package moed_B_solution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Moed_B_solutionTest {

	@Test
	void testGcdIntArray() {
		int[][] t = {{1}, {1,2}, {2,2,3}, {4,4,4}, {12,18,30}};
		int[] ans = {1,1,1,4,6};
		for(int i=0;i<ans.length;i=i+1) {
			assertEquals(ans[i], Moed_B_solution.gcd(t[i]));
		}
	}

	@Test
	void testIsSet() {
		int[][] sets = {{}, {1}, {1,2}, {3,2,-1}};
		int[][] not_sets = {{0,0}, {1,2,1}, {3,1,2,1}};
		for(int i=0;i<sets.length;i=i+1) {
			ListInterface l = new LinkedList();
			for(int a = 0;a<sets[i].length;a=a+1) {l.addAt(sets[i][a], 0);}
			boolean t = Moed_B_solution.isSet(l);
			assertTrue(t);
		}
		for(int i=0;i<not_sets.length;i=i+1) {
			ListInterface l = new LinkedList();
			for(int a = 0;a<not_sets[i].length;a=a+1) {l.addAt(not_sets[i][a], 0);}
			boolean t = Moed_B_solution.isSet(l);
			assertFalse(t);
		}
	}

	@Test
	void testToSet() {
		int[][] not_sets = {{0,0}, {1,2,1}, {3,1,2,1}};
		for(int i = 0;i<not_sets.length;i=i+1) {
			ListInterface l = new LinkedList();
			for(int a = 0;a<not_sets[i].length;a=a+1) {l.addAt(not_sets[i][a], 0);}
			ListInterface ans = Moed_B_solution.toSet(l);
			assertTrue(Moed_B_solution.isSet(ans));
		}
	}

	@Test
	void testIntersection() {
		int[] t1 = {0,0,1,2,3,3};
		int[] t2 = {1,2,1,4,4,1};
		ListInterface l1 = new LinkedList();
		ListInterface l2 = new LinkedList();
		for(int i = 0;i<t1.length;i=i+1) {l1.addAt(t1[i], i);}
		for(int i = 0;i<t2.length;i=i+1) {l2.addAt(t2[i], i);}
		ListInterface l12 = Moed_B_solution.intersection(l1, l2);
		assertTrue(l12.size()==2);
	}


	@Test
	void testAllCodes() {
		String[] ans = Moed_B_solution.allCodes();
		for(int i=0;i<ans.length;i++) {
	//		System.out.println(i+") "+ans[i]);
		}
		assertEquals(ans.length,2*3*4*5);
	}
	@Test
	void testAllCodes2() {
		String[] ans = Moed_B_solution.allCodes();
		Arrays.sort(ans);
		for(int i=1;i<ans.length;i++) {
			assertNotEquals(ans[i],ans[i-1]);
			assertEquals(ans[i].length(),5);
		}
	}
	@Test
	void testAllCodes3() {
		String[] ans1 = Moed_B_solution.allCodes1();
		String[] ans0 = Moed_B_solution.allCodes();
		Arrays.sort(ans1);
		Arrays.sort(ans0);
		for(int i=0;i<ans0.length;i++) {
			assertEquals(ans0[i],ans1[i]);
		}
	}
}
