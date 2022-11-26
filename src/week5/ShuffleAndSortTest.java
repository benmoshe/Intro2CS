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
 * 0 | 9994.0,9920.0,10147.0,10043.0,9973.0,10011.0,9893.0,9985.0,10088.0,9946.0,
1 | 10027.0,10088.0,9901.0,10109.0,9925.0,9988.0,9853.0,10019.0,10067.0,10023.0,
2 | 10018.0,10035.0,9792.0,9887.0,9969.0,9881.0,10009.0,10210.0,10235.0,9964.0,
3 | 9990.0,9901.0,9995.0,9910.0,10024.0,10123.0,10088.0,10060.0,9910.0,9999.0,
4 | 10009.0,10030.0,10030.0,10078.0,10051.0,10054.0,9922.0,9849.0,9971.0,10006.0,
5 | 10006.0,9890.0,10183.0,10020.0,9938.0,9846.0,10110.0,9958.0,9993.0,10056.0,
6 | 10008.0,10013.0,9912.0,10082.0,10012.0,9997.0,10166.0,10010.0,9733.0,10067.0,
7 | 9962.0,9898.0,9890.0,9929.0,10133.0,10074.0,10078.0,9962.0,10045.0,10029.0,
8 | 9954.0,10227.0,10093.0,9949.0,10039.0,10079.0,9815.0,9859.0,9968.0,10017.0,
9 | 10032.0,9998.0,10057.0,9993.0,9936.0,9947.0,10066.0,10088.0,9990.0,9893.0,
 
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
