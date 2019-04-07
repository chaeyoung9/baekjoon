import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class q2210_number_jump {
	
	static HashSet<String> hs = new HashSet<String>();
	static String[][] map;
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		map = new String[5][5];
		for (int i=0; i < 5; i++) 
			map[i] = br.readLine().split(" ");
		
		for (int i =0; i < 5; i++) {
			for (int j =0; j < 5; j++) {
				search(i,j, map[i][j], 1);
			}
		}
		
		System.out.println(hs.size());
	}
	
	
	static void search(int x, int y, String a, int cnt) {
		if (cnt == 6) {
			hs.add(a);
			return;
		}
		
		int dx[] = {1,0,-1,0};
		int dy[] = {0,1,0,-1};
		
		for (int i =0; i <4; i++) {

			int mx = x + dx[i];
			int my = y + dy[i];
			
			if (mx >= 0 && my >= 0 && mx < 5 && my < 5) {
				StringBuilder sb = new StringBuilder(a);
				sb.append(map[mx][my]);
				search(mx,my,sb.toString(), cnt +1);
			}
		}
	}
}
