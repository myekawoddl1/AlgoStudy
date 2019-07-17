package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JungOl_1733_5Mock {
    static int[] dx = {0, 1, 1, 1};
    static int[] dy = {1, 0, 1, -1};
    static int[][] map = new int[20][20];
    static int winner, ansR, ansC;
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        for (int i = 1; i < 20; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < 20; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for (int i = 1; i < 20 && !flag; i++) {
            for (int j = 1; j < 20 && !flag; j++) {
                if (i > 15 && j > 15) break;
                if (map[i][j] != 0) {
                    winner = go(i, j);
                    if (winner != 0) {
                        ansR = i;
                        ansC = j;
                    }
                }
            }
        }
        System.out.println(winner);
        if (flag)
            System.out.println((ansR) + " " + (ansC));
    }

    private static int go(int y, int x) {
        for (int i = 0; i < 4; i++) {
            int cnt = 0;
            for (int j = 1; j <= 5; j++) {
                int nx = x + dx[i] * j;
                int ny = y + dy[i] * j;
                if (nx < 0 || ny < 0 || nx >= 20 || ny >= 20 || map[ny][nx] != map[y][x]) break;
                cnt++;
            }
            if (cnt == 4) {
                if (map[y - dy[i]][x - dx[i]] != map[y][x]) {
                    flag = true;
                    return map[y][x];
                }
            }
        }
        return 0;
    }
}