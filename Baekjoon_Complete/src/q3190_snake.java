import java.util.*;


public class q3190_snake {
	//1-©Л 2-го 3-аб 4-╩С
	static int dx[] = {0,1,0,-1};
	static int dy[] = {1,0,-1,0};
	static boolean[][] chk;
	static int N,K,map[][], length = 1;
	static Deque<point> body = new ArrayDeque<point>(); 
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N+1][N+1];
		chk = new boolean[N+1][N+1];
		
		
		Queue<move> st = new LinkedList<move>();
		for (int i = 0 ; i < K; i++) {
			int X = sc.nextInt();
			int Y = sc.nextInt();
			map[X][Y] = 1;
		}
		
		int L = sc.nextInt();
		for (int i = 0 ; i < L; i++) {
			int aa = sc.nextInt();
			String bb = sc.next();
			st.add(new move(aa,bb));
		}
		
		int time = 0;
	
		int sx = 1; 
		int sy = 1;
		int sd = 0;
		
		body.add(new point(sx,sy));
		while(true) {
			if (!st.isEmpty() && st.peek().X == time) {
				if (st.peek().C.equals("D")) {
					if (sd+1 > 3) sd = 0;
					else sd++;
				} else {
					if (sd-1 < 0) sd = 3;
					else sd--;
				}
				st.poll();
			}
			
			int mx = sx + dx[sd];
			int my = sy + dy[sd];

			time++;
			if (mx <= 0 || my <=0 || mx >= N+1 || my >=N+1) { 
				System.out.println(time);
				break;
			}
			if (chk[mx][my] == true) {
				System.out.println(time);
				break;
			}
			
			if (map[mx][my] == 1) {
				if (body.size() == 1) {
					body.clear();
					body.add(new point(sx,sy));
					body.addFirst(new point(mx,my));
				} else {body.addFirst(new point(mx, my));}
				length++;
				map[mx][my] = 0;
			} else {
				body.pollLast();
				body.addFirst(new point(mx,my));
			}
			
			sx = mx;
			sy = my;
			
			fill(length);
		}
	}
	
	static void fill(int len) {
		for(boolean a[] : chk) {
			Arrays.fill(a, false);
		}
		for (int i = 0 ; i < len; i++) {
			point p = body.pollFirst();
			chk[p.x][p.y]= true; 
			body.addLast(p);
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
			public point(int x, int y) {
				this.x =x;
				this.y =y;
			}
	}	
}
