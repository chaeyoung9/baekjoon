import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class q12100_2048 {
   
   static int map[][], N, max= 0;
   
   public static void main(String args[]) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      N = Integer.parseInt(br.readLine().trim());
      map = new int[N][N];
      
      
      for (int i =0; i <N ;i++) {
          StringTokenizer st = new StringTokenizer(br.readLine());
    	  for (int j =0; j < N; j++) {
            map[i][j] = Integer.parseInt(st.nextToken());
         }
      }

      move(0);
      System.out.println(max);
   }
   
   static void maxcheck() {
	   for (int i =0; i < N; i++) {
		   for (int j =0 ;j <N; j++) {
			   if (map[i][j] ==0 ) continue;
			   max = Math.max(max, map[i][j]);
		   }
	   }
   }
   
   static void move(int count) {
	  if (count == 5) {
		  maxcheck();
		  return;
	  }
      // 1-╩С  2-го  3-аб 4-©Л
	  for (int L = 1; L <= 4; L++) { 
		  int temp[][] = new int[N][N];
		  copy(temp,map);
	      tidy(L);
		  switch (L) {
	      case 1: {//╩С
	         for (int i =0; i < N; i++) {
	            for (int j = 0; j < N-1; j++) {
	            	if(map[j][i]== 0) {
	                    map[j][i] = map[j+1][i];
	                    map[j+1][i] = 0;
	                 } else if (map[j][i] == map[j+1][i]) {
	                    map[j][i] *= 2;
	                    map[j+1][i] =0;
	                    tidy(L);
	                 }
	            }
	           }
	         move(count+1);
	         copy(map,temp);
	      break;   
	      }
	      case 2: {//го
	    	  for (int i = N-1; i >= 0; i--) {
	              for (int j = N-1; j >= 0; j--) {
	            	if (j-1 < 0) continue;
	              	if(map[j][i]== 0) {
	                      map[j][i] = map[j-1][i];
	                      map[j-1][i] = 0;
	                   } else if (map[j][i] == map[j-1][i]) {
	                      map[j][i] *= 2;
	                      map[j-1][i] =0;
	                      tidy(L);
	                   }
	              	}
	             }
	    	  	move(count+1);
	         copy(map,temp);
	      break;
	      }
	      case 3: {//аб
	    	  for (int i =0; i < N; i++) {
	              for (int j = 0; j < N-1; j++) {
	              	if(map[i][j]== 0) {
	                      map[i][j] = map[i][j+1];
	                      map[i][j+1] = 0;
	                   } else if (map[i][j] == map[i][j+1]) {
	                      map[i][j] *= 2;
	                      map[i][j+1] = 0;
	                      tidy(L);
	                   }
	              }
	    	  }
	    	  move(count+1);
		         copy(map,temp);

		  break;
	      }
	      case 4: {//©Л
	         for (int i = N-1; i >= 0; i--) {
	            for (int j = N-1; j >= 0; j--) {
	            	if (j-1 < 0) continue;
	               if(map[i][j]== 0) {
	                  map[i][j] = map[i][j-1];
	                  map[i][j-1] = 0;
	               } else if (map[i][j] == map[i][j-1]) {
	                  map[i][j] *= 2;
	                  map[i][j-1] =0;
	                  tidy(L);
	               }
	         }
	         }
	         move(count+1);
	         copy(map,temp);

	      break;
	      }
	  }
   }
   }

   static void tool(int d) {
	   switch (d) {
	      case 1: {//╩С
	         for (int i =0; i < N; i++) {
	            for (int j = 0; j < N-1; j++) {
	            	if(map[j][i]== 0) {
	                    map[j][i] = map[j+1][i];
	                    map[j+1][i] = 0;
	                 } else if (map[j][i] == map[j+1][i]) {
	                    map[j][i] *= 2;
	                    map[j+1][i] =0;
	                 }
	            }
	           }
	      break;   
	      }
	      case 2: {//го
	    	  for (int i = N-1; i >= 0; i--) {
	              for (int j = N-1; j >= 0; j--) {
	            	if (j-1 < 0) continue;
	              	if(map[j][i]== 0) {
	                      map[j][i] = map[j-1][i];
	                      map[j-1][i] = 0;
	                   } else if (map[j][i] == map[j-1][i]) {
	                      map[j][i] *= 2;
	                      map[j-1][i] =0;
	                   }
	              	}
	             }
	      break;
	      }
	      case 3: {//аб
	    	  for (int i =0; i < N; i++) {
	              for (int j = 0; j < N-1; j++) {
	              	if(map[i][j]== 0) {
	                      map[i][j] = map[i][j+1];
	                      map[i][j+1] = 0;
	                   } else if (map[i][j] == map[i][j+1]) {
	                      map[i][j] *= 2;
	                      map[i][j+1] = 0;
	                   }
	              }
	    	  }
	    	  
		  break;
	      }
	      case 4: {//©Л
	         for (int i = N-1; i >= 0; i--) {
	            for (int j = N-1; j >= 0; j--) {
	            	if (j-1 < 0) continue;
	               if(map[i][j]== 0) {
	                  map[i][j] = map[i][j-1];
	                  map[i][j-1] = 0;
	               } else if (map[i][j] == map[i][j-1]) {
	                  map[i][j] *= 2;
	                  map[i][j-1] =0;
	               }
	         }
	         }

	      break;
	      }
	  }
   }
   
   static void copy(int map[][], int map2[][]) {
	   for (int i =0; i< N;i++) {
		   for (int j = 0; j <N; j++) {
			   map[i][j] = map2[i][j];
		   }
	   }
   }
   
   static void tidy(int d) {
	   switch (d) {
	      case 1: {//╩С
	    	  for (int i =0; i < N; i++) {
	    		  int set = -1;
	    		  for (int j =0; j < N; j++) {
	    			 if (set == -1 && map[j][i] ==0) {
	    				 set = j;
	    			 } else if (set != -1 && map[j][i] !=0) {
	    				 map[set][i] = map[j][i];
	    				 map[j][i] = 0;
	    				 j = set-1;
	    				 set = -1;
	    			 }
	    		  }
	    	  }
	      break;   
	      }
	      case 2: {//го
	    	  for (int i = N-1; i >= 0; i--) {
	    		  int set = -1;
	    		  for (int j = N-1; j >= 0; j--) {
	    			 if (set == -1 && map[j][i] ==0) {
	    				 set = j;
	    			 } else if (set != -1 && map[j][i] !=0) {
	    				 map[set][i] = map[j][i];
	    				 map[j][i] = 0;
	    				 j = set+1;
	    				 set = -1;
	    			 }
	    		  }
	    	  }
	      }
	      break;
	      case 3: { //аб
	    	  for (int i = 0; i < N ; i++) {
	    		  int set = -1;
	    		  for (int j = 0; j < N; j++) {
	    			 if (set == -1 && map[i][j] ==0) {
	    				 set = j;
	    			 } else if (set != -1 && map[i][j] !=0) {
	    				 map[i][set] = map[i][j];
	    				 map[i][j] = 0;
	    				 j = set -1;
	    				 set = -1;
	    			 }
	    		  }
	    	  }
	      }
	      break;
	      case 4: { //©Л
	    	  for (int i = N-1; i >= 0; i--) {
	    		  int set = -1;
	    		  for (int j = N-1; j >= 0; j--) {
	    			 if (set == -1 && map[i][j] ==0) {
	    				 set = j;
	    			 } else if (set != -1 && map[i][j] !=0) {
	    				 map[i][set] = map[i][j];
	    				 map[i][j] = 0;
	    				 j = set+1;
	    				 set = -1;
	    			 }
	    		  }
	    	  }
	      }
	      break;
	  }
   }
}