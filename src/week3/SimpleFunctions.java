package week3;
/**
 * This class contains several simple examples for static functions and 
 * basic testing using JUnit.
 * @author boaz.ben-moshe
 *
 */
public class SimpleFunctions {
	public static boolean isPrime(int n) {
		boolean ans = true;
		for(int i=2;i*i<=n && ans ;i=i+1) {
			if(n%i==0) {ans = false;}
		}
		return ans;
	}
	public static double random(double min, double max) {
		double r = Math.random(); // [0,1)
		double dx = max-min;
		r = r *dx; // [0,dx) = [0,max-min)
		r = r + min; //[min,max)
		return r;
	}
}
