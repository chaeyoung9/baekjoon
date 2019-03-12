import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class q16235_tree {
	
	static int nut[][], map[][], N,M,K;
	static PriorityQueue<tree> pq = new PriorityQueue<tree>();
	static Queue<tree> temp = new LinkedList<tree>();
	static Queue<tree> dead = new LinkedList<tree>();
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		nut = new int[N+1][N+1];
		map = new int[N+1][N+1];
		
		for (int a[] : nut) {
			Arrays.fill(a, 5);
		}
		
		for (int i = 1 ; i < N+1; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j<N+1; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());;
			}
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int X = Integer.parseInt(st.nextToken());
			int Y = Integer.parseInt(st.nextToken());
			int Age = Integer.parseInt(st.nextToken());
			pq.add(new tree(X,Y,Age));
		}
		
		for (int i = 0 ; i < K; i++) {
			spring();
			summer();
			autumn();
			winter();
		}
		
		System.out.println(pq.size());
		
		
		
	}
	
	static void spring() {
		while(!pq.isEmpty()) {
			tree T = pq.poll();
			if (T.age <= nut[T.x][T.y]) {
				nut[T.x][T.y] -= T.age;
				temp.add(new tree(T.x, T.y, T.age+1));
			} else {
				dead.add(new tree(T.x,T.y, T.age));
			}
		}
		bb();
	}
	
	static void summer() {
		while(!dead.isEmpty()) {
			tree T = dead.poll();
			nut[T.x][T.y] += T.age/2; 
		}
	}
	
	static void autumn() {
		int dx[] = {-1,-1,-1,0,0,1,1,1};
		int dy[] = {-1,0,1,-1,1,-1,0,1};
		while (!pq.isEmpty()) {
			tree T = pq.poll();
			temp.add(T);
			if (T.age % 5 == 0) {
				for (int i = 0; i < 8 ; i++) {
					int X = T.x + dx[i];
					int Y = T.y + dy[i];
					if (X > 0 && Y > 0 && X <= N && Y <= N) {
						temp.add(new tree(X,Y,1));
					}
				}
			}
		}
		bb();
	}
	
	static void winter() {
		for (int i = 1; i <= N; i ++) {
			for (int j = 1 ; j <=N ;j++) {
				nut[i][j] += map[i][j];
			}
		}
	}
	
	static void bb() {
		while(!temp.isEmpty()) {
			tree T = temp.poll();
			pq.add(T);
		}
	}
	
	static class tree implements Comparable<tree> {
		int x;
		int y;
		int age;
			public tree(int x, int y, int age) {
				this.x = x;
				this.y = y;
				this.age = age;
			}
			
			@Override
			public int compareTo(tree T) {
				return this.age <= T.age ? -1: 1;
			}
	}
}
