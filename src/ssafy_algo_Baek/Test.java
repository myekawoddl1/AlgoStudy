package ssafy_algo_Baek;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.StringTokenizer;


public class Test {

	static int[][] map = new int[101][101];
	static int[] dx = { 1, -1, 0, 0 }; // 동 서 남 북
	static int[] dy = { 0, 0, 1, -1 };
	static boolean[][][] c = new boolean[5][101][101];
	static Robot start, end;
	static int m, n;

	public static void main(String[] args){
		solve();
	}
	private static void solve() {
		Scanner sc = new Scanner(System.in);
		m = sc.nextInt();
		n = sc.nextInt();

		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
			}
		}

		int s = sc.nextInt();
		int e = sc.nextInt();
		int d = sc.nextInt();

		c[d][s][e] = true;
		start = new Robot(s, e, d, 0);
		end = new Robot(sc.nextInt(), sc.nextInt(), sc.nextInt(), 0);

		bfs();
	}

	public static void bfs() {
		Queue<Robot> q = new LinkedList<>();
		q.add(start);

		while (!q.isEmpty()) {
			Robot pos = q.poll();
			int d = pos.d;
			int cnt = pos.cnt;
			int y = pos.r;
			int x = pos.c;

			if (y == end.r && x == end.c && d == end.d) {
				System.out.println(cnt);
				return;
			}

			// 1, 2, 3 전진
			for (int i = 1; i <= 3; i++) {
				int nx = (dx[d - 1] * i) + x;
				int ny = (dy[d - 1] * i) + y;

				if (0 < nx && nx <= n && 0 < ny && ny <= m) {
					if (map[ny][nx] == 0) {
						if (!c[d][ny][nx]) {
							c[d][ny][nx] = true;
							q.add(new Robot(ny, nx, d, cnt + 1));
						}
					} else {
						break;
					}
				}
			}

			// 회전
			for (int i = 1; i <= 4; i++) {
				if (d != i && !c[i][y][x]) {
					int add = 1;
					if (d == 1) {
						if (i == 2) ++add;
					} else if (d == 2) {
						if (i == 1) ++add;
					} else if (d == 3) {
						if (i == 4) ++add;
					} else {
						if (i == 3) ++add;
					}
					c[i][y][x] = true;
					q.add(new Robot(y, x, i, cnt + add));
				}
			}
		}
	}

	public static class Robot {
		int r;
		int c;
		int d;
		int cnt;

		Robot(int r, int c, int d, int cnt) {
			this.r = r;
			this.c = c;
			this.d = d;
			this.cnt = cnt;
		}
	}
}