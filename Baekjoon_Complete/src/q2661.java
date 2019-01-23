import java.util.Scanner;

public class q2661 {
	static int N;
	static boolean done = false;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		backtrack("");
	}
	
	static void backtrack(String i) {
		if (done) return;
		if (i.length() == N) {
			done = true;
			System.out.println(i);
			return;
		} else {		
			for (int k = 1 ; k <=3; k++) {
				if (check(i+ k)) {
					backtrack(i+k);
				}
			}
		}
	}
	 
	
	static boolean check(String b) {

		int count = 1;
		for (int i = 0; i < b.length() ; i++) {
			if (count > b.length()/2) break;
			for (int j = 0 ; j < b.length(); j++) {
				if (j+count+count <= b.length()) {
					String comp = b.substring(j, j+count);
					String comp2 = b.substring(j+count, j+count+count);
					if (comp.equals(comp2)) {
						return false;
					}
				}
			}
			count++;
		}
		return true;
	}
}