package ssafy_algo_Baek;

import java.util.Scanner;

public class Baek_2747_Fibonacci {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int count = 0;
		int arr[] = new int[46];
		
		arr[0] = 0;
		arr[1] = 1;
		
		for(int i = 2; i <= N; i++) {
			arr[i] = arr[i-1] + arr[i-2];
		}
		System.out.println(arr[N]);
	}
}
