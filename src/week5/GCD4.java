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
	/**
	 * This is a simplify (not so efficient) implementation of GCD algorithm, as in
	 * https://en.wikipedia.org/wiki/Euclidean_algorithm
	 * @param x
	 * @param y
	 * @return the Greater Common Divider (GCD) of x and y.
	 */
	public static long gcd1(long x, long y) {
		if(x<y) {	long t=x; x=y; y=t;}
		int i=0;
		if(debug_flag) {System.out.println();}
		while(x%y!=0) {
			if(debug_flag) {
				System.out.println(i+") gcd1("+x+","+y+")=");}
			x=x%y;
			i=i+1;
			if(x<y) {long t=x; x=y; y=t;}
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
	public static long gcd2(long x, long y) {
		if(debug_flag) {System.out.println();}
		int i=0;
		while (x != y) {
			if(debug_flag) {
				System.out.println(i+") gcd2("+x+","+y+")=");}
        	if(x > y) {x=x-y;}
            else {y=y-x;}
        	i=i+1;
        }
		return y;
	}
	/**
	 * This is a recursive implementation of gcd1 algorithm, as in
	 * https://en.wikipedia.org/wiki/Euclidean_algorithm
	 * @param x
	 * @param y
	 * @return the Greater COmmon Divider (GCD) of x and y.
	 */
	public static long gcd3(long x, long y) {
		if(debug_flag) {
			System.out.println("gcd3("+x+","+y+")=");}	
		if (x%y==0) {return y;}
		if (x<y) {return gcd3(y,x);}
        return gcd3(y,x%y);
	}
	
}
