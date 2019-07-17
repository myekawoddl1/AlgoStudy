package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_7236_Jeosuji {
    static int[] dx = {0, 0, 1, 1, -1, -1, 1, -1};
    static int[] dy = {1, -1, 1, -1, 1, -1, 0, 0};

    static int T, N, ans;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new boolean[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j ++){
                    if(st.nextToken().equals("W")) map[i][j] = true;
                }
            }
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j ++){
                    if(!map[i][j])continue;
                    int count = 0;
                    for(int dir = 0; dir < 8; dir++){
                        int ny = i + dy[dir];
                        int nx = j + dx[dir];
                        if(nx < 0 || nx >= N || ny < 0 || ny >= N || !map[ny][nx]) continue;
                        count++;
                    }
                    ans = ans < count ? count : ans;
                }
            }

            if(ans == 0) ans = 1;
            System.out.println("#" + tc + " " + ans);
        }

    }
}
