package week7;
/**
 * Java program for implementation of QuickSort 
 * @author Rajat Mishra, from: https://www.geeksforgeeks.org/quick-sort/
 *
 */

class QuickSort 
{ 
 /* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
 public static int partition(double arr[], int low, int high) 
 { 
	 double pivot = arr[high];  
     int i = (low-1); // index of smaller element 
     for (int j=low; j<high; j++) 
     { 
         // If current element is smaller than the pivot 
         if (arr[j] < pivot) 
         { 
             i++; 
             // swap arr[i] and arr[j] 
             double temp = arr[i]; 
             arr[i] = arr[j]; 
             arr[j] = temp; 
         } 
     } 
     // swap arr[i+1] and arr[high] (or pivot) 
     double temp = arr[i+1]; 
     arr[i+1] = arr[high]; 
     arr[high] = temp; 

     return i+1; 
 } 
 /* The main function that implements QuickSort() 
 arr[] --> Array to be sorted, 
 low  --> Starting index, 
 high  --> Ending index */
public static void sort(double arr[]) {
	quickSort(arr, 0, arr.length-1);
}

 /* The main function that implements QuickSort() 
   arr[] --> Array to be sorted, 
   low  --> Starting index, 
   high  --> Ending index */
 public static void quickSort(double arr[], int low, int high) 
 { 
     if (low < high) 
     { 
         /* pi is partitioning index, arr[pi] is  
           now at right place */
         int pi = partition(arr, low, high); 
         // Recursively sort elements before 
         // partition and after partition 
         quickSort(arr, low, pi-1); 
         quickSort(arr, pi+1, high); 
     } 
 } 

 /* A utility function to print array of size n */
 public static void printArray(double arr[]) 
 { 
     int n = arr.length; 
     for (int i=0; i<n; ++i) 
         System.out.print(arr[i]+" "); 
     System.out.println(); 
 } 

 // Driver program 
 public static void main(String args[]) 
 { 
     double arr[] = {10, 7, 8, 9, 1, 5}; 
     int n = arr.length; 
     sort(arr); 
     System.out.println("sorted array"); 
     printArray(arr); 
 } 
} 
/*This code is contributed by Rajat Mishra */