package week3;
/**
 * This code example demonstrates a simple GCD (Greater Common Divider) 
 * algorithm - command line argument passing.
 * @author boaz.benmoshe
 *
 */
public class GCD1a {
	public static void main(String[] args) 
	{
		int x = 12;
		int y = 20;
		int i=0;
		while(i<args.length) {
			System.out.println(i+") "+args[i]);
			i=i+1;
		}
		if(args.length>1) {
			x = Integer.parseInt(args[0]);
			y = Integer.parseInt(args[1]);
		}
		int t = 0;
		int min = Math.min(x, y);
		i=min;
		int gcd=1;
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
