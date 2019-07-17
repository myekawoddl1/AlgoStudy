package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Baek_1725_Histogram {
	static int N, num, ans;
	static int arr[];
	static Stack<Integer> stack = new Stack<Integer>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		arr = new int[N + 2];
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			arr[i] = num;
		}

		stack.push(0);
		
		for(int i = 1; i <= N + 1; i++) {
			while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
				int height = arr[stack.peek()];
				stack.pop();
				int width = i - stack.peek() - 1;
				
				ans = Math.max(ans, height*width);
			}
			stack.push(i);
		}
		System.out.println(ans);
		//System.out.println(Arrays.toString(arr));
	}
}
