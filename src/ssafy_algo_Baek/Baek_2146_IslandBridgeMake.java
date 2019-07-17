package ssafy_algo_Baek;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


class Island{
	int x, y, islandNum;
	Island(int x, int y, int islandnum){
		this.x = x;
		this.y = y;
		this.islandNum = islandnum;
	}
}


public class Baek_2146_IslandBridgeMake {
	static int dx[] = {1, -1, 0, 0};
	static int dy[] = {0, 0, 1, -1};
	static int N, islandnum, count;
	static int visited[][], map[][];
	static Queue<Island> que = new LinkedList<Island>();
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		map = new int[N][N];
		visited = new int[N][N];

		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
			}
		}


		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(visited[i][j] == 0 && map[i][j] == 1) {
					islandnum++;
					que.offer(new Island(j, i, islandnum));
					dfs(i,j);
				}
			}
		}
		
/*		System.out.println();
		// 섬 갯수 체크 후 섬 번호 확인
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(visited[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.println(que.size());*/
		int ans = 1000;
		int lenth = 0;
		while(!que.isEmpty()) {
			Island temp = que.poll();
			
			Queue<Island> que2 = new LinkedList<>(que);
			while(!que2.isEmpty()) {
				Island temp2 = que2.poll();
				
				if(temp.islandNum == temp2.islandNum) {
					continue;
				}
				
				lenth = Math.abs(temp2.y - temp.y) + Math.abs(temp2.x - temp.x) - 1;
				ans = Math.min(ans, lenth);
			}
		}
		System.out.println(ans);
	}

	static void dfs(int y, int x ) {		
		visited[y][x] = islandnum;
		for(int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];

			if(0 <= ny && ny < N && 0 <= nx && nx < N) {
				if(map[ny][nx] == 1 && visited[ny][nx] == 0) { 
					que.offer(new Island(nx, ny, islandnum));
					dfs(ny,nx);
				}
			}

		}
	}
}
