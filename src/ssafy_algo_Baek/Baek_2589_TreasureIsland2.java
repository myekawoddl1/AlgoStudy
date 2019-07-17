package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
@SuppressWarnings("Duplicates")
public class Baek_2589_TreasureIsland2 {

    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int H, W, ans, INF = 999999;
    static int map[][];
    static int adjMaxtrix[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
        adjMaxtrix = new int[H * W + 1][H * W + 1];
        for(int i = 0; i < H; i++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            for(int j = 0; j < W; j++){
                if(str.charAt(j) == 'L'){
                    map[i][j] = 0;
                }else {
                    map[i][j] = -1;
                }
            }
        }
        int node = 0;
        for(int i = 0; i <= H*W; i++) {
            for(int j = 0; j <= H*W; j++) {
                adjMaxtrix[i][j] = INF;
            }
        }
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                node++;
                if(map[i][j] == 0){
                    int nx = j + 1;
                    if(nx < W && map[i][nx] == 0){
                        adjMaxtrix[node][node + 1] = 1;
                        adjMaxtrix[node + 1][node] = 1;
                    }
                    int ny = i + 1;
                    if(ny < H && map[ny][j] == 0){
                        adjMaxtrix[node][node + W] = 1;
                        adjMaxtrix[node + W][node] = 1;
                    }
                }
            }
        }
/*        for(int i = 0; i < H*W; i++) {
            for(int j = 0; j < H*W; j++) {
                System.out.print(adjMaxtrix[i][j] + " ");
            }
            System.out.println();
        }*/
        ans = 0;
        for(int k = 1; k <= H*W; k++) {
            for(int i = 1; i <= H*W; i++) {
                for(int j = 1; j <= H*W; j++) {
                    if(i == j) continue;
                    adjMaxtrix[i][j] = Math.min(adjMaxtrix[i][j], adjMaxtrix[i][k] + adjMaxtrix[k][j]);
                }
            }
        }

       for(int i = 1; i <= H*W; i++) {
            for(int j = 1; j <= H*W; j++) {
                if(adjMaxtrix[i][j] != INF){
                    ans = ans < adjMaxtrix[i][j] ? adjMaxtrix[i][j] : ans;
                }
            }
        }

        System.out.println(ans);
    }
}
