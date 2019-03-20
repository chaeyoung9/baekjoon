	import java.io.BufferedReader;
	import java.io.IOException;
	import java.io.InputStreamReader;
	import java.util.LinkedList;
	import java.util.Queue;
	import java.util.StringTokenizer;
	
	
	public class q7569_tomato {
		
		static int M, N, H, map[][][], time = 0 ,zero = 0;
		static 	Queue<point> q = new LinkedList<point>();
		
		
		public static void main(String args[]) throws NumberFormatException, IOException {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			map= new int [H+1][N+1][M+1];
			
			for (int x = 1 ; x <=H ; x++) {
				for (int y =1 ; y <= N; y++) {
					st = new StringTokenizer(br.readLine());
					for (int z = 1; z <=M ; z++) {
						map[x][y][z] = Integer.parseInt(st.nextToken());
						if (map[x][y][z] == 1) q.add(new point(x,y,z)); //원래는 z y x가 맞는 표현이지만 편의상 x y z로 썼습니다
						if (map[x][y][z] == 0) zero++;
					}
				}
			}
			
			br.close();
			
			
			if (zero ==0) {
				System.out.println(time);
			} else {
				while(!q.isEmpty()) {
					if (zero == 0) break;
					int len = q.size();
					for (int i = 0; i < len; i++) {
						point p = q.poll();
						check(p);
					}
					time++;
				}
			
				if (zero == 0) 
					System.out.println(time);
				else 
					System.out.println("-1");
				
			}
}
		
		static void check(point p) {
			for (int i = 1 ; i <= 6; i++) {
				int x = p.x;
				int y=  p.y;
				int z = p.z;

				
				switch (i) {
					case 1:{x++; break;}
					case 2:{x--; break;}
					case 3:{y++; break;}
					case 4:{y--; break;}
					case 5:{z++; break;}
					case 6:{z--; break;}
				}

				if (x >= 1 && y>=1 && z>=1 && x <= H && y <=N && z <=M) {
					if (map[x][y][z] == 0) {
						map[x][y][z] = 1;
						q.add(new point(x,y,z));
						zero--;
					}
				}
			}
		}
		
		static class point{
			int x,y,z;
				public point(int x, int y, int z) {
					this.x =x;
					this.y =y;
					this.z =z;
				}
		}
	}
