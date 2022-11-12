package Exe.Ex1;
/**
 * The GPCD(659675382240,4485792599232) = 333331

The runtime took: 41.292 micro seconds.
Testing The GPCD(659675382240,4485792599232) 
Implemented by: 1234  runtime took: 1669.208 micro seconds.

 */
import java.util.Scanner;

public class Ex1Test {

	public static void main(String[] args) {
		long x,y, id;
		if(args.length<3) {
		    Scanner scanner = new Scanner(System.in);
		    System.out.print("Enter your ID number: ");
		    id = scanner.nextLong();
		    System.out.print("Enter the first number for max prime GCD: ");
		    x = scanner.nextLong();
		    System.out.print("Enter the second number for max prime GCD: ");
		    y = scanner.nextLong();
		}
		else {
			id = Long.parseLong(args[0]);
			x = Long.parseLong(args[1]);
			y = Long.parseLong(args[2]);
		}
		
		// 659675382240 , 4485792599232
		String[] ar = {""+x, ""+y};
		long start = System.nanoTime();
		Ex1.main(ar);
		//Ex1.greaterCommonPrimeDivider(x, y);
		long end = System.nanoTime();
		System.out.println("Testing The GPCD("+x+","+y+") ");
		double dt = (end - start)/(1000.0);
		System.out.println("Implemented by: "+id+"  runtime took: "+dt+" micro seconds."); 
	}

}
