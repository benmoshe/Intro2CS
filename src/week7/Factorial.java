package week7;

public class Factorial {
		
	public static long factorialRecurs(int n){
		if (n <= 1)
			return 1;
	    return factorialRecurs(n-1)*n;
	}
	
	public static long factorialLoop(int n) {
		long product = 1;
		for(int i=1; i <= n ;++i)
			product *= i;
		return product;
	}

	
	public static void main(String[] args) {
		final int N = 20; // then change to 30
		long start = System.currentTimeMillis();
		long result;
		for (int i=0; i<=N; i++){
			result = factorialLoop(i);
			System.out.println("factorial("+i+") = "+result);
		}
		long end = System.currentTimeMillis();
		System.out.println("time of loop = "+(end-start)/1000.+" secs");
		start = System.currentTimeMillis();
		for (int i=0; i<=N; i++){
			result = factorialRecurs(i);
			System.out.println("factorial("+i+") = "+result);
		}
		end = System.currentTimeMillis();
		System.out.println("time of recurs = "+(end-start)/1000.+" secs");
	}
}