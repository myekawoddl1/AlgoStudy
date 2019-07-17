package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_9012_Bracket {
	static Stack<Character> stack;

	static String bracket;
	static char[] bracketArr;
	static boolean flag;
	static int T, size;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		T = Integer.parseInt(st.nextToken());

		for(int t = 0; t < T; t++) {
			st = new StringTokenizer(br.readLine());
			bracket = st.nextToken();
			bracketArr = bracket.toCharArray();
			stack = new Stack<Character>();
			flag = false;
			for(int i = 0; i < bracketArr.length && !flag; i++) {
				if(bracketArr[i] == '(') {
					stack.push(bracketArr[i]);
				}
				else {
					if(stack.isEmpty()) {
						flag = true;
						break;
					}
					stack.pop();
				}
			}
			System.out.println(!flag && stack.isEmpty()?"YES":"NO");
		}
	}

}
