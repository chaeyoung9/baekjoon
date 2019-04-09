import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17070_pipe_transfer {
	static int map[][], count = 0, N;
	static int dx[] = {1,0,1};
	static int dy[] = {0,1,1};

    public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j =0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		search(0,1,1);
		System.out.println(count);
	}
	
	static void search(int x, int y, int d) {
		if (x == N-1 && y == N-1) {
			count++;
			return;
		}
		
		for (int i =0; i < 3; i++) {
			int mx = x + dx[i];
			int my = y + dy[i];
			if (mx < N && my < N && map[mx][my] == 0) {
				switch(i) {
					case 0: {
						if (d != 1) search(mx,my, 0);
						break;
					}
					case 1: {
						if (d != 0) search(mx,my, 1);
						break;
					}
					case 2: {
						if (x+1 < N && y+1 < N && map[x+1][y] == 0 && map[x][y+1] == 0) {
							search(mx,my,2);
						}
					}
				}
			}
		}
	}
}