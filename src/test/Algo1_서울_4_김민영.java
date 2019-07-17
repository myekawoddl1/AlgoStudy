package test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Algo1_서울_4_김민영 {
	static class Coord{
		int y, x;

		public Coord(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}
		
	}
	static int T, N, ans;
	static char map[][];
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("input1.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Coord> Aque = new LinkedList<>();
		Queue<Coord> Bque = new LinkedList<>();
		Queue<Coord> Cque = new LinkedList<>();
		
		// A 상만가능
		// B 좌우로 가능
		// C 상하좌우 가능
		
		T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			ans = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new char[N][N];
			for(int i = 0; i < N ; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; j++) {
					map[i][j] = st.nextToken().charAt(0);
					if(map[i][j] == 'A') Aque.add(new Coord(i, j));
					if(map[i][j] == 'B') Bque.add(new Coord(i, j));
					if(map[i][j] == 'C') Cque.add(new Coord(i, j));
				}
			}
			
		/*	for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
			*/
			while(!Aque.isEmpty()) {
				Coord coord = Aque.poll();
				int y = coord.y;
				int x = coord.x;
				while(y > 0) { // 위로이동
					y = y - 1;
					if(map[y][x] != 'S') break;
					ans++;
				}
			}
			
			while(!Bque.isEmpty()) {
				Coord coord = Bque.poll();
				int y = coord.y;
				int x = coord.x;
				while(x > 0) { // 왼쪽으로 이동
					x = x - 1;
					if(map[y][x] != 'S') break;
					ans++;
				}
				x = coord.x;
				while(x < N - 1) { // 오른쪽으로 이동
					x = x + 1;
					if(map[y][x] != 'S') break;
					ans++;
				}
			}
			
			while(!Cque.isEmpty()) {
				Coord coord = Cque.poll();
				int y = coord.y;
				int x = coord.x;
				while(x > 0) { // 왼쪽으로 이동
					x = x - 1;
					if(map[y][x] != 'S') break;
					ans++;
				}
				x = coord.x;
				while(x < N - 1) { // 오른쪽으로 이동
					x = x + 1;
					if(map[y][x] != 'S') break;
					ans++;
				}
				x = coord.x;
				while(y > 0) { // 위로이동
					y = y - 1;
					if(map[y][x] != 'S') break;
					ans++;
				}
				
				y= coord.y;
				while(y < N -1) { // 위로이동
					y = y + 1;
					if(map[y][x] != 'S') break;
					ans++;
				}
			}
			
			
			
			System.out.println("#" + tc + " " + ans);
			
		}
	}

}
