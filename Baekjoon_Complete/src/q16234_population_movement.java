import java.io.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class q16234_population_movement {
	
	static int N,L,R, tot, count, answer;
	static int[][] map;
	static boolean[][] visited = new boolean[101][101];
	static boolean repeat = true;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer s = new StringTokenizer(br.readLine());
		N = Integer.parseInt(s.nextToken());
		L = Integer.parseInt(s.nextToken());
		R = Integer.parseInt(s.nextToken());
		tot=0;
		count = 0;
		answer = 0;
		
		map = new int[N][N];
		
		for (int i = 0 ; i < N ; i++) {
			int l = 0;
			s = new StringTokenizer(br.readLine());
			while(s.hasMoreTokens()) {
				map[i][l++] = Integer.valueOf(s.nextToken());
			}
		}
		
		while(repeat == true) {
			repeat = false;
			for (int i = 0 ; i < N; i++) {
				for (int j = 0 ; j < N; j++) {
					if (visited[i][j] == false) {
						search(i,j);
					}
				}
			}
			if (repeat == true) 
				answer++;
			System.out.println("repeat : " + repeat);
			System.out.println(Arrays.deepToString(map));
			visited = new boolean[N][N];
		}
		System.out.println(answer);
	}
	
	static void search(int x, int y) {
		int[] dx = {1,0,-1,0};
		int[] dy = {0,1,0,-1};
	
		Stack<point> st = new Stack<point>();
		Queue<point> q = new LinkedList<point>();
		
		tot = map[x][y];
		count = 1;
		visited[x][y] = true;
		st.push(new point(x,y));
		q.add(new point(x,y));
		
		while (!q.isEmpty()) {
			point po = q.poll();
			for (int i = 0 ; i < 4; i++) {
				int mx = po.X + dx[i];
				int my = po.Y + dy[i];
				
				if (boundary(mx,my)) {
				int subt = Math.abs(map[po.X][po.Y] - map[mx][my]);
					if (subt >= L && subt <= R && visited[mx][my] == false) {
						visited[mx][my] = true;
						q.add(new point(mx,my));
						st.push(new point(mx,my));
						tot+=map[mx][my];
						count++;
					}
				}
			}
		}
		
		if(st.size() == 1) {
			point poi = st.pop();
			visited[poi.X][poi.Y] = false; 
		}
		if (st.size() > 1) {
			System.out.println("size : "+ st.size());
			while (!st.isEmpty()) {
				point p = st.pop();
				map[p.X][p.Y]= tot/count; 
			}
			repeat = true;
		}
	}
	
	
	static boolean boundary(int x, int y) {
		if (x>=0 && y >=0 && x < N && y < N) {
			return true;
		}
		return false;
	}
	
	static class point{
		int X;
		int Y;
			public point(int X, int Y) {
				this.X = X;
				this.Y = Y;
			}
	}
	
}
