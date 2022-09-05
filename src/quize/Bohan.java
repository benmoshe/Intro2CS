package quize;

public class Bohan {
	public static String myID = "123";
	
	/** Q1: */
	public static String[] stringArr2Set(String[] a) {
		int size = 0;
		for(int i=0;i<a.length;i=i+1) {
			if(first(a,i)) {size = size +1;}
		}
		String[] ans = new String[size];
		size = 0;
		for(int i=0;i<a.length;i=i+1) {
			if(first(a,i)) {
				ans[size] = a[i];
				size = size +1;}
		}
		return ans;
	}
	private static boolean first(String[] a, int ind) {
		boolean ans = true;
		for(int i=0;i<ind && ans;i=i+1) {
			if(a[i].equals(a[ind])) {
				ans = false;
			}
		}
		return ans;
	}
	// ********* Q2 ********
	public static int maxMonotoneIncArr(double[] a)  {
		int ans=0;
		for(int i=0;i<a.length;i=i+1) {
			int mm = maxMonotone(a,i);
			if(mm>ans) {ans=mm;}
		}
		return ans;
	}
	private static int maxMonotone(double[] a, int ind) {
		int ans = 0;
		int size = a.length;
		if(ind>=size) {return ans;}
		ans = 1;
		while(ind<size-1 && a[ind]<=a[ind+1]) {
			ans=ans+1;
			ind = ind +1;
		}
		return ans;
	}
	// ********* Q3a ********
	public static int sumOf2() {
		int c1 = cube();
		int c2 = cube();
		return c1+c2;
	}
	private static int cube() {
		double r = Math.random()*6;
		int c = 1+ (int)(r);
		return c;
	}
	// ********* Q3b ********
	public static double evenSumProb() {
		int size = 1000;
		double count = 0;
		for(int i=0;i<size;i++) {
			int t = sumOf2();
			if(t%2==0) {count = count +1;}
		}
		double ans = count / size;
		return ans;
	}
	// ********* Q4 ********
	public static int intersectionSetSize(int[][] a, int[][] b) {
		int ans = 0;
		int count = 0;
		for(int i=0;i<a.length;i=i+1) {
			for(int j=0;j<a[i].length;j++) {
				int a0 = a[i][j];
				int first_a_ind = first_member(a,a0);
				int first_b_ind = first_member(b,a0);
				if(first_b_ind!=-1 && first_a_ind==count) {
					ans = ans +1;
				}
				count = count +1;
			}
		}
		return ans;
	}
	
	private static int first_member(int[][] a, int v) {
		int ans = -1;
		int count = 0;
		for(int i=0;i<a.length;i=i+1) {
			for(int j=0;j<a[i].length;j++) {
				if(a[i][j] == v && ans ==-1) {ans=count;}
				count = count +1;
			}
		}
		return ans;
	}
}
