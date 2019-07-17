package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek_4863_IslandCount {
	static int dx[] = { 0,0,1,-1 , 1,-1,1,-1 };
	static int dy[] = { 1,-1,0,0 ,-1,1,1,-1 };
	static int w, h, islandCount;
	static int map[][];
	static boolean visited[][];
	
	public static void dfs(int y, int x) {
		visited[y][x] = true;
		for(int i = 0; i < 8; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0 <= ny && ny < h && 0 <= nx && nx < w) {
				if(!visited[ny][nx] && map[ny][nx] == 1) {
					dfs(ny, nx);
				}
			}
		}
	}
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st; // = new StringTokenizer(br.readLine());
		st = new StringTokenizer(br.readLine());
		
		while(true) {
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0) break;
			
			map = new int [h][w];
			visited = new boolean [h][w];
			
			for(int i = 0; i < h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < h; i++) {
				for(int j = 0; j < w; j++) {
					if(!visited[i][j] && map[i][j] == 1) {
						dfs(i, j);
						islandCount++;
					}
				}
			}
			System.out.println(islandCount);
			islandCount = 0;
			st = new StringTokenizer(br.readLine());
		}

	}

}
