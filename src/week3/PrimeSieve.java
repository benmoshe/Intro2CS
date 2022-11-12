package week3;

public class PrimeSieve{
	public static void main(String[] args) {
		int n = MyConsole.readInt("Enter natural number: ");
		int limit = (int)Math.sqrt(n);
		
        // initially assume all integers are prime
        boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++)
            isPrime[i] = true;

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor <= limit; factor++)
        {
            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor])
            {
                for (int j = factor*factor; j <= n; j += factor)
                    isPrime[j] = false;
            }
        }

        // print primes
        for (int i = 2; i <= n; i++)
            if (isPrime[i])
            	System.out.println(i + ", ");
    }
}
	