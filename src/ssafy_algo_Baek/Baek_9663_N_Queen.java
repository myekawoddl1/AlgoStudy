package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_9663_N_Queen {
	static int N, count = 0;
	static int map[] = new int[16];
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= N; i++) {
	        map = new int[15];
	        map[1] = i;
	        // 정점은 행을 기준. (i = 1) => 1행(1열), (i = 2) => 2행(1열), (i = 3) => 3행(1열) 
	        dfs(1);
	    }
		System.out.println(count);
	}
	
	public static void dfs(int row) {
		if(row == N) {
			count++;
		} else{
			for (int i = 1; i <= N; i++) {
	            map[row + 1] = i;
	            if (isPossible(row + 1)) {
	                dfs(row + 1);
	            } else {
	                map[row + 1] = 0;    
	            }
	        }
		}
	}
	
	public static boolean isPossible(int c) {
		for (int i = 1; i < c; i++) {
			if(map[i] == map[c]) {
				return false;
			}
			if(Math.abs(map[i] - map[c]) == Math.abs(i - c)) {
				return false;
			}
		}
		return true;
	}
}
