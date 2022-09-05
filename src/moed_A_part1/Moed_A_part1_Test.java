package moed_A_part1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class Moed_A_part1_Test {

	@Test
	void testQ1_1() {
		String[] forms = {"1", "(3)", "(((2)))", "s(2)", "s(r(s(2)))"};
		int t = s(r(s(2)));
		int[] ans = {1, 3, 2, 4, t};
		for(int i=0;i<forms.length;i++) {
			int d = Moed_A_part1_answers.calc(forms[i]);
			assertEquals(d, ans[i]);
		}
		for(int i=0;i<forms.length;i++) {
			int d = Moed_A_part1_answers.calc(forms[i]);
			assertNotEquals(d, ans[i]+1);
		}
	}

	@Test
	void testQ1_2() {
		String[] g_forms = {"1", "0","(3)", "(((2)))", "s(2)", "s(r(s(2)))"};
		String[] b_forms = {"a", "0.1", "(0.3", "s(1,1)", "s(r(1,1)),1)"};
		for(int i=0;i<g_forms.length;i++) {
			boolean b = Moed_A_part1_answers.isForm(g_forms[i]);
			assertTrue(b);
		}
		for(int i=0;i<b_forms.length;i++) {
			boolean b = Moed_A_part1_answers.isForm(b_forms[i]);
			assertFalse(b);
		}
	}
	
	@Test
	void testQ3_1() {
		int[] ll = {1,2,0,-4,3};
		ListInterface l = new LinkedList();
		for(int i=0;i<ll.length;i=i+1) {
			Moed_A_part1_answers.addSorted(l,ll[i]);
		}
		assertEquals(ll.length, l.size());
		Arrays.sort(ll);
		for(int i=0;i<l.size();i=i+1) {
			assertEquals(ll[i], l.get(i));
		}
		assertTrue(isSorted(l));
		//System.out.println("Sorted: "+l);
	}
	@Test
	void testQ2_2() {
		int[] a1 = {1,2,0,-4,3};
		int[] a2 = {1,3,1,2,6,-1};
		var l1 = new LinkedList(); var l2 = new LinkedList();
		for(int i=0;i<a1.length;i=i+1) {l1.addAt(a1[i],0);}
		for(int i=0;i<a2.length;i=i+1) {l2.addAt(a2[i],0);}		
		ListInterface res = Moed_A_part1_answers.merge(l1,l2);
		assertEquals(res.size(), l1.size()+l2.size());	
		assertTrue(isSorted(res));
	//	System.out.println(res);
	}
	@Test
	void testQ2_3() {
		int[][] ll = {{3,55},{1,2,0,-4,3}, {1,3,1,2,6,-1}};
		ListInterface[] arr = new ListInterface[ll.length];
		int s = 0;
		for(int i=0;i<ll.length;i=i+1) {
			arr[i] = new LinkedList();
			for(int j=0;j<ll[i].length;j=j+1) {
				int d = ll[i][j];
				arr[i].addAt(d,0);
				s+=1;
			}
		}
		ListInterface res = Moed_A_part1_answers.merge(arr);
		assertEquals(s,res.size());
		assertTrue(isSorted(res));
	//	System.out.println(res);
	}

	//////////////////// private methods for testing //////////////
	private static boolean isSorted(ListInterface l) {
		boolean ans = true;
		for(int i=0;i<l.size()-1;i=i+1) {
			if(l.get(i)>l.get(i+1)) {ans = false;}
		}
		return ans;
	}
	private int s(int x) {return Moed_A_part1_answers.s(x);}
	private int r(int x) {return Moed_A_part1_answers.r(x);}
}
