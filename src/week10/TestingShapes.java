package week11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

import week10.Circle2D;
import week10.Ellipse2D;
import week10.GeoShape;
import week10.Point2D;

public class TestingShapes {

	public static void main(String[] args) {
	//	test1();
	//	test2();
		test3();
	}
	public static void test1() {
		GeoShape[] sh = new GeoShape[4];
		Point2D p = new Point2D(1,0.3);
		sh[0] = p;
		sh[1] = new Point2D(-1,3);
		sh[2] = new Circle2D(p, 2.5);
		sh[3] = sh[2].copy();
		
		for(int i=0;i<4;i=i+1) {
			System.out.println(i+") "+sh[i].toString()+"  type: "+sh[i].getClass().getSimpleName());
		}
		for(int i=0;i<4;i=i+1) {
			sh[i].move(p);
			System.out.println(i+") "+sh[i].toString());
		}
		Object t1 = new String("abc"); // aka = "abc";
		System.out.println(t1.toString()+"  "+t1.getClass().getName()+"  "+(t1 instanceof String));
		t1 = new String[2]; 
		System.out.println(t1+"  "+(t1 instanceof String[]));
		double a = 4;
		t1 = 4.0;// new Integer(4);
		if(t1.equals(a)) {
			System.out.println("YES");
		}
		System.out.println(t1.toString());
		t1 = null;
		System.out.println(t1);
	}
	public static void test2() {
		int size = 10;
		GeoShape[] sh = new GeoShape[size];
		for(int i=0;i<sh.length;i=i+1) {
			double d = Math.random(); // [0,1)
			if(d<0.3) { sh[i] = new Point2D(i,i);}
			if(d>=0.3 && d<0.6) { sh[i] = new Circle2D(new Point2D(Point2D.ORIGIN), i);}
			if(d>=0.6) { 
				Point2D p1 = new Point2D(i,i);
				Point2D p2 = new Point2D(i*2,i*3);
				double rad = p1.distance(p2)+3;
				sh[i] = new Ellipse2D(p1,p2,rad);
			}
 		}
		int n = numberOfClasses_better(sh);
		int n1 = numberOfClasses_yet_another_algo(sh);
		System.out.println(n+"  "+n1);
		
	}
	/**
	 * NOTE: this code is very Wrongly Written - do not use it.
	 * This function computes the size of the set representing all the classes from which the 
	 * GeoShape objects in the array sh belongs to.
	 * Example please: (TBD)
	 * 
	 *  @param array of GeoShape
	 * 
	 * @return the number of Different classes the objects in sh belongs to.
	 */
	public static int numberOfClasses(GeoShape[] sh) {
		int ans = 0;
		int i=0;
		final int ind_point=i++, ind_circle=i++, ind_ellipse = i++;
		int[] numbers = new int[i];
		if(sh!=null && sh.length>0) {
			for(int a=0;a<sh.length;a=a+1) {
				GeoShape cr = sh[a];
				if(cr instanceof Point2D) {numbers[ind_point]+=1;}
				if(cr instanceof Circle2D) {numbers[ind_circle]+=1;}
				if(cr instanceof Ellipse2D) {numbers[ind_ellipse]+=1;}
			}
			for(int a=0;a<numbers.length;a=a+1) {
				if(numbers[a]>0 ) {ans+=1;}
			}
		}
		return ans;
	}
	/**
	 * Algo (Liav): use a temp "array" 
	 * Algo (Alona): 
	 * 1. temp array (shc) of Strings: 
	 * representing the class name of each GeoShape in sh
	 * 2. sort(shc)
	 * 3. find the number of different Strings in shc
	 * @param sh
	 * @return
	 */
	public static int numberOfClasses_better(GeoShape[] sh) {
		int ans = 0;
		if(sh==null || sh.length==0) return 0;
		//sort_by_class
		String[] shc = new String[sh.length];
		for(int i=0;i<shc.length;i=i+1) {
			shc[i] = sh[i].getClass().getSimpleName();
		}
		Arrays.sort(shc);// ??
		ans=1;
		for(int i=1;i<shc.length;i=i+1) {
			String cr = shc[i];
			String cr0 = shc[i-1];
			if(!cr.equals(cr0)) {
				ans ++;
				}
		}
		return ans;
	}
	public static int numberOfClasses_yet_another_algo(Object[] sh) {
		if(sh==null || sh.length==0) return 0;
		//
		ArrayList<String> shc = new ArrayList<String>(); // ??
		for(int i=0;i<sh.length;i=i+1) {
			String cr = sh[i].getClass().getSimpleName();
			if(!shc.contains(cr)) {shc.add(cr);}
		}
		return shc.size();
	}
	public static void test3() {
		//var ll = new ArrayList<String>();
		ArrayList<String> ll = new ArrayList<String>();
		for(int a =0;a<6;a=a+1) {ll.add(""+a);}
		Iterator<String> iter = ll.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}
}
