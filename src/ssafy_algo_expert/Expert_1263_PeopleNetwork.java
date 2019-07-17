package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_1263_PeopleNetwork {
	static int N, tc, ans, INF = 999999;
	static int map[][];
	static int CC[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		tc = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int [N][N];
			CC = new int [N];
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
					if(i != j && map[i][j] == 0) map[i][j] = INF;
				}
			}

			/*	for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}*/
			for(int k = 0; k < N; k++) {
				for(int i = 0; i < N; i++) {
					if(i == k) continue;
					for(int j = 0; j < N; j++) {
						map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
					}
				}
			}
			ans = INF;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					CC[i] += map[i][j];
				}
				ans = Math.min(ans, CC[i]);
			}


			System.out.println("#" + t + " " + ans);
		}
	}
}
