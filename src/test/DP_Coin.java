package test;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 동전의 종류 1, 4, 6원
 * 거스름돈이 N원일 때 최소 몇개의 동전을 거슬러 주어야 하나
 */
public class DP_Coin {
	static int dp[];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		dp = new int [N + 1];
/*		
		for(int i = 1; i < 4; i++) {
			dp[i] = dp[i - 1] + 1; 
		}
		
		for(int i = 4; i < 6; i++) {
			dp[i] = Math.min(dp[i - 1] + 1, dp[i - 4] + 1); 
		}
		
		for(int i = 6; i <= N; i++) {
			int min = Math.min(dp[i - 1] + 1, dp[i - 4] + 1);
			dp[i] = Math.min(min, dp[i - 6] + 1);  
		}*/
		
		for(int i = 1; i <= N; i++) {
			int min = Integer.MAX_VALUE;
			if(i>=1 && dp[i - 1] + 1 < min) min = dp[i - 1] + 1;
			if(i>=4 && dp[i - 4] + 1 < min) min = dp[i - 4] + 1;
			if(i>=6 && dp[i - 6] + 1 < min) min = dp[i - 6] + 1;
			dp[i] = min;
			System.out.println(Arrays.toString(dp));
		}
		
		System.out.println(Arrays.toString(dp));
		System.out.println(dp[N]);
		sc.close();
	}
}