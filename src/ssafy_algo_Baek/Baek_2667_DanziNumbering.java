package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;



class Danzi{
	int x,y,danziNum;

	public Danzi(int x, int y, int danziNum) {
		super();
		this.x = x;
		this.y = y;
		this.danziNum = danziNum;
	}
	
	
}


public class Baek_2667_DanziNumbering {
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	
	static int N, danziNum;
	static int map[][];
	static int visited[][];
	
	static Queue<Danzi> que = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb;//  = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String a = st.nextToken();
			for(int j = 0; j < N; j++) {
				map[i][j] = a.charAt(j) - '0';
			}
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0 && map[i][j] == 1) {
					danziNum++;
					que.offer(new Danzi(j, i, danziNum));
					dfs(j, i);
				}
				
			}
		}
		int[] arr = new int [danziNum];
		for(int i = 1; i <= danziNum; i++) {
			while(!que.isEmpty() && que.peek().danziNum == i) {
				arr[i-1]++;
				que.poll();
			}
		}
		System.out.println(danziNum);
		Arrays.sort(arr);
		for(int i = 1; i <= danziNum; i++) {
			System.out.println(arr[i-1]);
		}
		
	}
	static void dfs(int x, int y ) {
		visited[y][x] = danziNum;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			
			if(0 <= ny && ny < N && 0 <= nx && nx < N) {
				if(map[ny][nx] == 1 && visited[ny][nx] == 0) { 
					que.offer(new Danzi(nx, ny, danziNum));
					dfs(nx,ny);
				}
			}
			
		}
	}
	
}
