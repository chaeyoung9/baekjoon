import java.util.Scanner;

public class q9663_n_queen {
	
	static int N, cnt;
	static int board[][];
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		
		
	}
	

	static boolean check(int x , int y) {
		if (board[x][y] == 1) { //x y 자리에 확인
			return false;
		}
		
		for (int i = 0 ; i < N ; i++) {
			if (board[i][y] ==1) {
				return false;
			}
		}
		
		
		return true;
	}
	
	static void queen(int x) {
		
	}
	
	
}

