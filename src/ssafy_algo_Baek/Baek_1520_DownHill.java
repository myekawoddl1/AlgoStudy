package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_1520_DownHill {
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static int M, N;
	static int map[][];
	static int dp[][];
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt."));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		dp = new int[M][N];

		for (int i = 0; i < M; i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		System.out.println(dfs(0, 0));
		
	}
	
	static int dfs(int y, int x) {
		if(y == M-1 && x == N-1) return 1;
		if(dp[y][x] != -1) return dp[y][x];
		
		dp[y][x] = 0;
		for(int i = 0; i < 4 ; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(0 <= nx && nx < N && 0 <= ny && ny < M) {
				if (map[ny][nx] < map[y][x]) {
					dp[y][x] += dfs(ny, nx);
				}
			}
			
		}
		return dp[y][x];
	}

}
