package week4;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ShuffleAndSortTest {

	@Test
	void testShuffle() {
		int size = 10, norm=1000;
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
    			double eps = Math.abs(d);
    			if(eps>0.1) {ok = false;};
    		}
    	}
		return ok;
	}
	 // take as input an array of strings and print them out to standard output
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
