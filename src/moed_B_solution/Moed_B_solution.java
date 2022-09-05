package moed_B_solution;
/** 
 * This class represents a solution to Moed_B
 * introduction to Computer Science, Ariel University.
 */
public class Moed_B_solution {

		public static final long _id = 123456789; // Make sure you update you ID!

	///////////// Q1 ////////////
		public static int gcd(int[] numbers){
			int ans = numbers[0];
			for(int i=1;i<numbers.length;i=i+1) {
				ans = gcd(numbers[i], ans);
			}
			return ans;
		}
		public static int gcd(int x, int y) {
			if(x%y==0) {return y;}
			if(y>x) {return gcd(y,x);}
			return gcd(x%y,y);
		}
		///////////// Q2 ////////////
		///////// Q2.1 ///////////
		public static boolean isSet(ListInterface l) {
			boolean ans = true;
			for(int i=0;i<l.size() && ans; i=i+1) {
				int ci = count(l, l.get(i)); 
				if(ci>1) {ans = false;}
			}
			return ans;
		}
		public static int count(ListInterface l, int v) {
			int ans = 0;
			for(int i=0;i<l.size(); i=i+1) {
				if(l.get(i)==v) {ans+=1;}
			}
			return ans;
		}
		//////////// Q2.2 ///////////
		public static ListInterface toSet(ListInterface l) {
			ListInterface ans = new LinkedList();
			for(int i=0;i<l.size(); i=i+1) {
				int v = l.get(i);
				if(count(ans, v)==0) {ans.addAt(v, 0);}
			}
			return ans;
		}
		
		//////////// Q2.3 ///////////
		public static ListInterface intersection(ListInterface l1, ListInterface l2) {
			ListInterface ans = new LinkedList();
			for(int i=0;i<l1.size();i=i+1) {
				int c = l1.get(i);
				if(count(l2,c)>0) {
					ans.addAt(c,0);
				}
			}
			ans = toSet(ans);
			return ans;
		}
		
		//////////// removed form Q2: Q2.4 ///////////
	//	public static ListInterface union(ListInterface l1, ListInterface l2) {
	//		ListInterface ans = toSet(l1);
	//		for(int i=0;i<l2.size();i=i+1) {
	//			ans.addAt(l2.get(i),0);
	//		}
	//		ans = toSet(ans);
	//		return ans;
	//	}
		//////////// Q3 ///////////
		public static int codes_rec(int n, int k){
			if(k==1) {return n;}
			return n*codes_rec(n-1,k-1);
		}
		
		
		public static String[] allCodes(){
			int size = 5*4*3*2;
			String[] ans  = new String[size];
			int i=0;
			for(int a=1000;a<=9999;a++) {
				String s = ""+a;
				if(legit(s)) {
					ans[i] = s+"#";
					i+=1;
				}
			}
			return ans;
		}
		private static boolean legit(String s) {
			if(s==null | s.length()!=4) {return false;}
			int a = 0;
			for(int i=1;i<=5;i+=1) {
				if(s.contains(""+i)) {a+=1;}
			}
			return a==4;
		}
		public static String[] allCodes1(){
			int size = 5*4*3*2;
			String[] ans  = new String[size];
			int i=0;
			for(int a=1;a<=5;a++) {
				for(int b=1;b<=5;b++) {
					for(int c=1;c<=5;c++) {
						for(int d=1;d<=5;d++) {
							if(a!=b & a!=c & b!=c & c!=d & b!=d& a!=d) {
								String s = ""+a+b+c+d+"#";
								ans[i] = s;
								i+=1;
							}
						}
					}
				}
			}
			return ans;
		}
}
