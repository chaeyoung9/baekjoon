import java.util.*;


public class q7562_knight {
	
	static int cases, side, sx, sy, fx, fy;
	static int[][] map;
	static int[] ans;
	
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		cases = sc.nextInt();
		ans = new int[cases];
		
		for (int i = 0 ; i < cases ; i++) {
			side = sc.nextInt();
			map = new int[side][side];
			
			sx = sc.nextInt();
			sy = sc.nextInt();
			fx = sc.nextInt();
			fy = sc.nextInt();
			
			bfs();
			ans[i] = map[fx][fy] -1; //시작지점을 1부터 시작했으므로 -1
		}
		
		for (int i = 0 ; i < cases; i++) {
			System.out.println(ans[i]);
		}
	}
	
	static void bfs() {
		int dx[]={-2,-1,1,2, 2, 1,-2,-1};
        int dy[]={ 1, 2,2,1,-1,-2,-1,-2};
        
		map[sx][sy] = 1;
		Queue<point> q = new LinkedList<point>();
		point p = new point(sx,sy);
		q.add(p);
		
		while(!q.isEmpty()) {
			p = q.poll();
			int X = p.x;
			int Y = p.y;
			if (X == fx && Y == fy) {
				break;
			}
			for (int i = 0 ; i<8 ;i++) {
				int tempx = X + dx[i];
				int tempy = Y + dy[i];
				if (tempx >= 0 && tempx<side && tempy >=0 && tempy <side && map[tempx][tempy] ==0) {
					map[tempx][tempy] = map[X][Y] + 1;
					p = new point(tempx, tempy);
					q.add(p);
				}
			}
		}
	}
	
	
	static class point{
		int x,y;
		public point(int i , int j) {
			this.x = i;
			this.y = j;
		}
	}
	
	
}