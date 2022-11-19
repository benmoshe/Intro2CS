package week5;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/**
 * This JUnit tester is rather complicated, the main concept is to 
 * test if the shuffle function is computing a random permutation. 
 * The test is performed by computing a large set of "shuffles" and then
 * counting the location of each element in the array. 
 * The counting is being done using a 2D array. The counting of each location
 * is tested to be +-3% of the evarage.
 * 
 * @author boaz.ben-moshe
 *
 */
class ShuffleAndSortTest {
	public static double EPS = 0.03;  // 3%
	@Test
	void testShuffle() {
		int size = 10, norm=10000;
		int iter = size*norm;
		double[][] test2D = new double[size][size];
		for(int i=0;i<iter;i++) {
			String[] s = init(size);
			ShuffleAndSort.shuffle(s);
			update(s, test2D);
		}
		show(test2D);
		boolean b = testUnifiedProb(test2D, norm);
		assertTrue(b);
	}

	//@Test
	//void testSort() {
	//	fail("Not yet implemented");
	//}
	////////////////////////////////////////////
	private static String[] init(int size) {
		String[] s = new String[size];
		for(int i=0;i<size;i=i+1) {s[i] = ""+i;}
		return s;
	}
	private static void update(String[] s, double[][] t) {
		for(int i=0;i<s.length;i=i+1) {
			int ind = Integer.parseInt(s[i]);
			t[i][ind]++;
		}
	}

	private boolean testUnifiedProb(double[][] a, int norm) {
		boolean ok = true;
		for (int j = 0; j < a.length && ok; j++) {
    		for (int i = 0; i < a[0].length; i++) {
    			double d1 = a[j][i];
    			double d = (d1 - norm)/norm;
    			double err = Math.abs(d);
    			if(err>EPS) {ok = false;};
    		}
    	}
		return ok;
	}
	private static void show(double[][] a) {
    	System.out.println();
    	for (int j = 0; j < a.length; j++) {
    		System.out.print(j+" | ");
    		for (int i = 0; i < a.length; i++) {
    			System.out.print(a[j][i]+",");
    		}
    		System.out.println();
    	}
    }
}
