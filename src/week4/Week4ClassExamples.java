package week4;

public class Week4ClassExamples {
	public static void main(String[] ar) {
		int[] perfect = {6,28};
		int[] nonePerfect = {12,7};
		
		int test= perfect[0];
		boolean shouldBeTrue = isPerfect(test);
		System.out.println(shouldBeTrue);
	}

	public static boolean isPerfect(int n) {
	// TODO Auto-generated method stub
		int sum = 0;
		for(int i=1;i<=n;i=i+1) {
			if(n%i==0) {sum = sum +i;}
		}
		return 2*n == sum;	
	}
}
