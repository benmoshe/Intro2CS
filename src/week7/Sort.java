package week7;
import java.util.Arrays;
/**
 * output for 40,000 int array:
Bubble sort time = 2.899 secs,  is sorted? true
Selection sort time = 0.588 secs,  is sorted? true
Insertion sort time = 1.133 secs,  is sorted? true
My slow Insertion sort time = 1.7 secs,  is sorted? true
Recursive Merge sort time = 0.037 secs,  is sorted? true
Java sort time = 0.015 secs,  is sorted? true

Found at index 20000 the item 50.16132041348263
 */
public class Sort {

	public static void swap(double[] arr, int i, int j)  {
		double temp = arr[i];
	     arr[i] = arr[j];
	     arr[j] = temp;
	}

	
	public static void bubbleSort(double arr[]) {
		boolean hasChanged=true;

		for (int i=arr.length-1 ; i > 0 && hasChanged ; i-- )
		{
			hasChanged = false;
		    for (int  j=0 ; j < i ; j++ )
		    {	
			   if (arr[j] > arr[j+1])
			   {  
			         swap(arr, j, j+1);
			         hasChanged = true;
			   }        
		    }      
		}
	}

	
	public static void selectionSort(double[] arr) {
	    for (int i=0 ; i < arr.length ; i++)
	    {
	         int minIndex = i;
	         for (int j=i+1 ; j < arr.length ; j++)
	         {
	        	 if (arr[j] < arr[minIndex])
	        		 minIndex = j;
	         }
	         swap(arr, i, minIndex);
	    }
	}
	
	
	public static void selectionSortDescending(double[] arr) {
	    int maxIndex;
		for (int i=0 ; i < arr.length ; i++)
	    {
	    	maxIndex = findMaxIndex(arr,i);
	    	swap(arr, i, maxIndex);
	    }
	}
	
	
	public static int findMaxIndex(double[] arr, int start) {
		int maxIndex = start;
		for(int i=start+1; i < arr.length ;i++)
		{
			if (arr[i] > arr[maxIndex])
				maxIndex = i;
		}
		return maxIndex;
	}
	
	
	public static void insertionSort(double[] arr) {
	    for (int  i=1 ; i < arr.length ; i++)
	    {
	      for (int  j=i ; j > 0 && arr[j-1] > arr[j] ; j--)
	      {
	    	  double  temp = arr[j];
		      arr[j] = arr[j-1];
		      arr[j-1] = temp;
	      }
	   }
	}
	/**
	 * This function uses a simple additional array to implement insertion sort 
	 * @param arr
	 */
	public static void myInsertionSort(double[] arr) {
		int size = arr.length;
		double[] copy = new double[size];
	    for (int  i=0 ; i < arr.length ; i++)	    {
	    	int index = findMySortedIndex(arr,i); // compute how many entries are smaller than arr[i]
	    	int sameIndx = findHowManyAreTheSame(arr,i);
	    	copy[index+sameIndx] = arr[i];
	    }
	    for(int i=0;i<size;i=i+1) {
	    	arr[i] = copy[i];
	    }
	}
	// computes the proper index of ind in the array
	public static int findMySortedIndex(double[] a, int ind) {
		int ans = 0;
		for(int i=0;i<a.length;i=i+1) {
			if(a[i]<a[ind]) {ans = ans +1;}
		}
		return ans;
	}
	// computes the proper index of ind in the array
		public static int findHowManyAreTheSame(double[] a, int ind) {
			int ans = 0;
			for(int i=0;i<ind;i=i+1) {
				if(a[i]==a[ind]) {ans = ans +1;}
			}
			return ans;
		}
		
		//////////// MERGE SORT ////////////////
		
		public static void mergeSort(double[] a) {
			int size = a.length;
			if(size>=2) {
				int mid = size/2;
				double[] left = getSubArray(a,0,mid);
				double[] right = getSubArray(a,mid,size);
				mergeSort(left); // recursive call
				mergeSort(right); // recursive call
				double[] merge = mergeArrays(left,right);
				for(int i=0;i<merge.length;i=i+1) {
					a[i] = merge[i];
				}
			}
		}
		public static double[] getSubArray(double[] a, int min, int max) {
			double[] ans = new double[max-min];
			for(int i=min;i<max;i=i+1) {
				ans[i-min] = a[i];
			}
			return ans;
		}
		
		/**
		 * This function merges two sorted arrays into a single 
		 * sorted array.
		 * @param arr1
		 * @param arr2
		 * @return
		 */
		public  static  double[]  mergeArrays(double arr1[],  double arr2[]) {
			double[]  res = new double[arr1.length + arr2.length];
			int i=0, j=0;
			while ( i < arr1.length && j < arr2.length )	{
				if (arr1[i] <= arr2[j]) { 
				      res[i+j] = arr1[i]; i=i+1;
				}
				else {
				      res[i+j] = arr2[j]; j=j+1;
				}
			}
			while ( i < arr1.length) {res[i+j] = arr1[i++];}
			while ( j < arr2.length) {res[i+j] = arr2[j++];}
		     return res;
		}
	
		public static void pivotSort(int[] a, int start, int end) {;}
		
	public static void main(String[] args) {
		final int SIZE = 40000; // then change upto 100000
		double[] arr1 = MyArrayLibrary.randomDoubleArray(SIZE, 0, 100);
		double[] arr2 = Arrays.copyOf(arr1,arr1.length);
		double[] arr3 = Arrays.copyOf(arr1,arr1.length);
		double[] arr4 = Arrays.copyOf(arr1,arr1.length);
		double[] arr5 = Arrays.copyOf(arr1,arr1.length);
		double[] arr6 = Arrays.copyOf(arr1,arr1.length);
		double[] arr7 = Arrays.copyOf(arr1,arr1.length);
		//////// bubbleSort
		long start = System.currentTimeMillis();
		bubbleSort(arr1);
		long end = System.currentTimeMillis();
		boolean b = MyArrayLibrary.isSortedAscending(arr1);
		double dt = (end-start)/1000.0;
		System.out.println("Bubble sort time = "+dt+" secs,  is sorted? "+ b);
		
		//////// selectionSort
		start = System.currentTimeMillis();
		selectionSort(arr2);
		end = System.currentTimeMillis();
		b = MyArrayLibrary.isSortedAscending(arr2);
		dt = (end-start)/1000.0;
		System.out.println("Selection sort time = "+dt+" secs,  is sorted? "+ b);

		//////// insertionSort
		start = System.currentTimeMillis();
		insertionSort(arr3);
		end = System.currentTimeMillis();
		b = MyArrayLibrary.isSortedAscending(arr3);
		dt = (end-start)/1000.0;
		System.out.println("Insertion sort time = "+dt+" secs,  is sorted? "+ b);

		///////// MyInsertionSort (should be slow!!)
		start = System.currentTimeMillis();
		myInsertionSort(arr4);
		end = System.currentTimeMillis();
		b = MyArrayLibrary.isSortedAscending(arr4);
		dt = (end-start)/1000.0;
		System.out.println("My slow Insertion sort time = "+dt+" secs,  is sorted? "+ b);

		/////////// Recursive Merge Sort 
		start = System.currentTimeMillis();
		mergeSort(arr5);
		end = System.currentTimeMillis();
		b = MyArrayLibrary.isSortedAscending(arr5);
		dt = (end-start)/1000.0;
		System.out.println("Recursive Merge sort time = "+dt+" secs,  is sorted? "+ b);
		
		////////// Java  built-in sort (Dual-pivot Quicksort)
		start = System.currentTimeMillis();
		Arrays.sort(arr6);
		end = System.currentTimeMillis();
		b = MyArrayLibrary.isSortedAscending(arr6);
		dt = (end-start)/1000.0;
		System.out.println("Java sort time = "+dt+" secs,  is sorted? "+ b);
		
		////////// "Our" pivot Quicksort)
		start = System.currentTimeMillis();
		QuickSort.sort(arr7);
		end = System.currentTimeMillis();
		b = MyArrayLibrary.isSortedAscending(arr7);
		dt = (end-start)/1000.0;
		System.out.println("Our QuickSort time = "+dt+" secs,  is sorted? "+ b);
		
		/// binary  search
		System.out.println();
		double should_be_found = arr4[arr4.length/2];
		int found = binarySearch(arr4,should_be_found,0,arr4.length-1);
		if(found != -1) {
			System.out.println("Found at index " + found + " the item " + arr4[found]);
		}
		else {
			System.out.println("I didn't find it");
		}
	}
	
	public static int binarySearch(double[] arr, double item) {
		return binarySearch(arr,item,0,arr.length);
	}
	public static int binarySearch(double[] arr, double item, int left, int right) {
		if(left>right)
			return -1;
		
		int middle = (left+right)/2;
		if(arr[middle]==item)
			return middle;
		if(arr[middle]>item)
			return binarySearch(arr,item,left,middle-1);
		else
			return binarySearch(arr,item,middle+1,right);
	}

	//sort array which contains numbers in the range [0,N)
	public static void countingSort(int[]arr, int N) {
		int index;
		N++;
		int freq[] = new int[N];
		for (int i = 0; i < arr.length; i++)
		{
			index = arr[i];
			freq[index]=freq[index]+1;
		}
		int j = 0;
		for (int k=0; k<freq.length; k++)
			for (int i=0; i<freq[k]; i++)
				arr[j++] = k;
	}
	
	public static void countingSortV2(int[] arr) {
		int min = arr[0], max = arr[0];
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i]>max)
				max = arr[i];
			else if (arr[i]<min)
				min = arr[i];
		}
		int freq[] = new int[max-min+1];
		for (int i = 0; i < arr.length; i++)
			freq[arr[i]-min]++;
		int j = 0;
		for (int k=0; k<freq.length; k++)
			for (int i=0; i<freq[k]; i++)
				arr[j++] = k+min;
	}
}
