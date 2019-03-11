import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class q11048_moving {
	
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int map[][] = new int[N][M];
		int dp[][] = new int[N][M];
		
		int dx[] = {1,0,1};
		int dy[] = {0,1,1};
		
		for (int i = 0 ; i < N ; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0 ; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		br.close();
		
		dp[0][0] = map[0][0];
		for (int i = 0 ; i < N; i++) {
			for (int j = 0 ; j < M; j++) {
				for (int k = 0 ; k < 3 ;k ++) {
					int mx = i+dx[k];
					int my = j+dy[k];
					if (mx < N && my < M) {
						dp[mx][my] = Math.max(dp[mx][my],dp[i][j]+map[mx][my]); 
					}
				}
			}
		}
		System.out.println(dp[N-1][M-1]);
	}
}
