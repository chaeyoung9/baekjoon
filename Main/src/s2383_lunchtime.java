import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Scanner;
import java.util.Stack;

public class s2383_lunchtime {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int N = sc.nextInt();
		int map[][] = new int[N][N];
		ArrayList<point> stair = new ArrayList<point>();
		Deque<pers> per = new ArrayDeque<pers>();
		
		
		for (int i = 0 ; i < N ; i++) {
			for (int j = 0 ; j < N ; j++) {
				map[i][j] = sc.nextInt();
				if (map[i][j] != 0 && map[i][j] != 1) {
					stair.add(new point(i,j));
				}
			}
		}
		
		for(int i = 0 ; i < stair.size(); i++) {
			System.out.format("stair : %d, %d\n", stair.get(i).x, stair.get(i).y);
		}
		
		
		for (int i = 0; i <N; i++) {
			for (int j = 0 ; j < N; j++) {
				if (map[i][j] == 1) {
					int c = 9999;
					int to = 0;
					for (int l = 0; l < stair.size(); l++) {
						int X = stair.get(l).x;
						int Y = stair.get(l).y;
						int a = Math.abs(i-X)+ Math.abs(j-Y);
//						System.out.format("direction: %d, %d -> %d, %d : %d\n", i,j,X,Y,a);
						if (a < c) {
							c = a;
							to = l;
						}
					}
					System.out.format("%d,%d -> %d,%d\n", i,j, stair.get(to).x, stair.get(to).y);
					per.push(new pers(i,j,stair.get(to).x, stair.get(to).y));
				}
			}
		}
		
//		System.out.println(stair.size());
//		System.out.println(per.size());
		while(!per.isEmpty()) {
			pers p = per.pollLast();
//			System.out.format("%d, %d -> %d, %d\n", p.x, p.y, p.tX, p.tY);
		}
		
		
	}
	
	static class pers{
		int x;
		int y;
		int tX;
		int tY;
			public pers(int x, int y, int tX, int tY) {
				this.x = x;
				this.y = y;
				this.tX = tX;
				this.tY = tY;
			}
	}
	
	
	static class point{
		int x;
		int y;
			public point(int x, int y) {
				this.x = x;
				this.y = y;
			}
	}
}
