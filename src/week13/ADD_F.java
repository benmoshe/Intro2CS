package week13;

public class ADD_F implements Function2D{
	private Function2D _f1, _f2;
	public ADD_F(Function2D f1, Function2D f2) {
		_f1 = f1; _f2 = f2;
	}
	@Override
	public double f(double x) {
		// TODO Auto-generated method stub
		return _f1.f(x) + _f2.f(x) ;
	}
	

}
