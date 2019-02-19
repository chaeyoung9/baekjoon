import java.util.Scanner;

public class q1002_turrent {
	public static void main(String args[]) {
	Scanner sc = new Scanner(System.in);
	int N = sc.nextInt();
	int x1, y1, r1, x2, y2, r2;
	int ans[] = new int[N];
	
	for (int l = 0 ; l < N; l++) {
			x1 = sc.nextInt();
			y1 = sc.nextInt();
			r1 = sc.nextInt();
			x2 = sc.nextInt();
			y2 = sc.nextInt();
			r2 = sc.nextInt();
			
			int dist = Math.abs(x1-x2) + Math.abs(y1-y2);
			
			int tot = Math.abs(r1+r2);
			int diff = Math.abs(r1-r2);
			Double d = (Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2)));
			
			if (x1 == x2 && y1 == y2) {
				if (r1 == r2) {
					ans[l] = -1;
				} else {
					ans[l] = 0;
				}
			} else if (d > diff && d < tot) {
				ans[l] = 2;
			} else if (d == diff || d == tot) {
				ans[l] = 1;
			} else if (d == 0 || d > tot && d < diff) {
				ans[l] = 0;
			}
	}
	
	for (int i = 0 ; i < ans.length; i++) {
		System.out.println(ans[i]);
	}
}

}