package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert_6719_SungsuPG {
	static int tc, N, K;
	static double ans;
	static int arr[];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt."));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		tc = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= tc; i++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			arr = new int [N + 1];
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			for(int j = K - 1; j >= 0; j--) {
				ans = (ans + arr[N - j])/2;
			}
			
			
			System.out.println("#" + i + " " + ans);
		}
	}

}
