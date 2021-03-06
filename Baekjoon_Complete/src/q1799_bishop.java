import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q1799_bishop {
	static int map[][], N, max = 0, temp = 0;
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];
		
		for (int i = 0; i< N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ;j < N;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int wcount = 0;
		int bcount = 0;

		
		search(0, 0, 0);
		wcount = max;
		max = 0; temp = 0;
		
		search(0, 1, 1);
		bcount = max;
		
		int ans = wcount + bcount;
		System.out.println(ans);
		
	}
	
	
	static void search(int x, int y, int in) {
		max = Math.max(max, temp);
		if (y >= N) {
			x++; y = 0;
		}
		if (x >= N ) return;
		if ((x+y) %2 != in) {
			search(x, y+1, in);
			return;
		}
		
		if ((x+y)%2 == in && check(x,y, in) && map[x][y] == 1) {
			map[x][y] = 2;
			temp++;
			search(x,y+1, in);
			temp--;
			map[x][y] = 1;
		}
		search(x,y+1, in);
	}
	
	
	static boolean check(int x, int y, int num) {
		for (int i = 0; i < N; i++) {
			for (int j =0 ;j < N; j++) {
				if ((i+j)%2 != num) continue;
				if ((i+j)%2 == num && map[i][j] == 2 && Math.abs(x-i) == Math.abs(y-j)) {
					return false;
				}
			}
		}
		return true;
	}
}
