package week13;

public class F1 implements Function2D{
	private double _a, _b,_c;
	public F1(double a, double b, double c) {
		_a=a; _b=b;_c=c;
	}
	@Override
	public double f(double ang) {
	//	 ang = Math.toRadians(x);
		double d = _b+ _a*Math.cos(ang*_c);
		return d;
	}
}
