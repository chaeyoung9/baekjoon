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
			int p[] = new int[total]; //priority������ ���� �迭
			
			for (int j = 0 ; j < total ; j++) {
				int temp = sc.nextInt();
				q.add(new prior(l++, temp)); //queue �� �߰�
				p[j] = temp; //priority ������ �߰�
			}

			Arrays.sort(p); // Sorting by ascending order
			l = total-1; // total-1 ���� �ϴ������� p���� priority�� ������ ���� ����Ʈ�ؾ��ϱ� ����
			int count = 1; //����Ʈ ī��Ʈ��
			
			while(!q.isEmpty()) {
				//���� ť�� �켱������ ���� ���� �켱���� ��
				prior pr = q.poll();
				if (p[l] != pr.priority) { 
					q.add(new prior(pr.order, pr.priority)); //�켱������ �ƴҽ� ť�� �ٽ��߰��ؼ� �ǵڷ� ����
				} else {
					if (dest == pr.order) {
						ans[i] = count;
						q.clear(); //���� �������Ƿ� queue Ŭ����
					} else {
						count++; l--;
					}
				}
			}
			
			
		}
		
		//����� �� ����Ʈ
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
