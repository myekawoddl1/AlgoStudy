package ssafy_algo_expert;

import java.util.Scanner;
import java.util.Stack;

public class Expert_1224_Calculator3 {
	public static String toPostFix(String infix) {
		StringBuilder postfix = new StringBuilder();
		char[] chars = infix.toCharArray();
		Stack<Character> st = new Stack<Character>();
		final int SIZE = chars.length;

		char temp;
		for(int i = 0; i < SIZE; i++) {
			temp = chars[i];
			// Character.isDigit(temp)
			switch (temp) {
			case '0': case '1':	case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
				postfix.append(temp);
				break;
			case '+': case '-':
				if(!st.isEmpty()) {
					while(!st.isEmpty() && st.peek() != '(') {
						postfix.append(st.pop());
					}
				}
				st.push(temp);
				break;
			case '*': case '/':
				if(!st.isEmpty()) {
					while(!st.isEmpty() && st.peek() == '*' || st.peek() == '/') {
						postfix.append(st.pop());
					}
				}
				st.push(temp);
				break;
			case '(':
				st.push(temp);
				break;
			case ')':
				while(!st.isEmpty() && st.peek() != '(') {
					postfix.append(st.pop());
				}
				st.pop();
				break;
			default:
				break;
			}
		}
		while(!st.isEmpty()) {
			postfix.append(st.pop());
		}
		return postfix.toString();
	}

	public static int calculate(String postfix) {
		Stack<Integer> st = new Stack<Integer>();
		char[] chars = postfix.toCharArray();
		final int SIZE = chars.length;
		char temp;
		int val1, val2;
		for(int i = 0; i < SIZE; i++) {
			temp = chars[i];
			if(Character.isDigit(temp)) {
				/*double d = temp - '0';
				st.push(d);*/
				st.push(temp - '0');
			}else {
				if(temp == '+') {
					val2 = st.pop();
					val1 = st.pop();
					st.push(val1 + val2);
				}
				if(temp == '-') {
					val2 = st.pop();
					val1 = st.pop();
					st.push(val1 - val2);
				}
				if(temp == '*') {
					val2 = st.pop();
					val1 = st.pop();
					st.push(val1 * val2);
				}
				if(temp == '/') {
					val2 = st.pop();
					val1 = st.pop();
					st.push(val1 / val2);
				}
			}
		}

		return st.pop();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		for(int i = 1; i <= 10; i++) {
			sc.nextLine();
			String infix = sc.nextLine();
			System.out.println(toPostFix(infix));
			System.out.println("#" + i + " " + calculate(toPostFix(infix)));
		}
	}

}
