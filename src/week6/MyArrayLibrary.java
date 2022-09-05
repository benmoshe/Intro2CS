package week6;
public class MyArrayLibrary {

	public static int[] randomIntArray(int size, int range){
		int[]arr = new int[size];
		++range;
		for(int i=0; i<size; i=i+1)
			arr[i] = (int)(Math.random()*range);
		return arr;
	}
	
	public static int[] randomIntArray(int size, int a, int b){
		int[]arr = new int[size];
		++b;
		for(int i=0; i<size; i=i+1)
			arr[i] = (int)(Math.random()*(b-a)) + a;
		return arr;
	}
	
	public static void printArray(int[] arr){
		int i;
		for(i=0; i<arr.length-1; i=i+1)
			System.out.print(arr[i]+", ");
		System.out.println(arr[i]);
	}
	
	public static void printArray(double[] arr){
		int i;
		for(i=0; i<arr.length-1; i=i+1)
			System.out.print(arr[i]+", ");
		System.out.println(arr[i]);
	}
	
	public static void printMatrix(int[][] mat){
		for (int i=0; i<mat.length; i++)
			printArray(mat[i]);
	}
	
	public static int[][] randomIntMatrix(int rows, int cols ,int a, int b){
		int[][] mat = new int[rows][cols];
		++b;
		for(int i=0; i<rows; i=i+1)
		{
			for (int j = 0; j < mat[0].length; j++)
				mat[i][j] = (int)(Math.random()*(b-a)) + a;
		}
		return mat;
	}
	
	public static boolean isSortedAscending(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] > arr[i]) {
				return false; }
		}
		return true;
	}
	public static boolean isSortedDescending(int[] arr){
		for (int i = 1; i < arr.length; i++) {
			if (arr[i-1] < arr[i]) {
				return false;}
		}
		return true;
	}
}
