import java.util.*;

public class q2146_bridge {
	  
	   static int N, ans;
	   static int count = 0;
	   static int[][] map;
	   

	   static void DFS(int x, int y) {
	      int[] dx = {1, 0, -1, 0};
	      int[] dy = {0, 1, 0, -1};
	      
	      map[x][y] = count;
	      
	      for (int i = 0; i < 4; i++) {
	         int mx = x + dx[i];
	         int my = y + dy[i];
	         if(mx >= 0 && my >= 0 && mx <= N && my <= N && map[mx][my] == -1) {
	            map[mx][my] = count;
	            DFS(mx, my);
	         }
	      }
	   }
	   
	   
	   static void search(int x, int y, int current) {
		   for (int i = 0 ; i < N ; i++) {
			   for (int j = 0 ; j < N ; j++) {
				   if (map[i][j] != 0 && map[i][j] != map[x][y]) {
					   int a = Math.abs(i - x) + Math.abs(j - y) -1 ; //겹치는칸 하나 제거
					   ans = Math.min(ans, a);
				   }
			   }
		   }
	   }
	   
	   public static void main(String[] args) {
		      Scanner sc = new Scanner(System.in);
		      N = sc.nextInt();
		      map = new int[N+1][N+1];
		      ans = N*N;
		      
		      for (int i = 0; i < N; i++) { //값 입력 받기
		         for(int j = 0; j < N; j++) {
		            map[i][j] = sc.nextInt();
		            if(map[i][j] != 0) {
		               map[i][j] = -1;
		            }
		         }
		      }
		      
		      //-1로 변경 되었던것들을 순서대로 count 값으로 교체
		      for(int i = 0; i < N; i++) {
		         for(int j = 0; j < N; j++) {
		            if (map[i][j] == -1) { // -1 일시 
		               count++;
		               DFS(i, j);
		            }
		         }
		      }
		      
		      
		      for (int i = 0 ; i < N ; i++) {
		    	  for (int j = 0 ; j < N ; j++) {
		    		  if (map[i][j] != 0)
		    			  search(i,j, map[i][j]);
		    	  }
		      }
		      
		      System.out.println(ans);
		      
	   }
}

