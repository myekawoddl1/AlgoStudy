package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_1865_DongchulWorkDiv {
    static int T, N;
    static double ans;
    static double percent[][];
    static boolean visited[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++){
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            percent = new double[N][N];
            visited = new boolean[N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    percent[i][j] = Integer.parseInt(st.nextToken());
                    percent[i][j] =  percent[i][j] / 100;
                }
            }
            go(0, 100);

            System.out.println("#" + tc + " "+ String.format("%.6f", ans));
        }
    }

    private static void go(int cnt, double per) {
        if(cnt == N){
            if(per > ans)
                ans = per;
            return;
        }


        for(int i = 0; i < N; i++){
            if(visited[i] || percent[cnt][i] == 0) continue;
            if(ans < per * percent[cnt][i]) {
                visited[i] = true;
                go(cnt  + 1, per * percent[cnt][i]);
                visited[i] = false;
            }

        }

    }
}
