package week7;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class SortTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}
	@Test 
	void testMergeSort() {
		double[] a1 = {3,1,2,42, 1.3};
		Sort.mergeSort(a1);
		boolean isSorted = MyArrayLibrary.isSortedAscending(a1);
		assertTrue(isSorted);
	}
	@Test 
	void testMergeSort_large_array() {
		double[] a1 = MyArrayLibrary.randomDoubleArray(1000,0,10);
		Sort.mergeSort(a1);
		boolean isSorted = MyArrayLibrary.isSortedAscending(a1);
		assertTrue(isSorted);
	}
	@Test 
	void testMerge() {
		double[] a1 = {1,1,3,7.3,9};
		double[] a2 = {1,2,5,17,34};
		double[] a12 = Sort.mergeArrays(a1, a2);
		boolean isSorted = MyArrayLibrary.isSortedAscending(a12);
		assertTrue(isSorted);
	}
	@Test
	void testSwap() {
		double[] arr = {0,1,2,3,4};
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
		double[] arr = {5,1,2,0.1,9};
		Sort.bubbleSort(arr);
		if(MyArrayLibrary.isSortedAscending(arr)!=true) {
			fail("arr should be sorted");
		}
	}

	@Test
	void testSelectionSort() {
		double[] arr = {5,1,2,0,9};
		Sort.selectionSort(arr);
		if(MyArrayLibrary.isSortedAscending(arr)!=true) {
			fail("arr should be sorted");
		}
	}

	@Test
	void testSelectionSortDescending() {
		double[] arr = {5,1,2,0,9};
		Sort.selectionSortDescending(arr);
		if(MyArrayLibrary.isSortedAscending(arr)!=false) {
			fail("arr should NOT be sorted Ascending");
		}
		boolean is_sorted_descending = MyArrayLibrary.isSortedDescending(arr);
		assertTrue(is_sorted_descending);
	}


	@Test
	void testInsertionSort() {
		double[] arr = {5,1,2,0.1,9};
		Sort.insertionSort(arr);
		if(MyArrayLibrary.isSortedAscending(arr)!=true) {
			fail("arr should be sorted");
		}
	}

	
/** DIY: do complete the below Unit Tests as shown above!
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
