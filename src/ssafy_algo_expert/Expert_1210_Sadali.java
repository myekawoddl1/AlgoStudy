package ssafy_algo_expert;

import java.util.Scanner;

public class Expert_1210_Sadali {

	static int T, endy, endx;
	static int map[][] = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int t = 1; t <= 10; t++) {
			T = sc.nextInt();
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) {
						endy = i;
						endx = j;
					}
				}
			}
			//System.out.println("\n행 : " + endy + "\n열 : " + endx);
			while(endy > 0) {
				endy--;
				if(endx > 0 && map[endy][endx - 1] == 1) { // 서쪽
					endx--;
					while(endx > 0 && map[endy][endx - 1] == 1) {
						endx--;
					}
				}else if(endx < 99 && map[endy][endx + 1] == 1){ // 동쪽
					endx++;
					while(endx < 99 && map[endy][endx + 1] == 1) {
						endx++;
					}
				}
			}

			System.out.println("#" + t + " " + endx);
		}
	}
}



/*
 * import java.util.Scanner;

public class Expert_1210_Sadali {
	static int dx[] = {1, -1, 0};
	static int dy[] = {0, 0, -1};
	// [0 ~ 2] 동 서 북 북

	static int T, endy, endx;
	static int map[][] = new int[100][100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		for(int t = 1; t <= 10; t++) {
            T = sc.nextInt();
			for(int i = 0; i < 100; i++) {
				for(int j = 0; j < 100; j++) {
					map[i][j] = sc.nextInt();
					if(map[i][j] == 2) {
						endy = i;
						endx = j;
					}
				}
			}
//			System.out.println("\n행 : " + endy + "\n열 : " + endx);
			int dir = 2; // 0 1 2 동 서 북
			while(endy != 0) {
				int ny = 0;
				int nx = 0;

				if(dir == 2) { // 위쪽으로 가고 있을 때 좌우 보고 있으면 그쪽으로 이동
					for(int i = 0; i < 2; i++) {
						ny = endy + dy[i];
						nx = endx + dx[i];
						if(0 <= ny && ny < 100 && 0 <= nx && nx < 100) {
							if(map[ny][nx] == 1) {
								endy = ny;
								endx = nx;
								dir = i;
								break;
							}
						}
					}
					if(dir==2) endy--;
				}
				else if(dir == 0) { // 동쪽으로 가고 있을 때
					ny = endy + dy[0];
					nx = endx + dx[0];
					if(nx < 99) {
						if(map[ny][nx] == 0) {
							endy--;
							dir = 2;
						}else {
							endx++;
						}
					}else {
						endy--;
						dir = 2;
					}
				}
				else if(dir == 1) { // 서쪽으로 가고 있을 때
					ny = endy + dy[1];
					nx = endx + dx[1];
					if(nx > 0) {
						if(map[ny][nx] == 0) {
							endy--;
							dir = 2;
						}else {
							endx--;
						}
					}else {
						endy--;
						dir = 2;
					}
				}
//				System.out.println("\n행 : " + endy + "\n열 : " + endx + " 방향 : " + dir);
			}
//			System.out.println("\n행 : " + endy + "\n열 : " + endx + " 방향 : " + dir);


			System.out.println("#" + t + " " + endx);
		}


	}

}

 * */
