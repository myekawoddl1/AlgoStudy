package ssafy_algo_Baek;

import java.util.Scanner;

public class Baek_2748_Fibonacci_2 {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int count = 0;
		long arr[] = new long[91];
		
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[N]);
	}
}
