import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q17136_coloured_paper {
	
	static int map[][], map2[][], blocks[], count = 0, min = 25;
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		map = new int [10][10];
		map2 = new int[10][10];
		blocks = new int[6];
		for (int i = 1 ; i < 6; i++) { //초기세팅
			blocks[i] = 5;
		}
	
		for (int i =0; i < 10; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0 ;j < 10; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if (temp == 1) count++;
			}
		} //여기까지가 입력칸
		
		if (count != 0) {
			search(0,0, map);
		
			if (min == 25) {
				System.out.println(-1);
			} else {
				System.out.println(min);
			}
		} else System.out.println(0);
	}

	static void search(int x, int y, int map[][]) {
		
		int temp[][] = new int[10][10];
		if (x >=10 || y>=10 || count == 0) {
			checker();
			return;
		}
		
		for (int i = x; i < 10; i++) {
			for (int j =y; j<10; j++) {
				if (map[i][j] == 1) {
					for (int l = 5; l > 0; l--) {
						if (countB() > min) return;
						if (isok(i,j,l, map)) {
						copydb(temp, map);
						blocks[l]--;
						int tempo = fill(i,j,l,map);
						
						count -= tempo;
						
						if (j+1 > 10 ) 
							search (x+1, 0, map);
						else 
							search(x, j, map);
						

						blocks[l]++;
						count += tempo;
						copydb(map,temp);
						}
					}
					if (map[i][j] == 1) return;
				}
			}
			y = 0;
		}
	}
	static boolean isok(int x, int y, int len, int map[][]) {
		if (blocks[len] <= 0 || x+len > 10 || y+len > 10) return false;
		for (int i = x; i < x+len; i++) {
			for (int j = y; j < y+len; j++) {
				if (map[i][j] != 1) {
					return false;
				}
			}
		}
		return true;
	}
	
	
	
	static int fill(int x, int y, int len, int map[][]) {
		int cnt = 0;
		int i =0, j = 0;
		
		for (i = x; i < x+len; i++) {
			for (j = y; j < y+len; j++) {
				if (map[i][j] == 1) {
					map[i][j] = 2;
					cnt++;
				}
			}
		}
		return cnt;
	}
	
	static void checker() {
		if (count == 0) {
			if (blocks[1] <0 || blocks[2] <0 || blocks[3] <0 || blocks[4] <0 || blocks[5] <0) return;
			min = Math.min(min, countB());
		}
	}
	
	static int countB() {
		int ans = 25 - (blocks[1] + blocks[2] + blocks[3] + blocks[4] + blocks[5]);
		return ans;
	}
	
	static void copydb(int[][] map, int[][] map2) {
		for (int i =0; i <10 ;i++) {
			for (int j =0;j <10; j++) {
				map[i][j] = map2[i][j];
			}
		}
	}
}