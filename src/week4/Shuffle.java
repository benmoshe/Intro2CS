package week4;

public class Shuffle { 

    // swaps array elements i and j
    public static void exch(String[] a, int i, int j) {
        String swap = a[i];
        a[i] = a[j];
        a[j] = swap;
    }

    // take as input an array of strings and rearrange them in random order
    public static void shuffle(String[] a) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int r = i + (int) (Math.random() * (n-i));   // between i and n-1
            exch(a, i, r);
        }
    }

    // take as input an array of strings and print them out to standard output
    public static void show(String[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }


    public static void main(String[] args) { 
        // read all lines from standard input
        String[] a = {"123", "abc", "cba", "321", "aa", "ba12"};

        // shuffle array and print permutation
        shuffle(a);
        show(a);

        System.out.println();

        // do it again
        shuffle(a);
        show(a);

    }
}