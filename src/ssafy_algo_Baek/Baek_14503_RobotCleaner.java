package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_14503_RobotCleaner {
	static int dx[] = {-1, 0, 1, 0};
	static int dy[] = {0, -1, 0, 1};
	// 0북쪽 1동쪽 2남쪽 3서쪽 을 보고 있을때 왼쪽 확인
	// [0~3] ==> 서 북 동 남 로 이동
	
	static int back_dx[] = {0, -1, 0, 1};
	static int back_dy[] = {1, 0, -1, 0};
	// 0북쪽 1동쪽 2남쪽 3서쪽 을 보고 있을때 후진 확인
	// [0~3] ==> 남 서 북 동
	
	static int N, M, robot_x = 0, robot_y = 0, robot_dir, count, turnCount = 0;
	static int map[][]; // 0청소가능, 1벽, 2청소함
	static int turnDir[] = {3, 0, 1, 2}; // 서 북 동 남으로 회전
	boolean flag;
	/*
	 * 0북쪽 1동쪽 2남쪽 3서쪽
	 * 0 일경우 회전후 보는 방향은 3
	 * 청소 가능할 경우 한칸 이동 
	*/
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		
		st = new StringTokenizer(br.readLine());
		robot_y = Integer.parseInt(st.nextToken());
		robot_x = Integer.parseInt(st.nextToken());
		robot_dir = Integer.parseInt(st.nextToken());
		// 0북쪽 1동쪽 2남쪽 3서쪽 
		
		for (int i = 0; i < map.length; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < map[i].length; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		// 맵 구성 완료
		
		while(true) {
			if(map[robot_y][robot_x] == 0) { // 현재위치 청소 안했을때 청소 함
				map[robot_y][robot_x] = 2;
				count++;
			}
			
			if(turnCount == 4) {
				if(map[robot_y + back_dy[robot_dir]][robot_x + back_dx[robot_dir]] == 1) { // 후진 불가능
					break;
				}else {
					robot_y += back_dy[robot_dir];
					robot_x += back_dx[robot_dir];
					// 후진
					turnCount = 0;
				}
			}
			
			if(map[robot_y + dy[robot_dir]][robot_x + dx[robot_dir]] == 0) { //왼쪽이 청소 가능함
				robot_y += dy[robot_dir];
				robot_x += dx[robot_dir];
				// 이동
				robot_dir = turnDir[robot_dir]; // 방향전환
				turnCount = 0;
			}else { // 청소가 불가능 함
				robot_dir = turnDir[robot_dir]; // 방향전환			
				turnCount++;
			}
		}
		System.out.println(count);		
	}

}
