package ex2;
/** This main class is a very simple (no Junit) example 
 * of using array of double as a polynom.
 * @author boaz.benmoshe
 *
 */
public class Ex2_main {
	public static void main(String[] ar) {
		double eps = 0.01; // the epsilon to be used for the root approximation.
		double[] po1 = {2,0,3, -1,0};
		double[] po2 = {0.1,0,1, 0.1,3};
		String pp = Ex2.poly(po1);
		System.out.println(pp);
		pp = Ex2.poly(po2);
		System.out.println(pp);
		double x1 = 0, x2=10;
		double f2 = Ex2.f(po1,x1);
		System.out.println(f2);
		 f2 = Ex2.f(po1,x2);
		System.out.println(f2);
		double x12 = Ex2.root_itertive(po1, x1,x2,0.01);
		System.out.println("f("+x12+") = "+Ex2.f(po1,x12));
		double[] p12 = Ex2.add(po1, po2);
		pp = Ex2.poly(p12);
		System.out.println(pp);
		p12 = Ex2.mul(po1, po2);
		pp = Ex2.poly(p12);
		System.out.println(pp);
	}
}
