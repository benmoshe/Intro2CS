package week5;
/**
 * This GCD example shows the difference between slow GCD to fast GCD (with mod operation).
 * 
 * Introduction to Computer Science in Java CS.Ariel University.

 * 
 */
import java.util.Scanner;

public class GCD4 {
	public static boolean debug_flag = true;
	public static void main(String[] args) {
		// create a scanner so we can read the command-line input
		Scanner scanner = new Scanner(System.in);
		int flag = 1;
		while(flag == 1 || flag ==2) {
			System.out.print("Enter in integer x=");
			int x = scanner.nextInt();
			System.out.print("Enter in integer y=");
			int y = scanner.nextInt();
			int g = 0;
			if(flag==1) {
				g=gcd1(x,y);
			}
			if(flag==2) {
				g=gcd2(x,y);
			}
			System.out.println(g);
			System.out.print("Enter 1 for slow GCD, 2 for fast GCD or 0 to exit:");
			flag = scanner.nextInt();
		}
		System.out.println("Bye Bye...");
	}
	/**
	 * This is a simplify (not so efficient) implementation of GCD algorithm, as in
	 * https://en.wikipedia.org/wiki/Euclidean_algorithm
	 * @param x
	 * @param y
	 * @return the Greater Common Divider (GCD) of x and y.
	 */
	public static int gcd1(int x, int y) {
		if(x<y) {	int t=x; x=y; y=t;}
		int i=0;
		while(x%y!=0) {
			if(debug_flag) {
				System.out.print("gcd_"+i+"("+x+","+y+")=");}
			x=x%y;
			i=i+1;
			if(x<y) {int t=x; x=y; y=t;}
		}
		return y;
	}
	/**
	 * This is a simplify (not so efficient) implementation of GCD algorithm, as in
	 * https://en.wikipedia.org/wiki/Euclidean_algorithm
	 * @param x
	 * @param y
	 * @return the Greater COmmon Divider (GCD) of x and y.
	 */
	public static int gcd2(int x, int y) {
		while (x != y) {
			if(debug_flag) {
				System.out.print("gcd("+x+","+y+")=");}
        	if(x > y) {x=x-y;}
            else {y=y-x;}
        }
		return y;
	}
}
