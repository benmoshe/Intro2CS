package week4;

import java.util.ArrayList;
/**
 * This class solves the following question: given an ordered set of 5 rooms [1,2,3,4,5] in which
 * there is a "wolf" in one of the rooms. every "night" the wolf moves to a consecutive room - note that if
 * the wolf is in room #1 it must move to room#2 (same holds with room #5-->room #4) while in rooms #2-4
 * it has two options for each.
 * Your goat is to find a set on Minimal daily visited # of rooms so the  wolf will be found (in worst case).
 * Solution:
 * 1. let W be the set of all possible set of locations in k days [1,2,3,4,5,6] --> 5,8,14,24,42,72.
 * 2. let Op be the set of all possible options in k days --> 5^k.
 * 3. int i=1; found = false;
 * 4. while(!found) {
 * 4.1 construct W(i).
 * 4.2 construct Po(i).
 * 4.3 for each po in Po(i) {
 * 4.3.1 Test of po satifies all cases in Po(i) =- it would have found the wolf in Po(I):
 * 4.3.1.1 if so: found=true; return po (as a solution)
 * 4.4 i++
 * 
 * Do Not publish the following Human solution to the students (2,3,4,4,3,2): 
 * Note: as of symmetry there are 3 other such solution
 * 	
round	1	2	3	4	5	pos		possible	impossible
1			w				2		1,3,4,5		2
2		N		w			3		2,4,5		1,3
3			N		w		4		1,3,5		2,4
4		N		N	w	N	4		2			1,3,4,5
5			N	w	N	N	3		1			2,3,4,5
6		N	w	N	N	N	2		none		1,2,3,4,5
	
	
 * @author boaz.ben-moshe
 *
 */
public class Wolf_5_Solution{
	public static void main(String[] a) {
		int gen = 7;
		ArrayList<int[]> opt = new ArrayList<int[]>();
		int[][] all = {{1},{2},{3},{4},{5}};
	//	for(int i=0;i<all.length;i++) {;}
		boolean foundSolution = false;
		int len=1;
		opt.add(all[0]);
		while (!foundSolution) {
			
			opt = nextGen(opt);
			System.out.println();
			System.out.println("*** number of optins: "+opt.size()+"  for length "+(len+1)+" option");
			ArrayList<int[]> allPlays = new ArrayList<int[]>();
			for(int t=0;t<opt.size();t++) {
				int[] aa = opt.get(t);
				//for(int tt=0;tt<aa.length;tt++) {
				//	System.out.print(aa[tt]+",");
				//}
			//	allPlays.add(all[len]);
			//	System.out.println();
			}
			foundSolution = testSolution(allPlays, opt);
			System.out.println(foundSolution);

			//	System.out.println(allPlays.size());
			System.out.println();
			len=len+1;
		}
		// opt now has all the possible movement of the wolf.
		// testin all options:
//		int[] sol1 = {2,3,4,4,3,2};
//		int[] sol2 = {2,3,4,2,3,4};

	//	System.out.println(allPlays.size());
	}
	
	public static boolean test(int a[], int[] b) {
		boolean ans = false;
		int len = a.length;
		if(len == b.length) {
			for(int i=0;i<len;i++) {
				if(a[i] == b[i]) {ans = true;}
			}
		}
		return ans;
	}
	
	public static int[] up(int[] p) {
		int len = p.length;
		int[] ans = new int[len+1];
		for(int i=0;i<len;i++) {ans[i] = p[i];}
		int last = p[len-1];
		if(last==5) {ans = null;}
		else {ans[len] = last+1;}
		return ans;
	}
	
	public static int[] down(int[] p) {
		int len = p.length;
		int[] ans = new int[len+1];
		for(int i=0;i<len;i++) {ans[i] = p[i];}
		int last = p[len-1];
		if(last==1) {ans = null;}
		else {ans[len] = last-1;}
		return ans;
	}
	
	public static ArrayList<int[]> nextGen(ArrayList<int[]> last) {
		ArrayList<int[]> ans = new ArrayList<int[]>();
		for(int i=0;i<last.size();i++) {
			int[] l = last.get(i);
			int[] up = up(l); if(up!=null) {ans.add(up);}
			int[] down = down(l); if(down!=null) {ans.add(down);}
		}
		return ans;
	}
	
	public static ArrayList<int[]> allOption(ArrayList<int[]> last) {
		ArrayList<int[]> ans = new ArrayList<int[]>();
		for(int i=0;i<last.size();i++) {
			int[] l = last.get(i);
			for(int t=1;t<=5;t++) {
				int[] ll = add(l,t);
				ans.add(ll);
			}
		}
		return ans;
	}
	
	public static int[] add(int[] org, int v) {
		int len = org.length;
		int[] ans = new int[len+1];
		for(int i=0;i<len;i++) {ans[i] = org[i];}
		ans[len] = v;
		return ans;
	}
	
	public static boolean testSolution(ArrayList<int[]> allOpt, ArrayList<int[]> allMovements) {
		boolean ans = false;
		for(int i=0;i<allOpt.size();i++) {
			int[] sol = allOpt.get(i);
			boolean test = checkSol(allMovements, sol);
			if(test) {ans = true;
			System.out.println("found a solution:");
			for(int tt=0;tt<sol.length;tt++) {
				System.out.print(sol[tt]+",");
			}
			}
		}
		return ans;
	}
	
	private static boolean checkSol(ArrayList<int[]> allMovements, int[] sol) {
		int cc = 0;
		for(int t=0;t<allMovements.size();t++) {
			int[] aa = allMovements.get(t);
			boolean bool = test(aa,sol);
			if(bool) {cc++;}
		}
		return cc == allMovements.size();
	}
}
