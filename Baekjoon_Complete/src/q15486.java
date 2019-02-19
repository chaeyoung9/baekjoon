import java.io.*;
import java.util.*;


public class q15486 {
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.valueOf(br.readLine());
		
		int T[] = new int[N+1];
		int P[] = new int[N+1];
		int dp[] = new int[N+50];
		
		for (int i = 0 ; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			T[i] = Integer.valueOf(st.nextToken());
			P[i] = Integer.valueOf(st.nextToken());
		}
		
		for (int i = 0 ; i < N; i++) {
			dp[i + T[i]] = Math.max(dp[i+T[i]], dp[i] + P[i]);
			dp[i + 1] = Math.max(dp[i+1], dp[i]);
		}
		
		System.out.println(dp[N]);
	}

}
