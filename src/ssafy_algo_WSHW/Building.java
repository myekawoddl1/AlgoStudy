package ssafy_algo_WSHW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Building {
    static int[] dx = {0, 0, 1, 1, -1, -1, 1, -1};
    static int[] dy = {1, -1, 1, -1, 1, -1, 0, 0};

    static int T, N, ans;
    static boolean[][] isPossible;

    // static int[][] buildings;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            isPossible = new boolean[N][N];
            // buildings = new int[N][N];

            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    if (st.nextToken().equals("B")) isPossible[i][j] = true;
                }
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!isPossible[i][j]) continue;

                    boolean flag = true;
                    for (int dir = 0; dir < 8; dir++) {
                        int ny = i + dy[dir];
                        int nx = j + dx[dir];
                        if (nx < 0 || nx >= N || ny < 0 || ny >= N) continue;
                        if (!isPossible[ny][nx]) {
                            flag = false;
                            break;
                        }
                    }
                    if (!flag) {
                        ans = ans < 2 ? 2 : ans;
                        continue;
                    }
                    if (flag) {
                        int count = 0;
                        for (int k = 0; k < N; k++) {
                            if (isPossible[i][k]) count++;
                            if (isPossible[k][j]) count++;
                        }
                        count--;
                        ans = ans < count ? count : ans;
                    }
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}