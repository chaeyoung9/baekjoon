import java.util.*;

public class q1759_making_password {
	static int N , C;
	static String[] input;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = Integer.valueOf(sc.next());
		C = Integer.valueOf(sc.next());
		input = new String[C];
		
		for (int i = 0 ; i < C ; i++) {
			input[i] = sc.next();
		}
		
		Arrays.sort(input);
		search(0,0,0,"");
	}
	
	
	static void search(int index, int vowel, int consonant, String s) {
		if (s.length() == N) {
			if (vowel >=1 && consonant >= 2) {
				System.out.println(s);
			} 
			return;
		}
		if(index == C) {
			return;
		}
		if (check(input[index]).equals("v")) {
			search(index+1, vowel +1, consonant, s + input[index]);
		} else {
			search(index+1, vowel, consonant + 1, s + input[index]);
		}
		search(index+1, vowel, consonant, s);
	}
	
	static String check(String s) {
		if (s.equals("a") || s.equals("e") || s.equals("i") || s.equals("o") || s.equals("u") ) {
			return "v";
		} else {
			return "c";
		}
	}
	

	
}
