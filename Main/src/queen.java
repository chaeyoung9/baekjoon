import java.util.Scanner;

public class Queen {

static int ans, N;
static int[] col;
 
	public static void search(int x) {
	    if (x == N) { //x 가 N과 같으면 끝까지 Queen을 배치한것
	        ans++;
	    } else {
	        for (int i = 1; i <= N; i++) {
	            col[x + 1] = i;
	            if (check(x + 1)) {
	                search(x + 1);
	            } else {
	                col[x + 1] = 0;    
	            }
	        }
	    }
	    col[x] = 0;
	}
	 
	public static boolean check(int x) {
	    for (int i = 1; i < x; i++) {
	        if (col[i] == col[x])  //같은줄인지 확인
	            return false;
	        
	        if (Math.abs(i - x) == Math.abs(col[i] - col[x])) //대각선 확인. 값 음수 방지하기위해 절대값으로
	            return false;
	    }
	    return true;
	}


	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
	    N = sc.nextInt();
	    col = new int[15];
	    
	    for (int i = 1; i <= N; i++) {
	        col[1] = i;
	        search(1);
	    }
	    System.out.println(ans);
	}
}
