package moed_A_part1;
import static org.junit.Assert.fail;
import org.junit.jupiter.api.Test;
/** 
 * This class is the Junit 'answer-form' of part #1(Q1,Q2)  of Moed_A (introduction 2 CS, Ariel University.) 
 */
class Moed_A_part1_answersTest {
	@Test
	void testQ0_ID() { // Do Not change this Test!
		long id = Moed_A_part1_answers._id;
		if(id==123456789) {fail("ERROR: please update your ID (it is NOT: "+id+")");}
	}
	
	@Test
	void testQ1_1() {
		String[] good_forms = {"1", "(3)", "(((2)))", "s(2)", "s(r(s(2)))"};
		// Update your code below: 
		
		//-----------------------
	}

	@Test
	void testQ1_2() {
		String[] good_forms = {"1", "0","(3)", "(((2)))", "s(2)", "s(r(s(2)))"};
		String[] bad_forms = {"a", "0.1", "(0.3", "s(1,1)", "s(r(1,1)),1)"};
		// Update your code below: 
		
		//-----------------------
	}
	
	@Test
	void testQ2_1() {
		int[] ll = {1,2,0,-4,3};
		ListInterface l = new LinkedList();
		for(int i=0;i<ll.length;i=i+1) {
			Moed_A_part1_answers.addSorted(l,ll[i]);
		}
		// Update your code below: 
		
		//-----------------------
	}
	@Test
	void testQ2_2() {
		int[] a1 = {1,2,0,-4,3};
		int[] a2 = {1,3,1,2,6,-1};
		// Update your code below: 
		
		//-----------------------
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
		// Update your code below: 
		
		//-----------------------
	}

	
	private static boolean isSorted(ListInterface l) {
		boolean ans = true;
		for(int i=0;i<l.size()-1;i=i+1) {
			if(l.get(i)>l.get(i+1)) {ans = false;}
		}
		return ans;
	}
}
