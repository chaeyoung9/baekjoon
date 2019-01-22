import java.util.*;

public class q1697_hide_n_seek {
	static int from, to;
	static int[] map;
	
	public static void main(String args[]) {
		
		Scanner sc = new Scanner(System.in);
		from = sc.nextInt();
		to = sc.nextInt();
		map = new int[100001];
		Arrays.fill(map, -1); //�湮 ���� ���� ���� -1 ����
		bfs();
		System.out.println(map[to]);
	}
	
	static void bfs() {
		Queue<Integer> q = new LinkedList<Integer>();
		int pos = from; // ������ ����
		map[pos] = 0; // ó�� ���� ������ 0���� ����
		q.add(pos);
		
		while (!q.isEmpty() && pos != to) { 
			pos = q.poll(); //q�� �ִ� �� �����鼭 �����ǰ� ����
			int[] a = {-1, 1, 2};
			
			for (int i = 0 ; i <3; i++) {
				int temp = 0;
				if (i != 2) {
					temp = pos + a[i];
				} else {
					temp = pos * 2;
				}
			
				//���� 0~100000�� �׸��� �湮���� ���� �����Ͻ�
				if (temp >= 0 && temp <= 100000 && map[temp] == -1) {
						q.add(temp); //while loop ���������� �ٽ� q�� �� ����
						map[temp] = map[pos] +1; //map[pos] ���� ���������Ƿ� 1 �߰�
				}
			}
		}
	}
}
