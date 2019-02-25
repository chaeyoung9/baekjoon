import java.util.*;

public class q4811_pill {
	
	static long[][] dp;
	static Queue<Long> q = new LinkedList<Long>();
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);

			while (true) {
				int N = sc.nextInt();
				if (N ==0) break;
				dp = new long[N+1][N+1];
				q.add(pill(N,0));
				dp = new long[N+1][N+1];
			}
			
			while(!q.isEmpty()) {
				System.out.println(q.poll());
			}
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
			if (H > 0) {
				sum += pill(W, H-1);
			}
			dp[W][H] = sum;
			return sum;
		}
	}
}
