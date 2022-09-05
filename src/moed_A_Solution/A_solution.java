package moed_A_Solution;
import java.util.Arrays;

import moed_A_part1.LinkedList;
import moed_A_part1.ListInterface;
import moed_A_part2.GeoShape;
import moed_A_part2.ShapeFilter;

/** 
 * This class is a solution for Moed_A, in some cases it contains few possible solutions (all acceptable).
 * @author boaz.ben-moshe
 *
 */
public class A_solution {
	public static int s(int d) {return d*2;}
	public static int r(int d) {return d+1;}
	
	
///////////// Q1 ////////////
	/** 
	 * This function receives a Form like String, and assuming it is a valid Form - it computes its value.
	 * 
	 * @param f - a Form like String - assume in a valid form.
	 * @return - the value (int) of the form.
	 */
	public static int calc(String f) {
		int ans = 0;
		char c = f.charAt(0);
		if(c=='s' | c=='r') {
			String t = f.substring(2,f.length()-1);
			int d1 = calc(t);
			if(c=='s') {ans = s(d1);}
			if(c=='r'){ans = r(d1);}
		}
		else { 
			char e = f.charAt(f.length()-1);
			if(c=='(' && e==')') {ans = calc(f.substring(1,f.length()-1));}
			else {ans = Integer.parseInt(f);}
		}
		return ans;
	}
	/**
	 * This function receives a String and test if it is a valid Form String - if so return true, else false.
	 * The function tries to "calc" the From - assuming it is a valid one - it an exception is thrown returns false, else true/
	 * @param f - a String (to be tested if it is a valid Form)
	 * @return - true iff f is a valid form
	 */
	public static boolean isForm(String f) {
		boolean ans = true;
		try {double d = calc(f);}
		catch(Exception e) {
			ans = false;
		}
		return ans;
	}
	
	///////////// Q2 ////////////
	// Q2.1
	/** 
	 * This function assumes l is a sorted (smallest first) linked-list, it adds ״data״ (int) in the sorted order.
	 * @param l
	 * @param data
	 */
	public static void addSorted(ListInterface l, int data) {
		int p = 0;
		while(p<l.size() && l.get(p)<data) {p=p+1;}
		l.addAt(data, p);
	}
	/**
	 * This function receives two list (as interface) and combined them into a new (sorted) list.
	 * @param l1 - first list
	 * @param l2 - second list
	 * @return - a new (sorted) list containing both l1 & l2
	 */
	public static ListInterface merge(ListInterface l1, ListInterface l2) {
		ListInterface ans = new LinkedList();
		for(int i=0;i<l1.size();i=i+1) {
			addSorted(ans, l1.get(i)); }
		for(int i=0;i<l2.size();i=i+1) {
			addSorted(ans, l2.get(i)); }
		return ans;
	}
	/**
	 * This function receives an array of lists (as interface) and combined them into a new (sorted) list.
	 * @param ll - an array of lists
	 * @return a new (sorted) list containing all the data of the lists.
	 */
	public static ListInterface merge(ListInterface[] ll) {
		ListInterface ans = new LinkedList();
		for(int i=0;i<ll.length;i=i+1) {
			ans = merge(ans,ll[i]);
		}
		return ans;
	}
////////////// Q3 /////////////////
	/**
	 * We present 3 possible sorting option - each os a valid solution
	 * @param s
	 * @return
	 */
public static String sort(String s) {
return sort1(s);
}
/** 
 * Uses java byte sort 
 * 
 * @param s
 * @return
 */
public static String sort1(String s) {
String ans = s;
byte[] arr = s.getBytes();
Arrays.sort(arr);
int i=0;
while(i<arr.length && arr[i] =='0') {i=i+1;}
byte[] arr0 = new byte[arr.length - i];
for(int a=i;a<arr.length;a=a+1) {
	arr0[a-i] = arr[a];
}
ans = new String(arr0);
return ans;
}
/**
 * Bucket sort - a bit tricky
 * @param s
 * @return
 */
public static String sort2(String s) {
String ans = s;
if(s!=null && s.length()>1) {
	int[] ch = new int[10];
	for(int i=0;i<s.length();i=i+1) {
		int c = s.charAt(i) -'0';
		if(c>0) {ch[c] +=1;}
	}
	ans = "";
	for(int i=1;i<ch.length;i=i+1) {
		for(int a=0;a<ch[i];a=a+1) {
			ans+=i;
		}
	}
}
return ans;
}
/**
 * Somewhat "technical" and not so efficient - yet totally acceptable for an exam
 * @param s
 * @return
 */
public static String sort3(String s) {
String ans = s;
if(s!=null && s.length()>1) {
	for(int i=0;i<s.length();i=i+1) {
		for(int j=0;j<s.length()-1;j=j+1) {
			if(ans.charAt(j)>ans.charAt(j+1)) {
				ans=ans.substring(0, j)+ans.charAt(j+1)+ans.charAt(j)+ans.substring(j+2, s.length());
						
			}
		}
	}
	
}
return ans;
}
	/////////// Q4 ////////////
/** 
 * This function recieves an array of GeoShape and return a new (deep copy semantics) GeoShape arry with only the shapes which passes the filter.
 * @param arr - array of GeoShape
 * @param pf0 - a Filter for GeoShape
 * @return
 */
	public static GeoShape[] ff(GeoShape[] arr, ShapeFilter pf0){
		int size = 0;
		for(int i=0;i<arr.length;i=i+1) {
			if(pf0.filter(arr[i])) {size=size+1;}}
		GeoShape[] ans = new GeoShape[size];
		size = 0;
		for(int i=0;i<arr.length;i=i+1) {
			if(pf0.filter(arr[i])) {ans[size]=arr[i].copy();size=size+1;}}
		return ans;
	}

}
