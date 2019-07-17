package ssafy_algo_Baek;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Baek_2583_GetArea {
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	// [0~3] 동 서 남 북 순서대로
	static int map[][];
	static int square[][];
	static ArrayList<Integer> squareSize;// = new ArrayList<>();
	static boolean visited[][]; 
	static int M, N, K, count;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int [M + 2][N + 2];
		visited = new boolean [M + 2][N + 2];
		square = new int [K][4];
		squareSize = new ArrayList<>();
		// x1, y1, x2, y2
		
		for(int i = 0; i < K; i++) {
			for(int j = 0; j < 4; j++) {
				square[i][j] = sc.nextInt();
			}
		}
		
		for(int i = 0; i < K; i++) {
			for(int y = square[i][1]; y < square[i][3]; y++) {
				for(int x = square[i][0]; x < square[i][2]; x++) {
					map[y][x] = 1;
				}
			}
		}
		// map 구성 끝
/*		for(int i = 0; i < M; i ++) {
			for(int j = 0; j < N; j++) {
				System.out.print(map[i][j] + " ");
			}
			System.out.println();
		}*/
		// map 출력
		int ans = 0;
		for(int i = 0; i < M; i ++) {
			for(int j = 0; j < N; j++) {
				if(!visited[i][j] && map[i][j] == 0) {
					count = 0;
					ans++;
					dfs(i, j);
					squareSize.add(count);
					//System.out.println(count);
				}
			}
		}
		
		System.out.println(ans);
		Collections.sort(squareSize);
		for(int i = 0; i < squareSize.size(); i++) {
			System.out.print(squareSize.get(i) + " ");
		}
	}
	
	private static void dfs(int y, int x) {
		visited[y][x] = true;
		count++;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if(0 <= nx && nx < N && 0 <= ny && ny < M) {
				if(!visited[ny][nx] && map[ny][nx] == 0) {
					dfs(ny, nx);
				}
			}
		}
	}

}
