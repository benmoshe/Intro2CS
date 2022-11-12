package Exe.Ex1;
import java.util.Scanner;
/**
 * Department of Computer Science, Ariel University.
 * Introduction to Computer Science, 2022
 *  
 * Ex1: Greater Common Prime Divisor - GCPD(x,y) - suggested solution:
 * ===================================================================
 * Ex0+Ex1 - the goal is to find the maximal prime common divisor (aka GCPD),
 * Note: in case the GCD(x,y)==1, the GCPD(x,y) -->1 (1 is the return value when there is no Prime divider). 
 * 
 * The algorithm has three stages: 
 * 1) input two natural numbers (x,y).
 * 2) computes the g=GCD(x,y). 	// Greater Common Divisor: https://en.wikipedia.org/wiki/Greatest_common_divisor
 * 3) compute the GPD(g). 		// Greater Prime Divider: https://en.wikipedia.org/wiki/Trial_division
 * 
 * The GCD function is implemented using the following algorithm gcd(x,y) = gcd(x%y,y) (assuming x>y, y!=0).
 * The GPD function is using the representation of g as product of k prime numbers: p1*p2*..pk (p1<=p2<=...pk) 
 * While g%i==0 (i starts from 2), g is divided by i, else i is incremented.
 * 
 * In short: GCPD(x,y) = GPD(GCD(x,y));
 * 
 * Algorithm GCPD(x,y) - Greater Common Prime Divider:
 * ===================================================
 * 0) Input: two natural numbers (x,y), from the main's arguments or from the System input. 
 * 1) g = GCD(x,y): gcd(x,y)-->y (assumes x%y==0), gcd(x,y)-->gcd(x%y,y) (assumes x>y, else swaps(x,y)).
 * 1.1) if(x<y) return gcd(y,x); // swap;
 * 1.2) if(x%y==0) return y
 * 1.3) return gcd(x%y,y);
 * 
 * 2) Computes GPD(g): Greater Prime Divider: Present g as the product of k prime numbers g = p1*p2 *...pk, (p1<=p2<=...pk).
 * 2.1) i=2;
 * 2.2) while(g>=i*i) {
 * 2.2) 	if(g%i==0) {g=g/i;}
 * 2.3) 	else {i=i+1;}
 * 		 }
 * 3) 	return g;
 * 
 * Implementation remark: 
 * ======================
 * The GPD(g) function can be implemented in a faster maner (~twice as fast) using the following psuedo code
 *  (see https://en.wikipedia.org/wiki/Trial_division):
 * 
 * 0) GPD(g) : (g>=2)
 * 1) while(g%2==0) {g=g/2;}
 * 2) i=3;
 * 3) while(g>=i*i) {
 * 4) 	if(g%i==0) {g=g/i;}
 * 5) 	else {i=i+2;}
 * 		}
 * 6) return g;
 * 
 * 
 * Example 1:
 * GCPD(264,396):
 * g = gcd(264,396) = gcd(396,264) = gcd(264,132) = 132
 * 132 = 2*2*3*11 
 * gpd(132),i=2, 132%2==0, 132/2
 * gpd(66), 66%2==0, 66/2
 * gpd(33), 33%2!=0, i=i+1, 33%3==0, 33/3 
 * gpd(11), 11%3!=0, i=i+1, i*i>11 --> done,
 * ans = 11
 * 
 * Example 2 (DEBUG = true):
 * Enter the first number for max prime GCD: 4485792599232
 * Enter the second number for max prime GCD: 659675382240
 * GCPD(4485792599232,659675382240): 
 * gcd1(4485792599232,659675382240)
 * gcd1(659675382240,527740305792)
 * gcd1(527740305792,131935076448)

 * gpd(131935076448) = 2*2*2*2*2*3*7*19*31*333331
 * The GPCD(4485792599232,659675382240) = 333331
 * The runtime took: 627.917 micro seconds.
 * Testing The GPCD(4485792599232,659675382240) 
 * Implemented by: 659675382240  runtime took: 3323.917 micro seconds.
 * 
 * @author boaz.benmoshe
 * 
 */
public class Ex1 {
	/**
	 * Simple debug parameters - in case true additional printing is being done.
	 */
	public static final boolean DEBUG = true;
	/**
	 * This function computes the Grater Common Divider (GCD) of two natural numbers
	 * The function is implemented using recursion  - for simplicity.
	 * @param x
	 * @param y
	 * @return
	 */
	public static long gcd1(long x, long y) {
		if(DEBUG) {System.out.println("gcd1("+x+","+y+")");}
		if(x<y) {return gcd1(y,x);}
		if(x%y==0) {return y;}
		return gcd1(y,x%y);
	}
	/**
	 * This function computes the Grater Common Divider (GCD) of two natural numbers,
	 * 
	 * @param x
	 * @param y
	 * @return
	 */
	public static long gcd2(long x, long y) {
		if(DEBUG) {System.out.println("gcd2("+x+","+y+")");}
		if(x<y) {long t=x; x=y; y=t;}
		while(x%y!=0) {
			x=x%y;
			if(x<y) {long t=x; x=y; y=t;}
			if(DEBUG) {System.out.println("gcd2("+x+","+y+")");}
		}
		return y;
	}   
	/**
	 * This function computes the greater prime divider of a natural number g.
	 * Any natural number g can be presented as p1*p2*...pk (p1<=p2<=...pk are prime numbers).
	 * The algorithm divides g by p1,p2,...p(k-1), which remains pk - as the answer. 
	 * 
	 * @param g - a natural number.
	 * @return a greater prime divider of g.
	 */
	public static long greaterPrimeDivider(long g) {
		long i = 2;				// smallest possible prime divider
		if(DEBUG) {System.out.println(); System.out.print("DEBUG mode: gpd("+g+") = ");}
		while(i*i<=g)  {           // if i*i>g --> g is a prime number
			if(g%i==0) {g=g/i;		// if g%i==0 --> g=i*x, i is a prime number, i<=x, 
			if(DEBUG) {System.out.print(i+"*");}
			}
			else {i++;}				// if g%i!=0 --> increase i;
		}
		if(DEBUG) {System.out.println(g);}
		return g;
	}
	/**
	 * This function computes the greater prime divider of a natural number g.
	 * Any natural number g can be presented as p1*p2*...pk (p1<=p2<=...pk are prime numbers).
	 * The algorithm first devides g by 2 - till g is an odd number. Then only odd numbers are considered (3,5,7...) 
	 * 
	 * @param g - a natural number.
	 * @return a greater prime divider of g.
	 */
	public static long greaterPrimeDivider2(long g) {
		while(g%2==0) {g=g/2;}// 	2 is the smallest possible prime divider
		long i = 3;				// i is an odd number (3,5,7...)
		while(i*i<=g)  {           // if i*i>g --> g is a prime number
			if(g%i==0) {g=g/i;}		// if g%i==0 --> g=i*x, i is a prime number, i<=x,  
			else {i=i+2;}				// if g%i!=0 --> increase i by 2;
		}
		return g;
	}
	/**
	 * Computes the maximum prime number which divides both x and y.
	 * @param x - a natural number 
	 * @param y - a natural number
	 * @return - the max prime number which divides both x and y.
	 */
	public static long greaterCommonPrimeDivider(long x, long y) {
		if(DEBUG) {System.out.println("GCPD("+x+","+y+"): ");}
		long g1 = gcd1(x,y); // Recursive implementation
		long g2 = greaterPrimeDivider(g1);
		//long g2 = greaterPrimeDivider2(g1); // this is somewhat faster 
		return g2;
	}
	/**
	 * This main function simply allows input of two natural numbers x,y: via main(args) or System.in.
	 * and then computes the Greater Common Prime Divisor - GCPD(x,y):
	 * @param args
	 */
	//659675382240, 4485792599232
	public static void main(String[] args) {
		long x,y;

		if(args.length<2) {
			Scanner scanner = new Scanner(System.in);
			System.out.print("Enter the first number for max prime GCD: ");
			x = scanner.nextLong();
			System.out.print("Enter the second number for max prime GCD: ");
			y = scanner.nextLong();
		}
		else {
			x = Long.parseLong(args[0]);
			y = Long.parseLong(args[1]);
		}
		// 659675382240 , 4485792599232
		long start = System.nanoTime();
		long ans = greaterCommonPrimeDivider(x,y);
		long end = System.nanoTime();
		System.out.println("The GPCD("+x+","+y+") = "+ans);
		double dt = (end - start)/(1000.0);
		if(DEBUG) {System.out.println("The runtime took: "+dt+" micro seconds."); }
	}
}
