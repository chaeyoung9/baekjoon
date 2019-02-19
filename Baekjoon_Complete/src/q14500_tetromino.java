import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class q14500_tetromino {
	static int N,M,max = 0;
	static int dx[] = {1,0,-1,0};
	static int dy[] = {0,1,0,-1};
	static int map[][];
	static boolean visit[][];
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		map = new int[N][M];
		visit = new boolean[N][M];
		
		for (int i = 0 ; i < N; i++) {
			int j = 0;
			st = new StringTokenizer (br.readLine());
			while (st.hasMoreTokens()) {
				map[i][j++] = Integer.valueOf(st.nextToken());
			}
		}
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < M; j++) {
				visit[i][j] = true;
				search(i,j,1, map[i][j]);
				shape(i,j, 1);
				shape(i,j, 2);
				shape(i,j, 3);
				shape(i,j, 4);
				visit[i][j] = false;
			}
		}
		
		System.out.println(max);
	}
	
	static void shape(int x, int y, int i) {
		int total = 0;
		switch (i) {
		case 1: //ㅗ 모양
			if (boundary(x-1,y) && boundary(x,y-1) && boundary(x,y+1)){
				total = map[x-1][y] +  map[x][y-1] + map[x][y+1];
				}
		break;
		
		case 2: //ㅓ 모양
			if (boundary(x-1,y) && boundary(x+1, y) && boundary(x, y-1)) 
			{total = map[x-1][y] + map[x+1][y] + map[x][y-1];
			}
		break;
		
		case 3: //ㅜ 모양
			if (boundary(x,y+1) && boundary(x+1, y) && boundary(x, y-1)) {
				total = map[x][y+1] + map[x+1][y] +  map[x][y-1];
			}
		break;
		
		case 4: //ㅏ 모양
			if (boundary(x-1,y) && boundary(x+1, y) && boundary(x, y+1)){
				total = map[x-1][y] + map[x+1][y] + map[x][y+1] ;
				}
		break;
		}
		max = Math.max(max, total+map[x][y]);	
	}
	
	static void search(int x, int y, int len, int tot) {
		if (len == 4) {
			max = Math.max(max, tot);
			return;
		}
		
		for (int i = 0 ; i < 4; i++) {
			int X = x + dx[i];
			int Y = y + dy[i];
			
			if (boundary(X,Y) && visit[X][Y] == false) {
				visit[X][Y] = true;
				search(X,Y, len+1, tot+map[X][Y]);
				visit[X][Y] = false;
			}
		}
	}
	
	static boolean boundary(int x, int y) {
		if (x >=0 && y>=0 && x<N && y < M ) {
			return true;
		}
		return false;
	}
}
