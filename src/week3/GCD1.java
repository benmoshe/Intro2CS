package week3;
/**
 * This code example demonstrates a simple GCD (Greater Common Divider) algorithm
 * @author boaz.benmoshe
 *
 */
public class GCD1 {

	public static void main(String[] args) {
		int x = 12;
		int y = 20;
		int t = 0;
		int min = Math.min(x, y);
		int i=min, gcd=1;
		System.out.print("GCD("+x+","+y+") = ");
		while(i>=1 && gcd==1) {
			if(x%i==0 && y%i==0) {
				gcd=i;
			}
			i=i-1;
		}
		System.out.println(gcd);
	}
}
