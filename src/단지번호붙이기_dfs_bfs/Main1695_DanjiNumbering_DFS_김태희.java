package 단지번호붙이기_dfs_bfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

/*
7
0110100
0110101
1110101
0000111
0100000
0111110
0111000
*/

public class Main1695_DanjiNumbering_DFS_김태희 {

	static int[][] direction =  {{-1,0},{1,0},{0,-1},{0,1}};
	static int N;
	static int[][] map;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().trim());
		map = new int[N][N];

		for (int i = 0; i < N; i++) {
			char[] line = br.readLine().toCharArray();
			for (int j = 0; j < N; j++) {
				map[i][j] = line[j]-'0';
			}
		}

		// 시작점 찾기
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]==1) {
					cnt++;
					dfs(i,j,cnt+1);
				}
			}
		}
		int size[] = new int[cnt];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if(map[i][j]>1) {
					size[map[i][j]-2]++;
				}
			}
		}

		System.out.println(cnt);
		Arrays.sort(size);
		for(int i=0;i<cnt;++i) {
			System.out.println(size[i]);
		}

	}

	// 현 위치 주변 4방이 인접해 있으면 같은 단지 번호 매기기
	public static void dfs(int x,int y,int no){
		int newX=0, newY=0;
		map[x][y] = no;

		for(int d=0; d<direction.length; ++d) {
			newX = x + direction[d][0];
			newY = y + direction[d][1];
			if(newX>=0 && newX<N && newY>=0 && newY<N &&
					map[newX][newY] == 1) {
				dfs(newX, newY, no);
			}
		}

		return;

	}
}





































