import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;

public class q1339_word_mathematics  {
   public static void main(String args[]) throws NumberFormatException, IOException {
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      int N = Integer.parseInt(br.readLine());
      int all[] = new int[91];
      int cnt = 0;
      for (int i = 0; i < N; i++) {
         String a = br.readLine();
         int aLen = a.length();
            for (int j = 0; j < aLen; j++) {
               char c = a.charAt(j);
               if (all[c] == 0) {
                  cnt++;
               }
               all[c] += Math.pow(10, aLen-j-1);
          }
      }
      
      Arrays.sort(all);
      int sum = 0;
      int temp = 9;
      for (int i = 90; i > 90-cnt ; i-- ) {
    	  sum += all[i] * temp--;
      }
      System.out.println(sum);
   }
}