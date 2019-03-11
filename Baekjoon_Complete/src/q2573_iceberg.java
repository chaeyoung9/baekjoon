import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q2573_iceberg {
	
	static boolean[][] vis;
	static int N,M, map[][];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		vis = new boolean[N][M];
		
		for (int i = 0 ; i < N; i++) {
			String t[] = br.readLine().split(" ");
			for (int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(t[j]);
			}
		}

		int turn = 0;
		loop1:while (true) {	
			turn++;
			for (boolean a[] : vis) {
				Arrays.fill(a, false);
			}
			melt();
			int count =0;
			for (int i = 0 ; i < N; i++) {
				for (int j = 0 ; j < M; j++) {
					if (map[i][j] ==0) continue;
					if (vis[i][j] == false) {
						vis[i][j] = true;
						search(i,j);
						count++;
					}
				}
			}
			if (count == 0) {turn = 0; break loop1;}
			else if (count >=2) {break loop1;}	
		}
		System.out.println(turn);
		
		
		
	}
	
	static void search (int x, int y) {
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		
		for (int i = 0 ; i < 4; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx>=0 && my>=0 && mx < N && my< M && vis[mx][my] == false) {
				if (map[mx][my] != 0) {
					vis[mx][my] = true;
					search(mx,my);
				}
			}
		}
	}
	
	static void melt() {
		int map2[][] = new int[N][M];
		for (int i = 0 ; i < N; i++) {
			for (int j = 0 ; j < M; j++) {
				int count = 0;
				if (map[i][j]!=0) {
					if (i-1 >=0 && map[i-1][j] ==0) count++;
					if (i+1 < N && map[i+1][j] == 0)count++;
					if (j-1 >=0 && map[i][j-1] ==0) count++;
					if (j+1 < M && map[i][j+1] == 0) count++;
					
					map2[i][j] = map[i][j] - count;
					if (map2[i][j] < 0) map2[i][j] = 0;
				}
			}
		}
		map = map2;
	}
	
	static void print(int map[][]) {
		for (int i = 0 ; i < N; i++) {
			for (int j = 0 ; j < M; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println("");
		}
	}
}
