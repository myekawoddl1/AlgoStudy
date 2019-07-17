package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_2512_Budget {
	static int N, M, budgetSum;
	static int budget[];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		budget = new int [N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			budgetSum += budget[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		M =Integer.parseInt(st.nextToken());
		Arrays.sort(budget);
		
		if(M >= budgetSum) {
			System.out.println(budget[N-1]);
			System.exit(0);
		}
		
		
	}

}
