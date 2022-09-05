package week3;


import java.util.Scanner;
public class GCD2 {
	public static void main(String[] args) {
		// create a scanner so we can read the command-line input
		Scanner scanner = new Scanner(System.in);
    
		System.out.print("Enter in integer x=");
		int x = scanner.nextInt();
		System.out.print("Enter in integer y=");
		int y = scanner.nextInt();
		if(x<y) {
			int t=x; 
			x=y; 
			y=t;
		}
		// gcd(x,y) == gcd(y,x)
		// gcd(x,y) == gcd(x-y, y) : x>y
		System.out.print("GCD("+x+","+y+")=");
		while(x%y!=0) {
			x=x-y;
			if(x<y) {
				int t=x; x=y; y=t;
			}
			System.out.print("GCD("+x+","+y+")=");
		}
		System.out.println(y);
	}
}
