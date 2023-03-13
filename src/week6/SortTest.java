package week6;

import static org.junit.jupiter.api.Assertions.*;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;

class SortTest {
	public static final int K = 1000, M = K*K;
	public static int[] arrK = null;
	public static int[] arrM = null;
	public static double[] arrDoubleM = null;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}
	@BeforeEach
	void setUp() {
		arrK = MyArrayLibrary.randomIntArray(K, K);
		arrM = MyArrayLibrary.randomIntArray(M, M);
		arrDoubleM = MyArrayLibrary.randomDoubleArray(M, 0, M);
	}
	@Test 
	void testMergeSort() {
		int[] a1 = {3,1,2,1,42};
		Sort.mergeSort(a1);
		boolean isSorted = MyArrayLibrary.isSortedAscending(a1);
		assertTrue(isSorted);
	}
	@Test 
	void testMergeSort_large_array() {
		int[] a1 = MyArrayLibrary.randomIntArray(1000, 1000);
		Sort.mergeSort(a1);
		boolean isSorted = MyArrayLibrary.isSortedAscending(a1);
		assertTrue(isSorted);
	}
	@Test 
	void testMerge() {
		double[] a1 = {1,3,7,9};
		double[] a2 = {1,2,5,17,34};
		double[] a12 = Sort.mergeArrays(a1, a2);
		boolean isSorted = MyArrayLibrary.isSortedAscending(a12);
		assertTrue(isSorted);
	}
	@Test
	void testSwap() {
		int[] arr = {0,1,2,3,4};
		Sort.swap(arr, 1, 1);
		if(arr[1]!=1) {
			fail("arr[1] should be 1");} // hard coded!
		Sort.swap(arr, 0, 2);
		if(arr[0]!=2 || arr[2]!=0) {
			fail("arr[0] should be 2 and arr[2] should be 0");} // hard coded!
		Sort.swap(arr, 0, 2);
		if(arr[0]!=0 || arr[2]!=2) {
			fail("arr[0] should be 0 and arr[2] should be 2");} // hard coded!
	}

	@Test
	void testBubbleSort() {
		int[] arr = {5,1,2,0,9};
		Sort.bubbleSort(arr);
		if(MyArrayLibrary.isSortedAscending(arr)!=true) {
			fail("arr should be sorted");
		}
	}

	@Test
	void testSelectionSort() {
		int[] arr = {5,1,2,0,9};
		Sort.selectionSort(arr);
		if(MyArrayLibrary.isSortedAscending(arr)!=true) {
			fail("arr should be sorted");
		}
	}

	@Test
	void testSelectionSortDescending() {
		int[] arr = {5,1,2,0,9};
		Sort.selectionSortDescending(arr);
		if(MyArrayLibrary.isSortedAscending(arr)!=false) {
			fail("arr should NOT be sorted Ascending");
		}
		boolean is_sorted_descending = MyArrayLibrary.isSortedDescending(arr);
		assertTrue(is_sorted_descending);
	}


	@Test
	void testInsertionSort() {
		int[] arr = {5,1,2,0,9};
		Sort.insertionSort(arr);
		if(MyArrayLibrary.isSortedAscending(arr)!=true) {
			fail("arr should be sorted");
		}
	}
/////////////// Performance Testing /////////////
	@Test
	void testMergeSort1() {
			/////////// Recursive Merge Sort 
		long start = System.currentTimeMillis();
		Sort.mergeSort(arrM);
		long end = System.currentTimeMillis();
		double dt_sec = (end-start)/1000.0; 
		boolean isSorted = MyArrayLibrary.isSortedAscending(arrM);
		System.out.println("Recursive Merge sort time = "+dt_sec+" secs,  is sorted? "+ isSorted);
		assertTrue(isSorted);
		assertTrue(dt_sec<1.0);
	}
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testMergeSort2() {
		Sort.mergeSort(arrDoubleM);
		boolean isSorted = MyArrayLibrary.isSortedAscending(arrDoubleM);
		assertTrue(isSorted);
	}
	@Test
	@Timeout(value = 1000, unit = TimeUnit.MILLISECONDS)
	void testQuickSort1() {
		QuickSort.sort(arrDoubleM);
		boolean isSorted = MyArrayLibrary.isSortedAscending(arrDoubleM);
		assertTrue(isSorted);
	}
/** DIY: do complete the belowUnit Tests  (and many others) as shown above!
	@Test
	void testBinarySearch() {
		fail("Not yet implemented");
	}

	@Test
	void testCountingSort() {
		fail("Not yet implemented");
	}
	@Test
	void testFindMaxIndex() {
		fail("Not yet implemented");
	}
	@Test
	void testCountingSortV2() {
		fail("Not yet implemented");
	}
*/
}
