package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Baek_2001_GemPicking {
    static int N, M, K;
    static int gemExist[];
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N + 1][N + 1];
        gemExist = new int[N + 1];
        for(int k = 0 ; k < K; k++){
            st = new StringTokenizer(br.readLine());
            gemExist[Integer.parseInt(st.nextToken())] = 1;
        }

        for(int m = 0; m < M; m++){
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][b] = Integer.parseInt(st.nextToken());
            map[b][a] = map[a][b];
        }

        dfs(1);
    }

    private static void dfs(int island) {

    }
}
