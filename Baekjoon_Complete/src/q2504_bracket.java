import java.util.*;
import java.io.*;

public class q2504_bracket {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		char[] in = sc.next().toCharArray();
		Stack<String> st = new Stack<>();
		int ans = 0;
		try {
			for (int i = 0; i < in.length; i++) {
				switch(in[i]) {
				case '(' :st.push("(");
				break;
				
				case '[' :st.push("[");
				break;
				
				case ')' :{
					if (st.peek().equals("(")) {
						st.pop(); st.push("2");
					} else {
						int temp = 0;
						while (st.peek() !="(") {
							temp += Integer.parseInt(st.peek());
							st.pop();
						}
						st.pop();
						temp = temp * 2;
						st.push(Integer.toString(temp));
					}
				}
				break;
				
				case ']' : {
					if (st.peek().equals("[")) {
						st.pop();
						st.push("3");
					} else {
						int temp = 0;
						while (st.peek() != "[") {
							temp += Integer.parseInt(st.peek());
							st.pop();
						}
						st.pop();
						temp = temp * 3;
						st.push(Integer.toString(temp));
					}
				}
				
				}
			}
			int temp = 0;
				while (!st.empty()) {
					temp += Integer.parseInt(st.pop());
				}
			ans = temp;
		} catch (Exception e) {
			ans = 0;
		}
		System.out.println(ans);
	}
}