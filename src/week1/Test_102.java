package week1;


/**
 * Output:
 * x+y = 19
x*y = 88
x/y = 0
y/x = 1
y/x = 1.0
11/3 = 3.6666666666666665
u = 18.0, v = 5.0, u/v = 3.6
y = 11, x = 8, y%x = 3
x = 8, y = 11, x%y = 8

 * @author boaz.benmoshe
 *
 */
public class Test_102 {
	public static void main(String[] args) {
		int x = 8, y;
		y=11;
		int z = x + y; // this line represents a bug! 
		System.out.println("x+y = "+z);
		int a = x*y;
		System.out.println("x*y = "+a);
		a = x/y;
		System.out.println("x/y = "+a);
		a = y/x;
		System.out.println("y/x = "+a);
		double d = y/x;
		System.out.println("y/x = "+d);
		d = 11./3.;
		System.out.println("11/3 = "+d);
		double u = 18, v = 5;
		d = u/v;
		System.out.println("u = "+u+", v = "+v+", u/v = "+d);
		z = y%x;
		System.out.println("y = "+y+", x = "+x + ", y%x = "+z);
		z = x%y;
		System.out.println("x = "+x+", y = "+y + ", x%y = "+z);
	}
}
