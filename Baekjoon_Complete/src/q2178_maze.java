import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q2178_maze {
	static int N, M;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.valueOf(st.nextToken());
		M = Integer.valueOf(st.nextToken());
		int[] map = new int[N*M];
		boolean[] visit = new boolean[N*M];

		
		for (int i = 0 ; i < N; i++) {
			String[] a = br.readLine().split("");
			for (int j = 0 ; j < M; j++) {
				map[i*M+j] = Integer.parseInt(a[j]);
			}
		}
		br.close();
		
		search(0,0, map,visit);
	}
	
	static void search(int x, int y, int[] map , boolean[] visit) {
		int dx[] = {0,1,0,-1};
		int dy[] = {1,0,-1,0};
		
		Queue<point> q = new LinkedList<point>();
		q.add(new point(x,y, 1));
		visit[x*M+y] = true;
		
		while(!q.isEmpty()) {
			point p = q.poll();
			int X = p.x;
			int Y = p.y;
			int c = p.count;
			
		
			for (int i = 0 ; i < 4 ;i++) {
				int nx = p.x + dx[i];
				int ny = p.y + dy[i];
				int num = nx*M + ny;
				if(nx >=0 && ny>=0 && nx < N && ny < M) {
					if (nx == N-1 && ny == M-1) {
						System.out.println(p.count+1);
						return;
					}
					if (map[num] == 1 && visit[num] == false) {
						visit[num] = true;
						q.add(new point(nx,ny, p.count + 1));
					}
				}
			}
			
		}
	}
	
	static class point{
		int x;
		int y;
		int count;
		public point(int x, int y, int count) {
			this.x = x;
			this.y = y;
			this.count = count;
		}
	}
}

