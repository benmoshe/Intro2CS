package moed_A_Solution;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import moed_A_part1.LinkedList;
import moed_A_part1.ListInterface;
import moed_A_part2.Circle2D;
import moed_A_part2.GeoShape;
import moed_A_part2.Moed_A_part2_answers;
import moed_A_part2.Point2D;

class A_solutionTest {

	@Test
	void testQ1() {
		String[] input = {"2","21","2213","1010199905555555555555555"};
		String[] expected_output = {"2","12","1223","1115555555555555555999"};		
		for(int i=0;i<input.length;i=i+1) {
			String c = A_solution.sort(input[i]);
			assertEquals(c,expected_output[i]);
		}
	}
	@Test
	void testQ2_1() {
		String[] forms = {"1", "(3)", "(((2)))", "s(2)", "s(r(s(2)))"};
		int t = s(r(s(2)));
		int[] ans = {1, 3, 2, 4, t};
		for(int i=0;i<forms.length;i++) {
			int d = A_solution.calc(forms[i]);
			assertEquals(d, ans[i]);
		}
		for(int i=0;i<forms.length;i++) {
			int d = A_solution.calc(forms[i]);
			assertNotEquals(d, ans[i]+1);
		}
	}

	@Test
	void testQ2_2() {
		String[] g_forms = {"1", "0","(3)", "(((2)))", "s(2)", "s(r(s(2)))"};
		String[] b_forms = {"a", "0.1", "(0.3", "s(1,1)", "s(r(1,1)),1)", "((1) "};
		for(int i=0;i<g_forms.length;i++) {
			boolean b = A_solution.isForm(g_forms[i]);
			assertTrue(b);
		}
		for(int i=0;i<b_forms.length;i++) {
			boolean b = A_solution.isForm(b_forms[i]);
			assertFalse(b);
		}
	}
	
	@Test
	void testQ3_1() {
		int[] ll = {1,2,0,-4,3};
		ListInterface l = new LinkedList();
		for(int i=0;i<ll.length;i=i+1) {
			A_solution.addSorted(l,ll[i]);
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
	void testQ3_2() {
		int[] a1 = {1,2,0,-4,3};
		int[] a2 = {1,3,1,2,6,-1};
		var l1 = new LinkedList(); var l2 = new LinkedList();
		for(int i=0;i<a1.length;i=i+1) {l1.addAt(a1[i],0);}
		for(int i=0;i<a2.length;i=i+1) {l2.addAt(a2[i],0);}		
		ListInterface res = A_solution.merge(l1,l2);
		assertEquals(res.size(), l1.size()+l2.size());	
		assertTrue(isSorted(res));
	//	System.out.println(res);
	}
	@Test
	void testQ3_3() {
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
		ListInterface res = A_solution.merge(arr);
		assertEquals(s,res.size());
		assertTrue(isSorted(res));
	//	System.out.println(res);
	}
	
	@Test
	public void testQ4() {
		Circle2D c1 = new Circle2D(Point2D.ORIGIN,1);
		Circle2D c2 = new Circle2D(Point2D.ORIGIN,2);
		Circle2D c3 = new Circle2D(Point2D.ORIGIN,3);
		Point2D p1 = new Point2D(1,1);
		Point2D p2 = new Point2D(2,2);
		Point2D p3 = new Point2D(1,3);
		Point2D[] ps0 = {Point2D.ORIGIN};
		Point2D[] ps1 = {Point2D.ORIGIN, p1};
		Point2D[] ps2 = {Point2D.ORIGIN, p1,p2};
		Point2D[] ps3 = {Point2D.ORIGIN, p1,p2,p3};
		
		GeoShape[] gg = {c1,c2,c3,p1,p2,p3};
		AreaFilter_solution af0 = new AreaFilter_solution(p1);
		AreaFilter_solution af1 = new AreaFilter_solution(c1);
		AreaFilter_solution af2 = new AreaFilter_solution(c2);
		AreaFilter_solution af3 = new AreaFilter_solution(c3);
		PointsFilter_solution pf0 = new PointsFilter_solution(ps0);
		PointsFilter_solution pf1 = new PointsFilter_solution(ps1);
		PointsFilter_solution pf2 = new PointsFilter_solution(ps2);
		PointsFilter_solution pf3 = new PointsFilter_solution(ps3);
		GeoShape[] none = A_solution.ff(gg, af3);
		GeoShape[] c_2 = A_solution.ff(gg, af1);
		GeoShape[] all_c = A_solution.ff(gg, pf0);
		GeoShape[] some_c2 = A_solution.ff(gg, pf1);
		assertEquals(none.length, 0);
		assertEquals(all_c.length, 3);
		assertEquals(c_2.length, 2);
		assertEquals(some_c2.length, 2);
	}
	//////////////////// private methods for testing //////////////
	private static boolean isSorted(ListInterface l) {
		boolean ans = true;
		for(int i=0;i<l.size()-1;i=i+1) {
			if(l.get(i)>l.get(i+1)) {ans = false;}
		}
		return ans;
	}
	private int s(int x) {return A_solution.s(x);}
	private int r(int x) {return A_solution.r(x);}
}
