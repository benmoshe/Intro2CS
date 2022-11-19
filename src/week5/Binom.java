package week5;
/**
 * https://en.wikipedia.org/wiki/Binomial_theorem
 * 
 * Output:
 * b(1,1)=1, b(1,0)=1;
 * b(2,2) = 1, b(2,0) =1, b(2,1) = 2;
 * b(n,k) = b(n-1,k-1) + b(n-1,k)
 * b(4,2) = b(3,1) + b(3,2)
 * @author boaz.benmoshe
 *
 */
public class Binom {
	
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
	public static int binomFast(int n, int k) {
		if(n<k || k<0) {return 0;}
		int[][] res = new int[n+1][n+1];
		for(int a=0;a<res.length;a=a+1) {
			for(int b=0;b<res[0].length;b=b+1) {
				res[a][b]= -1;
			}
		}
		return binomFast(n, k, res);
	}
	public static int binomFast(int n, int k, int[][] res2d) {
		int ans = res2d[n][k];
		if(ans==-1) {
		//	System.out.println("binom("+n+","+k+") = b("+(n-1)+","+(k-1)+") + b("+(n-1)+","+k+")");
	 		if(n==k || k==0) {ans=1;}
	 		else { // (n>k && k>0)
				ans = binomFast(n-1,k, res2d)+binomFast(n-1, k-1,res2d);
			}
			res2d[n][k] = ans;
		}
		return ans;
	}
}
