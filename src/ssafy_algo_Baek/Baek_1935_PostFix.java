package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_1935_PostFix {
	static int N;
	static char charArr[];
	static String expression;
	static Stack<Double> stack = new Stack<Double>();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		charArr = st.nextToken().toCharArray();
		
		double[] array = new double[N];

		// System.out.println(Arrays.toString(charArr));
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			array[i] = Double.parseDouble(st.nextToken());
		}
		
		
		char temp;
		double val1, val2;
		for(int i = 0; i < charArr.length; i++) {
			temp = charArr[i];
			if(Character.isAlphabetic(temp)) {
				stack.push(array[temp - 'A']);
			}else {
				if(temp == '+') {
					val2 = stack.pop();
					val1 = stack.pop();
					stack.push(val1 + val2);
				}
				if(temp == '-') {
					val2 = stack.pop();
					val1 = stack.pop();
					stack.push(val1 - val2);
				}
				if(temp == '*') {
					val2 = stack.pop();
					val1 = stack.pop();
					stack.push(val1 * val2);
				}
				if(temp == '/') {
					val2 = stack.pop();
					val1 = stack.pop();
					stack.push(val1 / val2);
				}
			}
			
		}
		System.out.println(String.format("%.2f", stack.pop()));
	}

}
