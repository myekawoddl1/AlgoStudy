package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


public class Baek_1726_Robot {

	static int dx[] = {0, 1, -1, 0, 0};
	static int dy[] = {0, 0, 0, 1, -1};
	// [1~4] ==> 동 서 남 북 으로 이동
	static int map[][] = new int[101][101]; // 0빈칸, 1벽
	static boolean visit[][][] = new boolean[5][101][101];
	static Robot start, end;


	static int M, N, commandCount = 0, result = 10000, totalCount;
	static char turnDir[][] = {
			{0, 0, 0, 0, 0},
			{0, 0, 2, 1, 1}, // 동쪽을 보고있을때 동 서 남 북 회전 횟수
			{0, 2, 0, 1, 1}, // 서쪽을 보고있을때 동 서 남 북 회전 횟수
			{0, 1, 1, 0, 2}, // 남쪽을 보고있을때 동 서 남 북 회전 횟수
			{0, 1, 1, 2, 0}, // 북쪽을 보고있을때 동 서 남 북 회전 횟수
	}; 

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		for (int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 맵 구성 완료
		st = new StringTokenizer(br.readLine());
		start = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), commandCount);
		Queue<Robot> que = new LinkedList<>();
		que.offer(start);

		st = new StringTokenizer(br.readLine());
		end = new Robot(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), commandCount);
		//////////////////////////////////////////////

		while(!que.isEmpty()) {
			Robot robotInfo = que.poll();
			int d = robotInfo.dir;
			if(robotInfo.y == end.y && robotInfo.x == end.x) {
				totalCount = robotInfo.count + turnDir[d][end.dir];
				result = result < totalCount ? result : totalCount;
			}


			for(int i = 1; i <= 3; i++) {
				int pos_y = (dy[d] * i) + robotInfo.y;
				int pos_x = (dx[d] * i) + robotInfo.x;

				if(0 < pos_y && pos_y <= M && 0 < pos_x && pos_x <= N) {
					if(map[pos_y][pos_x] == 0) {
						if(!visit[d][pos_y][pos_x]) {
							visit[d][pos_y][pos_x] = true;
							que.offer(new Robot(pos_y, pos_x, d, robotInfo.count + 1));
						}
					}
					else break;
				}
				else break;
			}


			for (int i = 1; i <= 4; i++) {
				if(d==i)continue;
							
				int pos_y = dy[i] + robotInfo.y;
				int pos_x = dx[i] + robotInfo.x;
				int turnC = robotInfo.count + turnDir[robotInfo.dir][i];
				if(0 < pos_y && pos_y <= M && 0 < pos_x && pos_x <= N) {
					if(map[pos_y][pos_x] == 0) {
						if(!visit[i][robotInfo.y][robotInfo.x]) {
							visit[i][robotInfo.y][robotInfo.x] = true; 
							que.offer(new Robot(robotInfo.y, robotInfo.x, i, turnC));
						}
					}
				}
			}
		}
		System.out.println(result);		
	}
	
	public static class Robot{
		int y, x, dir, count;
		Robot(int y, int x, int dir, int count){
			this.y = y;
			this.x = x;
			this.dir = dir;
			this.count = count;
		}
	}
}