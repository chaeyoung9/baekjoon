import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class q15685_dragon_curve {
	static int map[][] = new int[101][101];
	
	public static void main(String args[]) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N =Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int g = Integer.parseInt(st.nextToken());
            search(x,y,d,g);
		}
		
		System.out.println(count());
	}
	
	static void search(int x, int y, int d, int g) {
		Queue<Integer> q = new LinkedList<Integer>();
		LinkedList<Integer> temp = new LinkedList<Integer>();
		q.add(d);
        map[x][y] = 1;
		switch(d) {
			case 0: x++; break;
			case 1: y--; break;
			case 2: x--; break;
			case 3: y++; break;
		}	
		map[x][y] = 1;
		
		if (g != 0) {
			for (int i =0 ; i < g; i++) {
				for (int a : q) {
					temp.add(a);
				}
				
				while(!temp.isEmpty()) {
					int a = clock(temp.pollLast());
					switch(a) {
						case 0: x++; break;
						case 1: y--; break;
						case 2: x--; break;
						case 3: y++; break;
					}
					map[x][y] = 1;
					q.add(a);
				}
			}
		}
	}
	
	static int count(){
		int ans = 0;
		for (int i =0 ; i < 100; i++) {
			for (int j = 0 ; j < 100; j++) {
				if(map[i][j] == 1 && map[i+1][j] ==1 && map[i][j+1] == 1 && map[i+1][j+1] ==1) {
					ans++;
				}
			}
		}
		return ans;
	}
	
	
	static int clock(int d) {
		int dir = d;
		switch(dir) {
			case 0: dir = 1; break;
			case 1: dir = 2; break;
			case 2: dir = 3; break;
			case 3: dir = 0; break;
		}
		return dir;
	}	
}