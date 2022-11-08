package week3;
/**
 * This code example demonstrates a simple GCD (Greater Common Divider) algorithm
 * @author boaz.benmoshe
 * output: GCD(12,20) = 4
 */
public class GCD0 {
	public static void main(String[] args) {
		int x = 12;
		int y = 20;
		int t = 0;
		int i=1, gcd=1;
		System.out.print("GCD("+x+","+y+") = ");
		while(i<=y) {   // [1,20]
			if(x%i==0 && y%i==0) {
				gcd=i;
			}
			i=i+1;
		}
		System.out.println(gcd);
	}
}
