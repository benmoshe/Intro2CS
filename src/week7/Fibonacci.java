package week7;

public class Fibonacci {

	public static long fibLoop(int n) {
		long f1 = 1, f2 = 1, ans = 1;
		for (int i=3; i<=n; i++)
		{
			ans = f1 + f2;
			f1 = f2;
			f2 = ans;
		}
		return ans;
	}
	
	public static long fibRecurs(int n) {
		if (n <= 1)
		    return n;
		return fibRecurs(n-1) + fibRecurs(n-2);
	}

	
	public static void main(String[] args) {
		int N = 40; // then change to 70
		long start = System.currentTimeMillis();
		for (int i=1; i<=N; i++){
			//fibLoop(i);
			System.out.print(fibLoop(i)+", ");
		}
		long end = System.currentTimeMillis();
		System.out.println("time of loop = "+(end-start)/1000.+" secs");
		start = System.currentTimeMillis();
		for (int i=1; i<=N; i++){
			//fibRecurs(i);
			System.out.print(fibRecurs(i)+", ");
		}
		end = System.currentTimeMillis();
		System.out.println("time of recurs = "+(end-start)/1000.+" secs");
	}
}
