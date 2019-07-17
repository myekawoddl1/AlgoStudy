package ssafy_algo_WSHW;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class SaltWaterSum {
    static int T, N, C, ans;
    static boolean[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            map = new boolean[N][N];

            for(int i = 0; i < C; i++){
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                int dir = Integer.parseInt(st.nextToken());
                // dir = 상:1, 하:2, 좌:3, 우:4
                if(map[r][c]) continue;
                boolean live = true;
                switch (dir){
                    case 1:
                        for(int j = 3; j > 0; j--){
                            r -= j;
                            if(r < 0 || map[r][c]) {
                                live = false;
                                break;
                            }
                        }
                        if(live){
                            map[r][c] = true;
                            ans++;
                        }
                        break;
                    case 2:
                        for(int j = 3; j > 0; j--){
                            r += j;
                            if(r >= N || map[r][c]) {
                                live = false;
                                break;
                            }
                        }
                        if(live){
                            map[r][c] = true;
                            ans++;
                        }
                        break;
                    case 3:
                        for(int j = 3; j > 0; j--){
                            c -= j;
                            if(c < 0 || map[r][c]) {
                                live = false;
                                break;
                            }
                        }
                        if(live){
                            map[r][c] = true;
                            ans++;
                        }
                        break;
                    case 4:
                        for(int j = 3; j > 0; j--){
                            c += j;
                            if(c >= N || map[r][c]) {
                                live = false;
                                break;
                            }
                        }
                        if(live){
                            map[r][c] = true;
                            ans++;
                        }
                        break;
                }
            }
            System.out.println("#" + tc + " " + ans);
        }
    }
}
