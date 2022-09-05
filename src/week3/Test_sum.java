package week3;
/**
 * This is a test class, 
 * that computes the sum of all digits of a n integer number.
 * @author boaz.benmoshe
 *
 */
public class Test_sum {
	public static void main(String[] args) {
	    int num, sum=0;
		 num = 5814;
		// int i=0;
		// while (num != 0)  {
		 for(int i=0 ; num!=0 ; num = num/10) {
			int curr = (num%10);
			System.out.println(i+") Sum is " + sum+"  current digit: "+curr);
			sum = sum + curr;
			//num = num/10;
			i=i+1;
		 }
		 System.out.println("Sum is " + sum);
	}

}
