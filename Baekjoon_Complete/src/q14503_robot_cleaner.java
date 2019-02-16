import java.util.*;

public class q14503_robot_cleaner {
	
	static int map[][], N, M;
	static int dx[] = {0,-1,0,1};
	static int dy[] = {-1,0,1,0};
	static int clean = 0;
	
	public static void main(String args[]) {
//		0-ºÏ 1-µ¿ 2-³² 3-¼­
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		int x = sc.nextInt();
		int y = sc.nextInt();
		int d = sc.nextInt();
		
		map = new int[N][M];
		
		for (int i = 0 ; i < N; i++) {
			for (int j = 0 ; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		search(x,y, d, 0);
		System.out.println(clean);

	}
	
	static void printa(int[][] a) {
		for (int i = 0 ; i < N; i++) {
			for (int j = 0 ; j < M; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println("");
		}
	}
	
	static void search(int x, int y, int dir, int count) {
		if (map[x][y] == 0) {
		map[x][y] = 2;
		clean++;
		}
		
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if (!(nx >=0 && ny>=0 && nx < N && ny < M)) return;
		
		
		if (map[nx][ny] == 0) {
			search(nx,ny, turn(dir), 0);
		
		} else if (map[nx][ny] == 1 ||map[nx][ny] == 2) {
			if (count ==4) {
				mb(x,y,dir);
			} else if (count < 4) {
				search(x,y, turn(dir), count+1);
			}
		}
		
		
	}
	
	static void mb(int x, int y, int d) {
		int X = x + dx[turn(d)];
		int Y = y + dy[turn(d)];
		if (map[X][Y] == 1) {
			return;
		} else {
			search(X,Y, d, 0);
		}
	}
	
	
	static int turn(int d) {
		switch (d) {
		case 0 :
			return 3;
		case 1 : 
			return 0;
		case 2 : 
			return 1;
		case 3 : 
			return 2;
		}
		return 0;
	}

}
