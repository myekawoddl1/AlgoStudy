package ssafy_algo_Baek;

import java.util.Scanner;

public class Baek_10872_Factorial {
	static int N;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int num = 1;
		for(int i = 2; i <= N; i++) {
			num *= i;
		}
		
		System.out.println(num);
	}

}
