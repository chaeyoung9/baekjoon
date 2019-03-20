import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q15684_ladders {
   static int N,M,H,map[], ans = 99999;
   
   public static void main(String args[]) throws IOException {
	   BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	   StringTokenizer st = new StringTokenizer(br.readLine());
	   N = Integer.parseInt(st.nextToken()); //y
	   M = Integer.parseInt(st.nextToken());
	   H = Integer.parseInt(st.nextToken()); //x
	   map = new int[(H+1)*N+(N+1)];
	   
	   for (int i = 0; i < M; i++) {
		   st = new StringTokenizer(br.readLine());
		   int a = Integer.parseInt(st.nextToken());
		   int b = Integer.parseInt(st.nextToken());
		   map[a*N+b] = b+1;
	   }
	   
	   if(check()) {
		   System.out.println("0");
	   } else {
	   search(1,1,0);
	   if (ans == 99999) {
		   System.out.println("-1");
	   } else {
		   System.out.println(ans);
		   }
	   }
}
   
   static void print() {
	   System.out.println("_______________");
	   for (int i = 1 ; i <= H; i++) {
		   for (int j = 1 ; j <= N; j++) {
			   System.out.format("%d ", map[i*N+j]);
		   }
		   System.out.println("");
	   }
   }
   
   static void search(int x, int y, int ladders) {
	   //x->H y->N
	   if (ladders == 3) {
		   if (check()) {
		      ans = Math.min(ans, ladders);
		   }
		   return;
	   }
	   
	   if (check()) {
	         ans = Math.min(ans, ladders);
	         return;
	   }
	   
	      if (x < 1 || y < 1 || x > H || y > N-1) return;
	      if (map[x*N+y-1] ==0 && map[x*N+y+1] == 0 && map[x*N+y]==0) {
	        
	         map[x*N+y] = y+1;
	         if (y+1 < N) {
	            search(x, y+1, ladders+1);
	         } else if(y+1 >=N){
	            search(x+1,1, ladders+1);
	         }
	         map[x*N+y] = 0;
	      }
	      if (y+1 < N) {
	         search(x, y+1, ladders);
	      } else if (y+1 >= N) {
	         search(x+1,1, ladders);
	      }
   }
   
   static boolean check() {
	      for (int i =1; i < N; i++) {
	         int pos = i;
	         for (int j =1; j <=H; j++) {
	        	 if (map[j*N+pos] != 0 && map[j*N+pos-1] ==0) {
	        		 pos++;
	        	 } else if (map[j*N+pos-1] != 0 && map[j*N+pos] ==0) {
	        		 pos--;
	        	 }
	         }
	         if (pos !=i) return false;
	      }
	      return true;
	 }
   
}