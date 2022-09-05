package week3;
/**
 * This GCD example shows the difference between slow GCD to fast GCD (with mod operation).
 * 
 * Introduction to Computer Science in Java CS.Ariel University.

 * 
 */
import java.util.Scanner;

public class GCD3 {
	public static void main(String[] args) {
		// create a scanner so we can read the command-line input
		Scanner scanner = new Scanner(System.in);
		int flag = 1;
		while(flag == 1 || flag ==2) {
			System.out.print("Enter in integer x=");
			int x = scanner.nextInt();
			System.out.print("Enter in integer y=");
			int y = scanner.nextInt();
			if(x<y) {
				int t=x; x=y; y=t;
			}
			System.out.println("GCD("+x+","+y+")=");
			int i=1;
			while(x%y!=0) {
				if(flag==1) {x=x-y;}
				if(flag==2) {x=x%y;}
				if(x<y) {
					int t=x; x=y; y=t;
				}
				System.out.println(i+") GCD("+x+","+y+")=");
				i=i+1;
			}
			System.out.println(y);
			System.out.print("Enter 1 for slow GCD, 2 for fast GCD or 0 to exit:");
			flag = scanner.nextInt();
		}
		System.out.println("Bye Bye...");
	}
}
