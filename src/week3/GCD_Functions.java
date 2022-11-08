package week3;
/**
 * 
 * output: gcd0(12,20) = 4
 * @author boaz.ben-moshe
x=12,  y=20
x=20,  y=12
x=8,  y=12
x=12,  y=8
x=4,  y=8
x=8,  y=4
x=4,  y=4
gcd5(12,20) = 4


x=12,  y=20
x=12,  y=8
x=8,  y=4
gcd6(12,20) = 4
 *
 */
public class GCD_Functions {
	
	public static void main(String[] args) {
		int x = 12;
		int y = 20;
	//	int g0 = gcd0(x,y);
	//	System.out.println("gcd0("+x+","+y+") = "+g0);
		int g5 = gcd5(x,y);
		System.out.print("gcd5("+x+","+y+") = "+g5);
	}
	/**
	 * gcd(x,y) = gcd(y,x)
	 * gcd(x,x) = x;
	 * x>y gcd(x,y) gcd(x-y,y);
	 * @param x
	 * @param y
	 * @return
	 */
	public static int gcd5(int x, int y) {
		int ans = 1;
		System.out.println("x="+x+",  y="+y);
		if(x==y) {ans=x;}
		else {
			if(x>y) {
				ans = gcd5(x-y,y);}
			else {ans = gcd5(y,x);}
		}
		return ans;
	}
	public static int gcd6(int x, int y) {
		
		while(x!=y) {
			System.out.println("x="+x+",  y="+y);
			if(y>x) {int t = x; x=y; y = t;}
			int d = y;
			y = x-y;
			x = d;
		}
		return y;
	}
	public static int gcd0(int x, int y) {
		int i=1, gcd=1;
		//System.out.print("GCD("+x+","+y+") = ");
		while(i<=y) {   // [1,20]
			if(x%i==0 && y%i==0) {
				gcd=i;
			}
			i=i+1;
		}
		return gcd;
	}
	public static boolean isPrime(int n) {
		boolean ans = true;
		for(int i=2;i*i<=n && ans;i=i+1) {
			if(n%i==0) {ans = false;}
		}
		return ans; // bug
	}
}
