package week5;

public class StringFunctions {
	public static void main(String[] a) {
		String t = "12321";
		boolean v = isSimetric(t);
		String rev_t = reverse(t);
		System.out.println("str: "+t);
		System.out.println("rev(str): "+rev_t);
		String words = "these are few words ...";
		String[] ww = words.split(" ");
		for(int i=0;i<ww.length;i=i+1) {
			System.out.println(i+") "+ww[i]);
		}
	}
	/*
	 * 3, (4*2), (2-((4*2)*(4*2)))
	 * 2-((4*2)*(4*2))
	 * 
	 */
	public static boolean isSimetric(String s) {
		boolean ans = false;
		String t = reverse(s);
		//boolean r = (t==s);  // Huge BUG!!
		ans = t.equals(s);
		return ans;
	}
	public static String reverse(String s) {
		String ans = "";
//		for(int i=0;i<s.length();i=i+1) {
//			ans=s.charAt(i)+ans;
//		}
		for(int i=s.length()-1; i>=0;i=i-1) {
			ans=ans+s.charAt(i);
		}

		return ans;
	}
}
