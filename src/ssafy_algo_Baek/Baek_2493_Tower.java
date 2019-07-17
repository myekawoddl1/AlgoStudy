package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_2493_Tower {
	static int T,  N = 0;
	static Stack<Integer> stack;// = new Stack<Integer>();
	static Stack<Integer> index;// = new Stack<Integer>();
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb;//  = new StringBuilder();
		T = Integer.parseInt(st.nextToken());


		for(int testCase = 1; testCase <= T; testCase++) {
			sb  = new StringBuilder();
			stack = new Stack<Integer>();
			index = new Stack<Integer>();
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());

			stack.push(Integer.parseInt(st.nextToken()));
			index.push(1);
			sb.append("0 ");
			for(int i = 2; i <= N; i++) {
				int num = Integer.parseInt(st.nextToken());

				while(!stack.isEmpty()) {
					if(num < stack.peek()) { // 새로 들어온 숫자가 현재 Top보다 작을 때
						sb.append(index.peek() + " ");
						break;
					}
					stack.pop();
					index.pop();
				}

				if(stack.isEmpty()) {
					sb.append("0 ");
				}

				stack.push(num);
				index.push(i);
			}

			System.out.println(sb);
		}

	}

}
