package week1;

public class TestBoolean {

	public static void main(String[] args) {
		boolean a=true, b=true;
		System.out.println("a = "+a+", b = "+b);
		boolean c=a||b, d = a&&b;
		System.out.println("a||b = "+c+", a&&b = "+d);
		a=true; b=false;
		System.out.println("a = "+a+", b = "+b);
		c=a||b; d = a&&b;
		System.out.println("a||b = "+c+", a&&b = "+d);
		System.out.println("a = "+a+", b = "+b);
		a=false; b=true;
		c=a||b; d = a&&b;
		System.out.println("a||b = "+c+", a&&b = "+d);
		a=false; b=false;
		System.out.println("a = "+a+", b = "+b);
		c=a||b; d = a&&b;
		System.out.println("a||b = "+c+", a&&b = "+d);
		a = false;
		c = !a;
		System.out.println("a = "+a+", !a = "+c);
		a = true;
		c = !a;
		System.out.println("a = "+a+", !a = "+c);
	}

}
