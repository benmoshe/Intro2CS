package week3;
/**
 * This class contains several simple examples for static functions and basic testing
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

}
