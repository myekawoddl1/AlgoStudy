package ssafy_algo_expert;

import java.util.Scanner;
import java.util.Stack;
import java.io.FileInputStream;

/*
사용하는 클래스명이 Solution 이어야 하므로, 가급적 Solution.java 를 사용할 것을 권장합니다.
이러한 상황에서도 동일하게 java Solution 명령으로 프로그램을 수행해볼 수 있습니다.
 */
public class Expert_5432_IronRodCut {
	static Stack<Character> stack;
	static String bracket;
	static int ironRod;
	static boolean isClose;
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("input.txt"));
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			ironRod = 0;
			isClose = false;
			stack = new Stack<Character>();
			bracket = sc.next();
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
			System.out.println("#" + test_case + " " + ironRod);
		}
	}
}