package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class JungOl_1681_Hamilton {
    static int N, temp, ans;
    static int[][] arr;
    static boolean[] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        arr = new int[N][N];
        visited = new boolean[N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = Integer.MAX_VALUE;

        dfs(0, 0, 0);
        System.out.println(ans);
    }

    private static void dfs(int depth, int idx, int cost) {
        if(depth == N - 1){
            if(arr[idx][0] == 0){
                return;
            }

            if(cost + arr[idx][0] < ans) {
                ans = cost + arr[idx][0];
            }
            return;
        }
        visited[idx] = true;

        for(int i = 1; i < N; i++){
            if(visited[i] == true || arr[idx][i] == 0) continue;
            if(arr[idx][i] + cost < ans){
                dfs(depth + 1, i, arr[idx][i] + cost);
                visited[i] = false;
            }

        }
    }
}
