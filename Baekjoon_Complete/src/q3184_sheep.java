import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q3184_sheep {
	
	static String map[][];
	static boolean vis[][];
	static int R,C, wolves, sheeps;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String st[] = br.readLine().split(" ");
		R = Integer.parseInt(st[0]);
		C = Integer.parseInt(st[1]);
		map = new String[R][C];
		vis = new boolean[R][C];
		wolves = 0;
		sheeps = 0;
		
		for (int i = 0 ; i < R; i++) {
			st = br.readLine().split("");
			for (int j = 0 ; j < C; j++) {
				map[i][j] = st[j];
			}
		}
		
		for (int i = 0 ; i < R; i++) {
			for (int j = 0 ; j < C; j++) {
				if (!(map[i][j].equals("#")) && vis[i][j] == false) {
					vis[i][j] = true;
					search(i,j);
				}
			}
		}
		System.out.format("%d %d", sheeps, wolves);
		
	}
	
	static void search(int x, int y) {
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		int W = 0;
		int S = 0;
		
		Queue<point> q = new LinkedList<point>();
		q.add(new point(x,y));
		
		while (!q.isEmpty()) {
			point p = q.poll();
			int X = p.x;
			int Y = p.y;
			
			if (map[X][Y].equals("v")) W++;
			if (map[X][Y].equals("o")) S++;
			
			for (int i = 0 ; i < 4;i++) {
				int mx = X+dx[i];
				int my = Y+dy[i];
				if (mx >=0 && my>=0 && mx < R && my<C && vis[mx][my] == false && !map[mx][my].equals("#")) {
					vis[mx][my] = true;
					q.add(new point(mx,my));
				}
			}
		}
		if (W < S) 	sheeps += S;
		else if (W>= S)	wolves +=W;
		
	}
	
	static class point {
		int x;
		int y;
			public point (int x, int y) {
				this.x =x;
				this.y =y;
			}
	}
	
}
