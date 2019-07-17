package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Baek_2458_HeightOrder {
    static int N, M, ans, INF = 999999999;
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
     /*   for(int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                map[i][j] = INF;
            }
        }*/
        for(int i = 1; i <= M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = 1;
            map[b][a] = -1;
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
            System.out.println();
            System.out.println();

        for(int k = 1; k <= N; k++){
            for(int i = 1; i <= N; i++){
                for(int j = 1; j <= N; j++){
                    if(i == j) continue;
                    if(map[i][k] == 1 && map[k][j] == 1)
                        map[i][j] = 1;
                    if(map[i][k] == -1 && map[k][j] == -1)
                        map[i][j] = -1;
                }
            }
        }

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        for (int j = 1; j <= N; j++) {
            int count = 0;
            for(int i = 1; i <= N; i++) {
                if(map[i][j] != 0) count++;
            }
            if(count == N - 1) ans++;
        }

        System.out.println(ans);
    }
}
