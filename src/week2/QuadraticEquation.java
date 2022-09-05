package week2;
import java.util.Scanner;
public class QuadraticEquation {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("x^2 + bx + c = 0");
		System.out.print("Please insert b: ");
		double b = scanner.nextDouble();
		System.out.print("Please insert c: ");
		double c = scanner.nextDouble();
		
		double disciminant = b*b - 4.0*c;
		double d = Math.sqrt(disciminant);
		double root1 = (-b + d) / 2.0;
		double root2 = (-b - d) / 2.0;
		System.out.println("x^2 +"+b+"x+"+c+" = 0");
		System.out.println("first solution: "+root1);
		System.out.println("second solution: "+root2);
	}
}
