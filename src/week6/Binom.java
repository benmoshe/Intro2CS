package week6;
/**
 * b(1,1)=1, b(1,0)=1;
 * b(2,2) = 1, b(2,0) =1, b(2,1) = 2;
 * b(n,k) = b(n-1,k-1) + b(n-1,k)
 * b(4,2) = b(3,1) + b(3,2)
 * @author boaz.benmoshe
 *
 */
public class Binom {
	public static void main(String[] a) {
		int n = 8, k = 2;
		//System.out.println("binom("+n+","+k+") = ");
		int t = binom_debug(n,k);
		//int t = binom(n,k);
		System.out.println(t);
	}
	
	public static int binom(int n, int k) {
		if(n<k || k<0) return 0;
 		if(n==k || k==0) return 1;
		return binom(n-1,k) + binom(n-1, k-1);
	}
	public static int binom_debug(int n, int k) {
		if(n<k || k<0) return 0;
 		if(n==k || k==0) return 1;
 		System.out.println("binom("+n+","+k+") = b("+(n-1)+","+(k-1)+") + b("+(n-1)+","+k+")");
		int n0 = binom_debug(n-1,k);
		int n1 = binom_debug(n-1, k-1);
		return n0+n1;
	}
}
