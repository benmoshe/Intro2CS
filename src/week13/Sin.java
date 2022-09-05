package week13;

public class Sin implements Function{
	
	double _a;
	public Sin(double a) {_a = a;}
	@Override
	public double f(double x) { //sin(a*x);
		return Math.sin(_a*x);
	}
}
