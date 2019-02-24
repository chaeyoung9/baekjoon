import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class q15662_cogwheel {
	static int[][] cog;
	static boolean[] visit;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		cog = new int[T+1][8];
		visit = new boolean[T+1];
		
		for (int i = 1 ; i < T+1; i++) {
			String a = sc.next();
			for (int j = 0 ; j < 8; j++) {
				cog[i][j] = Integer.parseInt(a.substring(j, j+1));
			}
		}
		
		int K = sc.nextInt();
		
		int n[] = new int[K];
		int d[] = new int[K];

		for (int i = 0 ; i < K; i++) {
			n[i] = sc.nextInt();
			d[i] = sc.nextInt();
		}
		
		printaa();
		for (int i = 0 ; i < K; i++) {
			visit[n[i]] = true;
			check(d[i], n[i], T);
			visit = new boolean[T+1];
			printaa();
		}
	}
	
	static void printaa() {
		for (int i = 1 ; i < 5; i++) {
			for (int j = 0 ; j < 8; j++) {
				System.out.print(cog[i][j] + " ");
			}
			System.out.println("");
		}
		System.out.println("_______________");
	}
	
	static void check(int dir, int num, int max) {
		if (num <0 || num > max) return;
		
		
		if (num -1 > 0) {
			if (cog[num][6] != cog[num-1][2] && visit[num-1] == false) {
				System.out.format("checking [%d][%d] %d = [%d][%d] %d\n", num,6, cog[num][6], num-1, 2, cog[num-1][2]);
				visit[num-1] = true;
				if (num -1 != 1) {
					check(-dir, num-1, max);
				} else if (num - 1 == 0) {
					rotate(-dir, num-1);
				}
				rotate(dir, num);
				return;
			}
		}
		
		if (num+1 < max+1) {
			if (cog[num][2] != cog[num+1][6] && visit[num +1] == false) {
				System.out.format("checking [%d][%d] %d = [%d][%d] %d\n", num,2, cog[num][2], num+1, 6, cog[num+1][6]);
				visit[num+1] = true;
				if (num+1 != max+1) {
					check(-dir, num+1, max);
				} else if (num+1 == max+1) {
					rotate(-dir, num+1);
				}
				rotate(dir, num);
				return;
			}
		}
		
		
	
	}
	
	static void rotate( int dir, int num) {
		switch(dir) {
		case -1:{
			int temp = cog[num][0];
			for (int i = 0 ; i < 7; i++) {
				cog[num][i] = cog[num][i+1];
			}
			cog[num][7] = temp;
		}
		break;
		
		case 1: {
			int temp = cog[num][7];
			for (int i = 7 ; i > 0; i--) {
				cog[num][i] = cog[num][i-1];
			}
			cog[num][0] = temp;
		}	
		}
		
	}
	
	
	
}
