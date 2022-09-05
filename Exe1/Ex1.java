package Ex1;
import java.util.Scanner;
/**
 * Greater Common Prime Divider - GCPD(x,y):
 * =========================================
 * Introduction to Computer Science, Ex0+Ex1 - the goal is to find the maximal prime common divider,
 * Note: in this case the if the GCD(x,y)==1, the GCPD(x,y) -->1 (1 is assumed to be a "prime number"). 
 * The algorithm has three stages: 
 * 1) input two natural numbers (x,y).
 * 2) computes the g=GCD(x,y). 	// Greater Common Divider
 * 3) compute the GPD(g). 		// Greater Prime Divider
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
 * 2.1) while(g>=i*i) {
 * 2.2) 	if(g%i==0) {g=g/i;}
 * 2.3) 	else {i=i+1;}
 * 		 }
 * 3) 	return g;
 * 
 * Example:
 * GCPD(264,396):
 * g = gcd(264,396) = gcd(396,264) = gcd(264,132) = 132
 * 132 = 2*2*3*11 
 * gpd(132),i=2, 132%2==0, 132/2
 * gpd(66), 66%2==0, 66/2
 * gpd(33), 33%2!=0, i=i+1, 33%3==0, 33/3 
 * gpd(11), 11%3!=0, i=i+1, i*i>11 --> done,
 * ans = 11
 * 
 * @author boaz.benmoshe
 *
 */
public class Ex1 {
	
	/**
	 * This function computes the Grater Common Divider (GCD) of two natural numbers
	 * The function is implemented using recursion  - for simplicity.
	 * @param x
	 * @param y
	 * @return
	 */
	public static long gcd1(long x, long y) {
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
		 if(x<y) {long t=x; x=y; y=t;}
		 while(x%y!=0) {
			 x=x%y;
			 if(x<y) {long t=x; x=y; y=t;}
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
		 while(i*i<=g)  {           // if i*i>g --> g is a prime number
			if(g%i==0) {g=g/i;}		// if g%i==0 --> g=i*x, i is a prime number, i<=x,  
			else {i++;}				// if g%i!=0 --> increase i;
		 }
		 return g;
	}
	/**
	 * Computes the maximum prime number which divides both x and y.
	 * @param x - a natural number 
	 * @param y - a natural number
	 * @return - the max prime number which divides both x and y.
	 */
	public static long greaterPrimeCommonDivider(long x, long y) {
		 long g1 = gcd1(x,y); // Recursive implementation
		 long g2 = greaterPrimeDivider(g1);
		 return g2;
	}
	/**
	 * This main function simply allows input of two natural numbers x,y: via main(args) or System.in.
	 * and then computes the Greater Common Prime Divider - GCPD(x,y):
	 * @param args
	 */
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
			System.out.println("Computes the GPCD("+x+","+y+") = ");
			long ans = greaterPrimeCommonDivider(x,y);
			System.out.println("Max Prime Common Divider: "+ans); 
	}
}
