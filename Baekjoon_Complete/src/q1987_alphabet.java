import java.util.ArrayList;
import java.util.Scanner;

public class q1987_alphabet {
	static boolean done = false;
	static String[][] map;
	static ArrayList<String> al = new ArrayList<String>();
	static String ans = "";
	static int R, C;
	public static void main(String args[]) {

	
		Scanner sc = new Scanner(System.in);
		R  = Integer.parseInt(sc.next());
		C = Integer.parseInt(sc.next());
		map = new String[R+1][C+1];
		for (int i = 0 ; i < R ; i ++) {
			char[] a = sc.nextLine().toCharArray();
			for (int j = 0 ; j < a.length ; j++) {
				map[i][j] = String.valueOf(a[j]);
			}
		}
		
		dfs(0,0,"");
		
	}
	
	static void dfs(int x, int y, String a) {
		int[] dX = {1,0,-1,0};
		int[] dY = {0, 1,0,-1};
		
		for (int i = 0 ; i < dX.length; i++) {
				int mX = x + dX[i];
				int mY = y + dY[i];
				if (mX >=0 && mY >=0 && mX <= R && mY <= C) {
					if (check(mX,mY, a)) {
					dfs(mX, mY, a+map[mX][mY]);
					} 
				}
				
			}
		
	}
	
	static boolean check(int x, int y, String a) {
		if (a.contains(map[x][y])) {
			return false;
		}
		return true;
		
	}
}
