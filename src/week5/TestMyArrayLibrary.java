package week5;

public class TestMyArrayLibrary {
	
	public static void main(String[] args) {
		final int MAX = 100, SIZE = 10, LOW = 20, HIGH = 30, COLS = 6, ROWS = 8;
		double[] doubleArr = {1.0, 2.3, 5.7, 6.6, 7.7, 10.2, 20.0, 24.5};
		
		System.out.println("Double array:");
		MyArrayLibrary.printArray(doubleArr);
		int[] arr = MyArrayLibrary.randomIntArray(SIZE, MAX);
		System.out.println("Int array:");
		MyArrayLibrary.printArray(arr);
		arr = MyArrayLibrary.randomIntArray(SIZE, LOW, HIGH);
		System.out.println("Int array:");
		MyArrayLibrary.printArray(arr);
			
		int[][] mat  = MyArrayLibrary.randomIntMatrix(COLS, ROWS, LOW, HIGH);
		System.out.println("Int matrix:");
		MyArrayLibrary.printMatrix(mat);
	}
}
