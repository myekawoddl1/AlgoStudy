package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_1874_StackSequence {
	static int N, index;
	static Stack<Integer> sequenceStack; // = new Stack<Integer>();
	static int[] sequenceArr;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		sequenceArr = new int[N];
		sequenceStack = new Stack<Integer>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			sequenceArr[i] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(sequenceArr));
		
		index = 0;
		
		for(int i = 1; i <= N; i++) {
			sequenceStack.push(i);
			sb.append("+\n");
			while(!sequenceStack.isEmpty() && sequenceArr[index] == sequenceStack.peek()) {
				index++;
				sequenceStack.pop();
				sb.append("-\n");
			}
		}
		if(sequenceStack.isEmpty()) {
			System.out.println(sb);
		}else {
			System.out.println("NO");
		}
		
		
	}
}
