import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class q13458_examiner {
   
  
   
   public static void main(String args[]) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine().trim());
      Stack<Integer> st = new Stack<Integer>();
      StringTokenizer tok = new StringTokenizer(br.readLine());
      for (int i =0; i < N; i++) {
    	  st.add(Integer.parseInt(tok.nextToken()));
      }
      tok = new StringTokenizer(br.readLine());
      int B = Integer.parseInt(tok.nextToken());
      int C = Integer.parseInt(tok.nextToken());
      long count = 0;
      
      for (int i =0; i < N; i++) {
    	  int temp = st.pop();
    	  int rest = 0;
    	  //B 는 무조건 1명이므로
    	  temp -= B;
    	  count++;
    	  if (temp < 0) {
    		  temp += count;
    		  continue;
    	  }
    	  int divided = temp/C;
    	  int remainder = temp % C;
    	  
    	  if (temp == 0) continue;
    	  if (divided == 0 && remainder > 0) {
    		  rest++;
    	  } else if (divided > 0 && remainder > 0) {
    		  rest++;
    	  }
    	  
    	  count += divided+rest;
      }
      
      System.out.println(count);
      
   }
}