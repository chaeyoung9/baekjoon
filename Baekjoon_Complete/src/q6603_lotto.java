import java.util.Scanner;

public class q6603_lotto {
	static int k ;
	static String ans ="";

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			k = sc.nextInt();
			int temp[] = new int[k];
			if (k == 0) {
				break;
			} 
			
			for (int i = 0 ; i < k; i++) {
					temp[i] = sc.nextInt();
				}
				search(0,0,temp, "");
				ans += "\n";
			}
		
		
		System.out.println(ans);
		
	}
	
	static void search(int len, int cnt,  int[] arr, String a) {
		if (len == 6) {
			ans += a + "\n";
			return;
		}
		if (cnt == k) return;
	
		search(len + 1 , cnt + 1, arr, a + arr[cnt]+ " ");
		search(len, cnt + 1, arr, a);
	}
}
