import java.util.Scanner;

public class q14888_operators {
	
	static int max = -1000000000, min = 1000000000;
	static int op[], N;
	
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		op = new int[N];
		
		for (int i =0 ;i < N; i++) 
			op[i] = sc.nextInt();
		
		int p = sc.nextInt();
		int s = sc.nextInt();
		int m = sc.nextInt();
		int d = sc.nextInt();
		
		search(1,op[0],p,s,m,d);
		
		System.out.format("%d\n%d", max,min);
	}
	
	static void search(int cnt, int tot, int plu, int minu, int mult, int div) {
		if (cnt == N) {
			max = Math.max(max, tot);
			min = Math.min(min, tot);
			return;
		} 
			if (plu > 0) search(cnt+1, tot+op[cnt], plu-1, minu,mult,div);
			if (minu > 0) search (cnt+1, tot-op[cnt],plu, minu-1, mult,div);
			if (mult > 0) search(cnt+1, tot*op[cnt], plu, minu,mult-1,div);
			if (div > 0) search(cnt+1, tot/op[cnt], plu, minu,mult,div-1);
		}
}
