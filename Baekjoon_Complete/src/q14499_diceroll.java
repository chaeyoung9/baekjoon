import java.util.Scanner;

public class q14499_diceroll {
	static int x, y, N,M, map[][], dice[];
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		
		x = sc.nextInt();
		y = sc.nextInt();
		int K = sc.nextInt();
		
		map = new int[N][M];
		dice = new int[8];

		for (int i = 0 ; i < N; i++) {
			for (int j = 0 ; j < M; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		
		for (int i = 0 ; i < K ; i++) {
			int move = sc.nextInt();
			xymove(move);
		}
		
	}
	static void xymove(int dir) {
		switch(dir) {
		case 1:
			if (y+1 >= M) return;
				y++;
			break;
		case 2:
			if (y-1 < 0) return;
				y--;
			break;
		case 3:
			if (x-1 < 0) return;
				x--;
				break;
		case 4:
			if (x+1 >= N) return;
				x++;
				break;
		}
		moving(dir);
		swapper(x,y);
		System.out.println(dice[1]);
	
	}

	static void swapper(int x, int y) {
		if (map[x][y] == 0) {
			map[x][y] = dice[6];
		} else {
			dice[6] = map[x][y];
			map[x][y] = 0;
		}
	}
	
	static void moving(int dir) {
		int temp = dice[1];
		switch (dir) {
		case 1: 
			dice[1] = dice[4];
			dice[4] = dice[6];
			dice[6] = dice[3];
			dice[3] = temp;
			break;
		case 2:
			dice[1] = dice[3];
			dice[3] = dice[6];
			dice[6] = dice[4];
			dice[4] = temp;
			break;
		case 3:
			dice[1] = dice[5];
			dice[5] = dice[6];
			dice[6] = dice[2];
			dice[2] = temp;
			break;
		case 4:
			dice[1] = dice[2];
			dice[2] = dice[6];
			dice[6] = dice[5];
			dice[5] = temp;
			break;
		}
	}
}
