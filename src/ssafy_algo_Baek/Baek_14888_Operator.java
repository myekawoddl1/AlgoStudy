package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_14888_Operator {
	static int N, maxVal = Integer.MIN_VALUE, minVal = Integer.MAX_VALUE;
	static int num[];
	static int operCount[] = {0, 0, 0, 0}; // 덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수 순서대로
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		num = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < num.length; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < 4; i++) {
			operCount[i] = Integer.parseInt(st.nextToken());
		}
		
		Queue<int[]> que = new LinkedList<int[]>();
		//Queue<Integer> posQue = new LinkedList<Integer>();
		
		que.offer(new int[] {operCount[0], operCount[1], operCount[2], operCount[3], num[0], 1});
		//덧셈(+)의 개수, 뺄셈(-)의 개수, 곱셈(×)의 개수, 나눗셈(÷)의 개수, 계산 값, 몇번째 숫자까지 계산
		
		while(!que.isEmpty()) {
			int val[] = que.poll();
			int pos = val[5];
			if(val[5] == N) {
				maxVal = maxVal < val[4] ? val[4] : maxVal ;
				minVal = minVal < val[4] ? minVal : val[4];
				continue;
			}
			
			if(val[0] - 1 >= 0) {
				que.offer(new int[] {val[0] - 1, val[1], val[2], val[3], val[4] + num[pos], pos + 1});
			}
			if(val[1] - 1 >= 0) {
				que.offer(new int[] {val[0], val[1] - 1, val[2], val[3], val[4] - num[pos], pos + 1});
			}
			if(val[2] - 1 >= 0) {
				que.offer(new int[] {val[0], val[1], val[2] - 1, val[3], val[4] * num[pos], pos + 1});
			}
			if(val[3] - 1 >= 0) {
				que.offer(new int[] {val[0], val[1], val[2], val[3] - 1, val[4] / num[pos], pos + 1});
			}
		}
		
		System.out.println(maxVal);
		System.out.println(minVal);
		//que.offer(e)
	}

}
