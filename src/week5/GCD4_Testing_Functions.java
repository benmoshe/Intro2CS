package week5;


public class GCD4_Testing_Functions {
	public static void main(String[] s) {
		int x = 55, y = 34;
		int times = 1000;
		long start = System.currentTimeMillis();
		//GCD4.debug_flag = false;
		for(int i=0;i<times;i=i+1) {
			
			int g = GCD4.gcd1(x, y);
		}
		//System.out.println("gcd("+x+","+y+")= "+g);
		long end = System.currentTimeMillis();
		double dt = end-start;
		dt = dt / times;
	//	System.out.println("gcd("+x+","+y+")= "+g);
		System.out.println();
		System.out.println("took "+dt+" mili seconds");
	}
}
