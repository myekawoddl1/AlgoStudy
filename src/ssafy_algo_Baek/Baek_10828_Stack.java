package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_10828_Stack {
	static int N;
	static String command;
	static Stack<Integer> stack;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		stack = new Stack<Integer>();
		N = Integer.parseInt(st.nextToken());

		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			switch (command) {
			case "push":
				stack.push(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if(stack.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(stack.pop());
				}
				break;
			case "size":
				System.out.println(stack.size());
				break;
			case "empty":
				if(stack.isEmpty()) {
					System.out.println(1);
				}else {
					System.out.println(0);
				}
				break;
			case "top":
				if(stack.isEmpty()) {
					System.out.println(-1);
				}else {
					System.out.println(stack.peek());
				}
				break;

			default:
				break;
			}
		}
	}

}
