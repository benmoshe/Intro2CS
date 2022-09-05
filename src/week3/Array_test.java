package week3;

public class Array_test {
	public static void main(String[] aa) {
		String[] ar = {"123", "aaaa", "~~~"};
		double[] dd = {1,2,3,4009.4,-5};
		double[] cc = new double[dd.length];
		for(int i=0;i<cc.length;i++) {cc[i] = dd[i];}
		//cc=dd;
		System.out.println("cc==dd "+(cc==dd));
		dd[0]= -1;
//		double sum = 0;
		
		double[][] arr_2d;
		arr_2d = new double[3][];
		arr_2d[0] = cc;
		arr_2d[1] = dd;
		dd = cc;
		arr_2d[2] = dd;
		cc[1] = 3;
		
	}
}
