import java.util.*;

public class q1697_hide_n_seek {
	static int from, to;
	static int[] map;
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		from = sc.nextInt();
		to = sc.nextInt();
		map = new int[100001];
		Arrays.fill(map, -1); //방문 하지 않은 값엔 -1 세팅
		bfs();
		System.out.println(map[to]);
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		int pos = from; // 포지션 세팅
		map[pos] = 0; // 처음 시작 지점을 0으로 세팅
		q.add(pos);
		
		while (!q.isEmpty() && pos != to) { 
			pos = q.poll(); //q에 있는 값 꺼내면서 포지션값 세팅
			int[] a = {-1, 1, 2};
			
			for (int i = 0 ; i <3; i++) {
				int temp = 0;
				if (i != 2) {
					temp = pos + a[i];
				} else {
					temp = pos * 2;
				}
			
				//값이 0~100000내 그리고 방문하지 않은 지점일시
				if (temp >= 0 && temp <= 100000 && map[temp] == -1) {
						q.add(temp); //while loop 돌리기위해 다시 q에 값 삽입
						map[temp] = map[pos] +1; //map[pos] 에서 움직였으므로 1 추가
				}
			}
		}
	}
}
