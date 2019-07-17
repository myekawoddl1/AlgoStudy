package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Back_10799_IronRod {
	static Stack<Character> stack;
	static String bracket;
	static int ironRod;
	static boolean isClose;
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ironRod = 0;
		isClose = false;
		stack = new Stack<Character>();
		bracket = st.nextToken();
		for(int i = 0; i < bracket.length(); i++) {
			char b = bracket.charAt(i);
			if(b == '(') {
				stack.push(b);
				isClose = false;
			}else {
				stack.pop();
				if(!isClose) { // 이 전에 닫는 괄호가 안나왔으므로 레이져
					ironRod += stack.size();
					isClose = true;
				}
				else {	// 이 전에 닫는 괄호가 나왔으므로 쇠막대 하나 끝
					ironRod++;
					isClose = false;
				}
				isClose = true;
			}
		}
		System.out.println(ironRod);
	}
}
