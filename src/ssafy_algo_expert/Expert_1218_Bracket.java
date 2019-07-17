package ssafy_algo_expert;

import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

public class Expert_1218_Bracket {
	static Stack<Character> stack1; // ( )
	static Stack<Character> stack2; // [ ]
	static Stack<Character> stack3; // { }
	static Stack<Character> stack4; // < >

	static String bracket;
	static boolean flag;
	static int size;
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
//		System.out.println(sc.nextInt());
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			size = sc.nextInt();
			flag = false;
			bracket = sc.next();
			stack1 = new Stack<Character>();
			stack2 = new Stack<Character>();
			stack3 = new Stack<Character>();
			stack4 = new Stack<Character>();
			//System.out.println(bracket);
			for(int i = 0; i < size && !flag; i++) {
				char b = bracket.charAt(i);
				switch (b) {
				case '(':
					stack1.push(b);
					break;
				case ')':
					if(stack1.isEmpty()) {
						flag = true;
						break;
					}
					stack1.pop();
					break;
				case '[':
					stack2.push(b);
					break;
				case ']':
					if(stack2.isEmpty()) {
						flag = true;
						break;
					}
					stack2.pop();
					break;
				case '{':
					stack3.push(b);
					break;
				case '}':
					if(stack3.isEmpty()) {
						flag = true;
						break;
					}
					stack3.pop();
					break;
				case '<':
					stack4.push(b);
					break;
				case '>':
					if(stack4.isEmpty()) {
						flag = true;
						break;
					}
					stack4.pop();
					break;

				default:
					break;
				}
			}
			int result = 0;
			if(stack1.isEmpty() && stack2.isEmpty() && stack3.isEmpty() && stack4.isEmpty() && !flag) result = 1;
			System.out.println("#" + test_case + " " + result);
		}
	}
}