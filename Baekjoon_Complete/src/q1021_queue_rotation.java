import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class q1021_queue_rotation {

	static LinkedList<Integer> ls = new LinkedList<Integer>();
	
	public static void main(String args[]) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		for (int i = 1; i <= N; i++) 
			ls.add(i);
		
		int turn = 0;
		st = new StringTokenizer(br.readLine());
		for (int i = 0 ;i < M; i++) {
			int input = Integer.parseInt(st.nextToken());
				wloop: while (true) {
					int first = ls.peekFirst();
					if (input == first) {
						ls.poll();
						break wloop;
					}
					int last = ls.peekLast();
					int ord = ls.indexOf(input);
					if (ls.size()/2 >= ord) {
						ls.pollFirst();
						ls.offerLast(first);
					} else {
						ls.pollLast();
						ls.offerFirst(last);
					}
					turn++;
				}
		}
		
		System.out.println(turn);
		
	}
}
