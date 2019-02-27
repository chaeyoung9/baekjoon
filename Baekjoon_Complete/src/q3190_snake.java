import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;

public class q3190_snake {
	//1-©Л 2-го 3-аб 4-╩С
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int map[][] = new int[N][N];
		point snake = new point(0,0, 0);
		int apple = 0;
		
		Queue<move> st = new LinkedList<move>();
		for (int i = 0 ; i < K; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			map[X][Y] = 1;
			apple++;
		}
		
		int L = sc.nextInt();
		for (int i = 0 ; i < L; i++) {
			int aa = sc.nextInt();
			String bb = sc.next();
			st.add(new move(aa,bb));
		}
		
		int time = 0;
		
		while(true) {
			if (apple == 0) break;
			
			int d = snake.dir;
			
			if (st.peek().X == time) {
				time = 0;
				if (st.peek().C.equals("D")) {
					if (d-1 < 0) d = 3;
					else d--;
				} else {
					if (d+1 > 3) d = 0;
					else d++;
				}
			}
			
			int mx = snake.x + dx[d];
			int my = snake.y + dy[d];
			
			System.out.format("mx : %d my : %d time: %d \n", mx,my,time);
			if (mx < 0 && my <0 && mx >= N && my >=N) { 
				System.out.println("OUTOFRANGE");
				break;
			}
			if (map[mx][my] == 1) {
				System.out.println("ate apple");
			}
			
			snake.x = mx;
			snake.y = my;
			snake.dir = d;

			System.out.format("sx : %d sy : %d dir: %d \n", snake.x,snake.y, snake.dir);
			time++;
		}
		
	}
	
	static class move{
		int X;
		String C;
			public move(int X, String C) {
				this.X = X;
				this.C = C;
			}
	}
	
	static class point{
		int x;
		int y;
		int dir;
			public point(int x, int y, int dir) {
				this.x =x;
				this.y =y;
				this.dir = dir;
			}
	}
}
