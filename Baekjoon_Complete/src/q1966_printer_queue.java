import java.util.*;

public class q1966_printer_queue {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testC = sc.nextInt();
		Queue<prior> q = new LinkedList<prior>();
		int ans[] = new int[testC];

		for (int i = 0 ; i < testC ; i++) {
			int total = sc.nextInt(); 
			int dest = sc.nextInt();
			int l = 0;
			int p[] = new int[total]; //priority값들을 담을 배열
			
			for (int j = 0 ; j < total ; j++) {
				int temp = sc.nextInt();
				q.add(new prior(l++, temp)); //queue 에 추가
				p[j] = temp; //priority 값에도 추가
			}

			Arrays.sort(p); // Sorting by ascending order
			l = total-1; // total-1 으로 하는이유는 p에서 priority가 높은값 부터 프린트해야하기 때문
			int count = 1; //프린트 카운트값
			
			while(!q.isEmpty()) {
				//꺼낸 큐의 우선순서와 제일 높은 우선순서 비교
				prior pr = q.poll();
				if (p[l] != pr.priority) { 
					q.add(new prior(pr.order, pr.priority)); //우선순위가 아닐시 큐에 다시추가해서 맨뒤로 보냄
				} else {
					if (dest == pr.order) {
						ans[i] = count;
						q.clear(); //값을 구했으므로 queue 클리어
					} else {
						count++; l--;
					}
				}
			}
			
			
		}
		
		//저장된 답 프린트
		for (int i = 0 ; i < ans.length; i++) {
			System.out.println(ans[i]);
		}
		
	}
	
	static class prior{
		int order;
		int priority;
		public prior(int order, int priority) {
			this.order = order;
			this.priority = priority;
		}
	}
}
