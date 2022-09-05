package ex2;
/** 
 * This class represents a simple use of arrays for Polynoms.
 * The code is given as a class-solution for Ex2 (Intro to CS, Ariel University)
 * 
 * @author boaz.benmoshe
 *
 */
public class Ex2 {
	/**
	 * This function computes the value of f(x), where f is a polynom represented 
	 * as an array of doubles.
	 * @param poly - the polynom
	 * @param x - the real value for which f(x) should be computed.
	 * @return a real number f(x)
	 */
	public static double f(double[] poly, double x) {
		double ans = 0;
		for(int i=0;i<poly.length;i++) {
			double c = Math.pow(x, i);
			ans +=c*poly[i];
		}
		return ans;
	}
	/** 
	 * This function computes a readable String representation of the given polunom (as an array of doubles).
	 * @param poly - the polynom
	 * @return - a String representing this polynom.
	 */
	public static String poly(double[] poly) {
		String ans = "";
		for(int i=poly.length-1; i>=0;i--) {
			if(poly[i]!=0) {
				String c = " ";
				if(poly[i]>0) {c=" +";}
				c+=poly[i];
				if(i>0) {c+="x";}
				if(i>1) {c+="^"+i;}
				ans +=c;
			}
		}
		if(ans.length()==0) {ans="0";}
		return ans;
	}
	/**
	 * This function search for a real value x, such that: x1<=x<=x2 & |p(x)|<eps,
	 * assuming p(x1)*p(x2)<=0;
	 * The algorithm is an implementation of the Bisection-Method, see:
	 * https://en.wikipedia.org/wiki/Bisection_method
	 * @param p - the polynom
	 * @param x1 - first (smaller) value.
	 * @param x2 - second (greater) value.
	 * @param eps - positive epsilon for which p(x) should be lower than (eps).
	 * @return - a real value x for which |p(x)|<eps, assuming: x1<=x<=x2 & p(x1)*p(x2)<=0;
	 */
	public static double root_itertive(double[] p, double x1, double x2, double eps) {
		double ans = Double.MAX_VALUE;
		double f1 = f(p,x1);
		double f2 = f(p,x2);
		double x12 = (x1+x2)/2;
		double f12 = f(p,x12);
		while (f1*f2<=0 && Math.abs(f12)>=eps) {
			if(f12*f1<=0) {x2=x12;f2= f(p,x2);}
			else {x1=x12;f1 = f(p,x1);}
			x12 = (x1+x2)/2;
			f12 = f(p,x12);
		}
		return x12;
	}
	/**
	 * This function computes a new polynom representation which is the sum of two
	 * given polynoms p1+p2.
	 * Note: it returns a compact representation of the result polynom.
	 * @param p1 - first polynom
	 * @param p2 - second polynom
	 * @return p1+p2
	 */
	public static double[] add(double[] p1, double[] p2) {
		int s1 = p1.length, s2 = p2.length, mp=Math.max(s1, s2);
		double[] ans = new double[mp];
		for(int i=0;i<mp;i++) {
			double v1=0, v2=0;
			if(i<s1) {v1 = p1[i];}
			if(i<s2) {v2 = p2[i];}
			ans[i] = v1+v2;
		}
		ans = compact(ans);
		return ans;
	}
	/**
	 * This function computes a new polynom representation which is the multiplication of two
	 * given polynoms p1*p2.
	 * Note: it returns a compact representation of the result polynom.
	 * @param p1 - first polynom
	 * @param p2 - second polynom
	 * @return p1*p2 
	 */
	public static double[] mul(double[] p1, double[] p2) {
		double[] ans = new double[1];
		for(int i=0;i<p1.length;i++) {
			double[] cp1 = mul(p1[i], i, p2);
			ans = add(ans, cp1);
		}
		ans = compact(ans);
		return ans;
	}
	/**
	 * This function computes a new polynom representation which is the multiplication of two
	 * given polynoms p*aX^b (the Monom coef*x^pow).
	 * Note: it returns a compact representation of the result polynom.
	 * @param p - the polynom
	 * @param coef - coefficient (linear-real value)
	 * @param pow - the power (natural number)
	 * @return p*Monom (Monom = coef*X^pow)
	 */
	public static double[] mul(double coef, int pwr, double[] p) {
		if(coef==0) {return new double[0];}
		double[] ans = new double[p.length+pwr];
		for(int i=0;i<p.length;i++) {
			ans[i+pwr] = p[i]*coef;
		}
		return ans;
	}
	/**
	 * This function compute a new polynom which is the derivative of po).
	 * Note: it returns a compact representation of the result polynom.
	 * @param po - the polynom
	 * @return the derivative polynom of po.
	 */
	public static double[] derivative (double[] po) {
		int s = Math.max(0,po.length-1);
		double[] ans = new double[s];
		for(int i=0;i<s;i++) {
			ans[i] = (i+1)*po[i+1];
		}
		ans = compact(ans);
		return ans;
	}
	/** a help function for compact representation - removes zeros*/
	public static double[] compact(double[] po) {
		int size=po.length;
		if(size==0 || po[size-1]!=0) {return po;}
		size--;
		while(size>0 && po[size]==0) {size--;}
		double[] ans = new double[size+1];
		for(int i=0;i<=size;i=i+1) {
			ans[i] = po[i];
		}
		return ans;
	}
	///////// Nice to have - not part of Ex2///////////
	/**
	 *Recursive implementation if iterative_root.
	 */
	public static double root(double[] p, double x1, double x2, double eps) {
		double ans = Double.MAX_VALUE;
		double f1 = f(p,x1);
		double f2 = f(p,x2);
		if(f1*f2<=0 && eps>0) {
			double x12 = (x1+x2)/2;
			double f12 = f(p,x12);
			if (Math.abs(f12)<eps) {return x12;}
			else {
				if(f12*f1<=0) {return root(p, x1,x12,eps);}
				else {return root(p, x12, x2,eps);}
			}
		}
		return ans;
	}
	/**
	 * Computes an array of doubles representing a polynom from a poly-String.
	 * @param p - the String like polynom
	 * @return
	 */
	public static double[] getPolynomFromString(String p) {
		String[] pp = p.split(" "); //  -1.0x^2 +3.0x +2.0
		int size = 0;
		double[] ans = new double[0];
		for(int i=0;i<pp.length;i++) {
			if(pp[i].length()>1) {
				int pwr = getPower(pp[i]);
				double coef = getCoef(pp[i]);
				if(size==0) {size = pwr; ans=new double[size+1];}
				ans[pwr] = coef;
			}
		}
		return ans;
	}
	
	private static double getCoef(String s) {
		int t = s.indexOf("x");
		if(t==0) {return 1;}
		if(t>0) {s = s.substring(0,t);}
		double ans = Double.parseDouble(s);
		return ans;
	}
	private static int getPower(String s) {
		int t = s.indexOf("x");
		if(t==-1) {return 0;}
		t = s.indexOf("^");
		if(t==-1) {return 1;}
		String pr = s.substring(t+1);
		int ans = Integer.parseInt(pr);
		return ans;
	}
	
}
