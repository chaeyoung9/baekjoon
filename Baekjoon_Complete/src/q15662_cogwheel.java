import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;


public class q15662_cogwheel {
	static int[][] cog;
	static boolean[] visit;
	static Stack<listto> st = new Stack<listto>();
	
	public static void main(String args[]) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		cog = new int[T+1][8];
		visit = new boolean[T+1];
		
		for (int i = 1 ; i < T+1; i++) {
			
			String a = br.readLine();
			for (int j = 0 ; j < 8; j++) {
				cog[i][j] = Integer.parseInt(a.substring(j, j+1));
			}
		}
		
		int K = Integer.parseInt(br.readLine());
		int n[] = new int[K];
		int d[] = new int[K];

		for (int i = 0 ; i < K; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			n[i] = Integer.parseInt(st.nextToken());
			d[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0 ; i < K; i++) {
			visit[n[i]] = true;
			st.add(new listto(n[i], d[i]));
			check(d[i], n[i], T);
			visit = new boolean[T+1];
			
			while(!st.isEmpty()) {
				listto l = st.pop();
				rotate(l.dir, l.num);
			}
		}
		
		int ans = 0;
		for (int i = 1; i <= T; i++ ) {
			ans += cog[i][0];
		}
		System.out.println(ans);
	}
	
	
	static void check(int dir, int num, int max) {
		if (num <0 || num > max) return;
		
		if (num -1 > 0) {
			if (cog[num][6] != cog[num-1][2] && visit[num-1] == false) {
				visit[num-1] = true;
				st.push(new listto(num-1, -dir));
				if (num -1 != 1) {
					check(-dir, num-1, max);
				}
			}
		}
		
		if (num+1 < max +1) {
			if (cog[num][2] != cog[num+1][6] && visit[num +1] == false) {
				visit[num+1] = true;
				st.push(new listto(num+1, -dir));
				if (num+1 != max+1) {
					check(-dir, num+1, max);
				} 
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
	
	static class listto {
		int num;
		int dir;
			public listto(int num, int dir) {
				this.num = num;
				this.dir = dir;
			}
	}
}
