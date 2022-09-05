package week13;

public class Main {
	public static void main(String[] a) {
		Sin s1 = new Sin(0.7);
		Sin s2 = new Sin(1.1);
		double x1 = Math.PI*0.2, x2 = Math.PI;
		double y = close(x1,x2,s1,s2,0.001);
		System.out.println("f1("+y+") = "+s1.f(y));
		System.out.println("f2("+y+") = "+s2.f(y));
	}
	static double close(double x1, double x2 , Function f1, Function f2, double eps) {
		double f1x1 = f1.f(x1);
		double f1x2 = f1.f(x2);
		double f2x1 = f2.f(x1);
		double f2x2 = f2.f(x2);
		
		double df1f2x1 = f1x1-f2x1;
		double df1f2x2 = f1x2-f2x2;
		
		if(df1f2x1*df1f2x2>0) {throw new RuntimeException("ERR");}
		double x12 = (x1+x2)/2;
		double d = f1.f(x12) - f2.f(x12);
		int i=0;
		while(Math.abs(d)>eps) {
			System.out.println(i+") d: "+d+" , dx:"+(x2-x1));
			double f1x12 = f1.f(x12);
			double f2x12 = f2.f(x12);
			double df1f2x12 = f1x12-f2x12;
			if(df1f2x1*df1f2x12<=0) {x2 = x12;}
			else {x1 = x12;}
			x12 = (x1+x2)/2;
			d = f1.f(x12) - f2.f(x12);
			i+=1;
		}
		return x12;
	}
}
