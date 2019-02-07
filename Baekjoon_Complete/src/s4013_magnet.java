import java.io.*;
import java.util.*;

public class s4013_magnet {
	static int mag[][] = new int[4][8];
	public static void main(String args[]) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[] ans = new int[T];
		for (int i = 0 ; i < T ; i++) {
			int K = sc.nextInt();
			
			for (int j = 0 ; j< 4; j++) {
				for (int k = 0 ; k < 8 ; k++) {
					mag[j][k] = sc.nextInt();
				}
			}
			
			for (int j = 0 ; j < K; j++) {
				int M = sc.nextInt();
				int P = sc.nextInt();
				wheel(M-1,P);
			}
			ans[i] = score();
		}
		for (int i = 0 ; i < T; i++) {
			System.out.format("#%d %d\n", i+1, ans[i]);
		}
	}
	
	static int score () {
		int ans = 0;
		if (mag[0][0] == 1) {
			ans +=1;
		}
		if (mag[1][0] == 1) {
			ans +=2;
		}
		if (mag[2][0] == 1) {
			ans +=4;
		}
		if (mag[3][0] == 1) {
			ans += 8;
		}
		return ans;
	}
	
	
	static void wheel (int M, int P) {
		switch (M) {
		case 0: {
			if (mag[0][2] != mag[1][6]) {
				if (mag[1][2] != mag[2][6]) {
					if (mag[2][2] != mag[3][6]) {
						clock(3, -P);
					}
					clock(2, P);
				}
				clock(1,-P);
			}
			clock(0, P);
		}
		break;
		
		case 1: {
			if (mag[1][6] != mag[0][2]) {
				clock(0, -P);
			}
			if (mag[1][2] != mag[2][6]) {
				if (mag[2][2] != mag[3][6]) {
					clock(3, P);
				}
				clock(2, -P);
			}
			clock(1, P);
		}
		break;
		
		case 2: {
			if (mag[2][2] != mag[3][6]) {
				clock(3,-P);
			}
			if (mag[2][6] != mag[1][2]) {
				if (mag[1][6] != mag[0][2]) {
					clock(0, P);
				}
				clock(1, -P);
			}
			clock(2, P);
		}
		break;
		
		case 3: {
			if (mag[3][6] != mag[2][2]) {
				if (mag[2][6] != mag[1][2]) {
					if (mag[1][6] != mag[0][2]) {
						clock(0, -P);
					}
					clock(1, P);
				}
				clock(2, -P);
			}
			clock(3, P);
		}
		
		}
	}
	
	

	static void clock(int i, int path) {
		int temp = 0;
		switch (path) {
			case -1 :{
				temp = mag[i][0];
				for (int l = 0 ; l < 7; l++) {
					mag[i][l] = mag[i][l+1];
				}
				mag[i][7] = temp;
			}
			break;
			
			case 1 : {
				temp = mag[i][7];
				for (int l = 7 ; l > 0; l--) {
					mag[i][l] = mag[i][l-1];
				}
				mag[i][0] = temp;
			}
		}
	}
	
	
}
