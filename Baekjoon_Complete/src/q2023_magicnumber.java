import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class q2023_magicnumber {

	static int N;
	public static void main(String args[]) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.valueOf(br.readLine());
		br.close();
		int num[] = {2,3,5,7};
		for (int i = 0 ; i < 4;  i++) {
			String a = String.valueOf(num[i]);
			search(a);
		}
		
	}
	
	static void search(String sb) {
		if (sb.length() == N) {
			if (!prime(sb)) return;
			System.out.println(sb);
			return;
		} else {
			for (int i = 0 ; i < 10; i++) {
				StringBuilder s = new StringBuilder(sb);
				s.append(i);
				if (prime(s.toString())) {
					search(s.toString());
				}
			}
		}
	}
	
	static boolean prime(String sb) {
		int a = Integer.parseInt(sb);
		int root = (int) Math.sqrt(a);
		for (int i = 2 ; i <= root ; i ++) {
			if (a % i == 0) {
				return false;
			}
		}
		return true;
	}
}
