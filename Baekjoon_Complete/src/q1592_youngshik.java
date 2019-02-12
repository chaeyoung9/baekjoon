import java.util.Arrays;
import java.util.Scanner;

public class q1592_youngshik {
	
	static int[] map;
	static int N, M, L, count;
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		L = sc.nextInt();
		map = new int[N];
		count = 0;
		
		
		throwing(0);
		System.out.println(count);
	}
	
	
	static void throwing(int b) {
		if (++map[b] == M) return;
		
		int temp = map[b];
		if (temp%2 == 1) b += L;
		if (temp%2 == 0)b -=L;
		
		
		if (b < 0) 	b += N;
		if (b > (N-1)) b -=N;
		
		count++;
		throwing(b);
	}
}
