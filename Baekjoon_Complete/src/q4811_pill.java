import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class q4811_pill {
	
	static HashSet<String> hs = new HashSet<String>();
	static int tot = 0;
	static long[][] dp;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
//		while (true) {
			int N = sc.nextInt();
			dp = new long[N+1][N+1];
//			if (N == 0) break;
			
			System.out.println(pill(N,0));
			for (long a[] : dp) {
				System.out.println(Arrays.toString(a));
			}
//		}
		
	}
	
	static long pill(int W, int H) {
		if (W > 0 && dp[W][H] != 0) {
			return dp[W][H];
		}
		if (W == 0) {
			dp[W][H] = 1;
			return 1;
		} else {
			long sum = 0;
			sum += pill(W-1, H+1);
			if (H >= 1) 
				sum += pill(W, H-1);
			dp[W][H] = sum;
			return sum;
		}
	}
	
	
}
