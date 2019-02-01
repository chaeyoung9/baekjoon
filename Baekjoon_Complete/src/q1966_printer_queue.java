import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class q1966_printer_queue {

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int testC = sc.nextInt();
		Queue<prior> q = new LinkedList<prior>();
		int ans[] = new int[testC];

		for (int i = 0 ; i < testC ; i++) {
			int total = sc.nextInt();
			int current = sc.nextInt();
			int l = 0;
			int p[] = new int[total];
			
			for (int j = 0 ; j < total ; j++) {
				int temp = sc.nextInt();
				q.add(new prior(l++, temp));
				p[j] = temp;
			}

			Arrays.sort(p);
			l = total-1;
			int count = 1;
			
			while(!q.isEmpty()) {
				prior pr = q.poll();
				if (p[l] != pr.priority) {
					q.add(new prior(pr.order, pr.priority));
				} else {
					if (current == pr.order) {
						ans[i] = count;
						q.clear();
					} else {
						count++; l--;
					}
				}
			}
		}
		
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
