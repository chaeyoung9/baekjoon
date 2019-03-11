import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class q11559_puyopuyo{
	
	static boolean isChange = false;
	static int tot = 0;
	static String map[][];
	static boolean vis[][];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[12][6];
		vis = new boolean[12][6];
		
		for (int i = 0 ; i < 12; i++) {
			String[] input = br.readLine().split("");
			for (int j = 0 ; j < 6; j++) {
				map[i][j] = input[j];
			}
		}
		
			for (int i = 11; i >= 0; i--) {
				for (int j = 5; j >= 0; j--) {
					vis = new boolean[12][6];
					if (!(map[i][j].equals("."))) {
						Queue<point> q = new LinkedList<point>();
						q.add(new point(i,j));
						vis[i][j] = true;
						search(i,j, map[i][j], q);
						vis[i][j] = false;
						q.clear();
					}
					if (i ==0 && j == 0) {
						if (isChange == true) {//루프 풀리기전 만약 폭발이 있었을시 루프 리셋, 정리, 카운트+1
							i = 11; j= 5;
							tidy();
							tot++;
							isChange = false;
						}
					}
				}
			}
			System.out.println(tot);
	}
	
	
	static void tidy() {
		int k = 12; //더 세련되게 만들수 있지만 그냥 12번내림 
		while (k-- >0 ) {
			for (int i = 11 ; i >=0; i--) {
				for (int j = 5; j>= 0; j--) {
					if (map[i][j].equals(".")) {
						if (i > 0) {
						map[i][j] = map[i-1][j];
						map[i-1][j] = ".";
						}
					}
				}
			}
		}
	}
	
	static void search(int x, int y, String s, Queue<point> q) {
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		
		
		for (int i = 0 ; i < 4 ; i++) {
			int mx = x+dx[i];
			int my = y+dy[i];
			
			if (mx >=0 && my>=0 && mx < 12 && my < 6 && vis[mx][my] == false) {
				vis[mx][my] = true;
				if (map[mx][my].equals(s)) {
					q.add(new point(mx,my));
					search(mx,my, s, q);
				}
			}
		}
		
		if (q.size() >= 4) {
			isChange = true;
			while(!q.isEmpty()) {
				point p = q.poll();
				map[p.x][p.y]= "."; 
			}
			return;
		} else {
			return;
		}
		
	}
	
	static class point{
		int x, y;
			 public point(int x, int y) {
				 this.x =x;
				 this.y =y;
			 }
	}
	
}	
