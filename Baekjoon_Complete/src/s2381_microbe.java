import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class s2381_microbe {
	static Queue<microbe> m = new LinkedList<microbe>();
	static Queue<microbe> temp = new LinkedList<microbe>();
	static Queue<point> p = new LinkedList<point>();
	static int N, tot = 0, map[][], dir[][], max[][];
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int ans[] = new int[T];
		for (int i = 0 ; i < T; i++) {
			N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();

			
			//시간별
			for (int j = 0 ; j < K; j++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				int num = sc.nextInt();
				int direction = sc.nextInt();
				m.add(new microbe(x,y, num, direction));
			}
			
			for (int j = 0 ; j < M; j++) {
				map = new int[N][N];
				dir = new int[N][N];
				max = new int[N][N];
				
				tot = 0;
				int msize = m.size();
				for (int k = 0 ; k < msize; k++) {
					//움직임
					microbe mi = m.poll();
					move(mi.x, mi.y, mi.num, mi.dir);
				}
				
				int psize = p.size();
				
				for (int k = 0 ; k < psize; k++) {
					point P = p.poll();
					if (map[P.x][P.y] == 0) continue;
					m.add(new microbe(P.x, P.y, map[P.x][P.y], dir[P.x][P.y])); //이거순서대로 변경
					tot += map[P.x][P.y]; 
				}
			}
			m.clear();
			ans[i] = tot;
		}
		
		for (int i = 0 ; i < T; i++) {
			System.out.format("#%d %d\n", i+1, ans[i]);
		}
		
	}
	
	static void move(int x, int y, int num, int d) {
	
		int X = x;
		int Y = y;
		int N = num;
		int D = d;
		
		switch (D) { //1-상  2-하  3-좌  4-우
		case 1:
			if (deadline(x-1,y)) {
				N /=2;
				D = 2;
			}
			X--;
			break;
		case 2:
			if (deadline(x+1, y)) {
				N /=2;
				D =1;
			}
			X++;
			break;
			
		case 3:
			if (deadline(x,y-1)) {
				N /=2;
				D = 4;
			}
			Y--;
			break;
			
		case 4:
			if (deadline(x,y+1)) {
				N /=2;
				D =3;
			}
			Y++;
			break;
		}
		
		if (map[X][Y] == 0) {
			map[X][Y] = N;
			dir[X][Y] = D;
			max[X][Y] = N;
			p.add(new point(X,Y));
			return;
		}
		if (map[X][Y] != 0) {
			if (max[X][Y] < N) {
				dir[X][Y] = D;
				max[X][Y] = N;
			} 
			map[X][Y] += N;
			return;
		}
		
	}
	
	static boolean deadline(int x, int y) {
		if (x ==0 || y == 0 || x == (N-1) || y == (N-1)){
			return true;
		}
		return false;
	}
	
	static class microbe{
		int x;
		int y;
		int num;
		int dir;
			public microbe(int x, int y, int num, int dir) {
				this.x = x;
				this.y = y;
				this.num = num;
				this.dir = dir;
			}
	}
	
	static class point {
		int x;
		int y;
			public point(int x, int y) {
				this.x = x;
				this.y = y;
			}
	}
}