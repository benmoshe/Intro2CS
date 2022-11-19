package week5;

public class StringFunctions {
	public static void main(String[] a) {
		String t = "12321";
		boolean v = isSimetric(t);
		String s = "12345";
		String rev_s = reverse(s);
		String rev2_s = reverse(rev_s);
		System.out.println("str: "+t+" isSimetric: "+v);
		System.out.println("s="+s+",  rev(s)="+rev_s+",  rev(rev(s))="+rev2_s);
		System.out.println(s.equals(rev2_s));
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
		for(int i=s.length()-1; i>=0;i=i-1) {
			ans=ans+s.charAt(i);
		}
		return ans;
	}
}
