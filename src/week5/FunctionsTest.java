package week5;


public class FunctionsTest {

	public static void swap(int x, int y){
		int temp = x;
		x = y;
		y = temp;
	}
	
	public static void swap(int i, int j, int arr[]){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	public static void main(String[] args) {
		int a = 3, b = 8;
		int[] arr = {1,2,3,4,5,6,7,8};
		
		swap(a,b);
		swap(2,7,arr);
		System.out.println(a + "," + b);
		for(int i : arr)
			System.out.print(i + ",");
	}

}
