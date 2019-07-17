package ssafy_algo_expert;

import java.util.Scanner;


public class Expert_1210_Sadali_Permutation {
	static int dx[] = {1, -1, 0};
	static int dy[] = {0, 0, -1};
	// [0 ~ 2] 동 서 북 북

	static int T, endy, endx, result;
	static int map[][] = new int[100][100];
	static boolean visited[][];// = new boolean[100][100];
	
	static boolean endCheck;
	public static void main(String[] args) {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			T = sc.nextInt();
			visited = new boolean[100][100];
			endCheck = false;
			result = 0;
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) {
						endy = i;
						endx = j;
					}
				}
			}
			
			solve(endy, endx);
			
			System.out.println("#" + t + " " + result);
		}


	}
	private static void solve(int endy, int endx) {
		if(endy == 0) {
			endCheck = true;
			result = endx;
			return;
		}
		if(endCheck) { 
			return;
		}
		visited[endy][endx] = true;
		// TODO Auto-generated method stub
		for(int i = 0; i < 3; i ++) {
			int ny = endy + dy[i];
			int nx = endx + dx[i];
			if(0 <= ny && ny < 100 && 0 <= nx && nx < 100) {
				if(!visited[ny][nx] && map[ny][nx] == 1 && !endCheck) {
					solve(ny,nx);
				}
			}
		}
	}

}

