package week4;

public class Shuffle { 

    // swaps array elements i and j
    public static void exch(String[] a, int i, int j) {
        String swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }
    
    // take as input an array of strings and print them out to standard output
    public static void show(String[] a) {
    	System.out.println();
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+",");
        }
    }

    // take as input an array of strings and rearrange them in random order
    public static void shuffle(String[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = (int) (Math.random() * (n));   // between i and n-1
            exch(a, i, r);
        }
    }
    
    public static void sort(String[] arr) {
    	int len = arr.length;
    	for(int i=0;i<len;i=i+1) {
    		int min = minInd(arr,i,len); // min index(min,lenght)
    		exch(arr,i,min); 			 // swaps the ith index with the min(i,min)
    	}
    }
    
    public static int minInd(String[] a, int min, int max) {
    	int ans = min;
    	for(int i=min+1;i<max && i<a.length; i=i+1) {
    		if(a[i].compareTo(a[ans])<0 ) {
    			ans=i;
    		}
    	}
    	return ans;
    }
    
    public static void main(String[] args) { 
    	int size = 10;
        String[] a = new String[size];
        for(int i=0;i<a.length;i=i+1) {
        	a[i] = "_"+i;
        }
        // shuffle array and print permutation
        show(a);
        System.out.println();
        
        shuffle(a);
        show(a);

        // do it again
        shuffle(a);
        show(a);
        
        sort(a);
        show(a);
    }
}