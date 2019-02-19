import java.util.Scanner;

public class q5622_dial {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int ans = 0;
		String input = sc.next();
		
		int[] num = {3,3,3,4,4,4,5,5,5,6,6,6,7,7,7,8,8,8,8,9,9,9,10,10,10,10};
		
		for (int i = 0 ; i < input.length(); i++) {
			char a = input.charAt(i);
			ans += num[a-'A'];
		}
		System.out.println(ans);
	}
}