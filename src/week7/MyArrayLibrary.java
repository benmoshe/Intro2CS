package week7;
public class MyArrayLibrary {

	
	public static double[] randomDoubleArray(int size, double min, double max){
		double[]arr = new double[size];
		double dx = max-min;
		for(int i=0; i<size; i=i+1) {
			arr[i] = Math.random()*dx + min;
		}
		return arr;
	}
	
	public static void printArray(double[] arr){
		int i;
		for(i=0; i<arr.length-1; i=i+1)
			System.out.print(arr[i]+", ");
		System.out.println(arr[i]);
	}
	
	public static void printMatrix(double[][] mat){
		for (int i=0; i<mat.length; i++)
			printArray(mat[i]);
	}
	
	public static double[][] randomDoubleMatrix(int rows, int cols ,double min, double max){
		double[][] mat = new double[rows][cols];
		double dx = max-min;
		for(int i=0; i<rows; i=i+1)
		{
				mat[i] = randomDoubleArray(cols,min,max);
		}
		return mat;
	}
	
	public static boolean isSortedAscending(double[] arr){
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] > arr[i]) {
				return false; }
		}
		return true;
	}
	public static boolean isSortedDescending(double[] arr){
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] < arr[i]) {
				return false;}
		}
		return true;
	}
}
