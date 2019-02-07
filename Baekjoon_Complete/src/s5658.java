import java.io.*;
import java.util.*;

public class s5658 {
	
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int cases = Integer.valueOf(br.readLine());
		int[] answer = new int[cases];
		
		
		for (int i = 0 ; i < cases ; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.valueOf(st.nextToken());
			int K = Integer.valueOf(st.nextToken()) -1;
			
			int side = N/4;
			
			String in = br.readLine();
			HashSet<Integer> hs = new HashSet<Integer>();

			
			for (int k = 0 ; k < side ; k++) {
				int temp = 0;
				while (temp != in.length()) {
					int a = Integer.valueOf(in.substring(temp, temp+side), 16);
					hs.add(a);
					temp += side;
				}
				in = rotate(in);
			}
			
			List<Integer> ls = new ArrayList(hs);
			Collections.sort(ls, Collections.reverseOrder());
			
			answer[i] = ls.get(K);
		}
		
		for (int i = 0 ; i < answer.length; i++) {
			System.out.format("#%d %d\n", i+1, answer[i]);
		}
		
		
	}
	
	static String rotate(String in) {
		StringBuilder sb = new StringBuilder();
		String temp = in.substring(in.length()-1, in.length());
		sb.append(temp).append(in.substring(0, in.length()-1));
		return sb.toString();
	}
	
}
