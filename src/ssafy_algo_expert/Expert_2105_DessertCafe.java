package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


@SuppressWarnings("Duplicates")
public class Expert_2105_DessertCafe {
    static int dx[] = {1, 1, -1, -1};
    static int dy[] = {1, -1, -1, 1}; // 우하 좌하 좌상 우상 으로 사각형 그림
    static int T, N, ans;
    static int map[][];
    static boolean dessert[];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++){
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            map = new int[N][N];
            visited = new boolean[N][N];
            dessert = new boolean[101];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    visited[i][j] = dessert[map[i][j]] = true;
                    dfs(i, j, 1, 0, i, j);
                    visited[i][j] = dessert[map[i][j]] = false;
                }
            }

            if(ans < 4) ans = -1;

            System.out.println("#" + tc + " " + ans);
        }
    }

    // 우하로 가거나 좌하로 갔을때 만들어지는 사각형은 똑같음.
    // 우상이나 좌상으로 갔을때는 이미 위쪽에서 만들어 졌기 때문에 볼 필요 없음.
    /*
        방문체크 미리 하는이유 : 범위 벗어났을 때 그냥 return 하기 때문에 return 할 때마다 다시 해제 해줘야함
        귀찮으니 방문체크 하고 들어갔다가 끝나면 체크 해제
    */
    private static void dfs(int curY, int curX, int cnt, int dir, int startY, int startX) {
        // visited[y][x] = dessert[map[y][x]] = true;
        if(dir == 4) return;

        int ny = curY + dy[dir];
        int nx = curX + dx[dir];
        if(nx < 0 || ny < 0 || nx >= N || ny >= N) return;

        if(dessert[map[ny][nx]]) {
            if(!visited[ny][nx]) return;
            if(nx == startX && ny == startY){
                ans = Math.max(ans, cnt);
            }
            return;
        }

        visited[ny][nx] = dessert[map[ny][nx]] = true;
        dfs(ny, nx, cnt + 1, dir, startY, startX); // 가던 방향으로 계속
        dfs(ny, nx, cnt + 1, dir + 1, startY, startX); // 여기서 회전
        visited[ny][nx] = dessert[map[ny][nx]] = false;
        // visited[y][x] = dessert[map[y][x]] = false;
    }
}
