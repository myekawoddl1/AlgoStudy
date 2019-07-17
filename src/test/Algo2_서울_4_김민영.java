package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Algo2_서울_4_김민영 {
	static int T, W, N, ans;
	static int arr[];
	static int dp[];

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input2.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		T = Integer.parseInt(st.nextToken());

		for(int tc = 1; tc <= T; tc++) {
			ans = 99999;
			st = new StringTokenizer(br.readLine());
			W = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());

			arr = new int [N];
			dp = new int[W + 1];
			st = new StringTokenizer(br.readLine());

			for(int i = 0; i < N; i++) {
				arr[i] =  Integer.parseInt(st.nextToken());
			}

//			Arrays.sort(arr);

			//System.out.println(Arrays.toString(arr));

			for(int i = 1; i <= W; i++) {
				int min = 99999;
				for(int j = 0; j < N; j++){
					if(i >= arr[j] && dp[i - arr[j]] + 1 < min) min = dp[i - arr[j]] + 1;
				}
				dp[i] = min;
				System.out.println(Arrays.toString(dp));
			}

			ans = dp[W];
			System.out.println("#" + tc + " " + ans);

		}
	}

}
