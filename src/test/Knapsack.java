package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
 *
4 10
10 5
40 4
30 6
50 3
 */
public class Knapsack {
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 아이템 수
		int W = Integer.parseInt(st.nextToken()); // 가방 무게
		int weights[] = new int [N + 1]; // 아이템 무게
		int profits[] = new int [N + 1]; // 아이템 가치
		int K[][] = new int [N + 1][W + 1];

		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			profits[i] = Integer.parseInt(st.nextToken());
			weights[i] = Integer.parseInt(st.nextToken());
		}

		for(int i = 1; i <= N; i++) { // 모든 아이템 시도
			for(int w = 1; w <= W; w++) {
				if(weights[i] <= w) { // 현 아이템 무게가 구하고자 하는 무게보다 같거나 작다면 가방에 담을 수 있다.
					K[i][w] = Math.max(K[i - 1][w - weights[i]] + profits[i], K[i - 1][w]);
				}else {
					K[i][w] = K[i - 1][w];
				}
			}
		}

		System.out.println(K[N][W]);
	}

}
