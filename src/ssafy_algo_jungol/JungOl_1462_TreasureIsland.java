package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class JungOl_1462_TreasureIsland {
    static class Pair{
        int y, x;

        public Pair(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int dx[] = {0,0,1,-1};
    static int dy[] = {1,-1,0,0};
    static int H, W, ans;
    static int map[][];
    static boolean visited[][];
    static Pair pair;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[H][W];
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

        Queue<Pair> que = new LinkedList<>();
        Pair tempPair;
        for(int i = 0; i < H; i++){
            for(int j = 0; j < W; j++){
                if(map[i][j] == -1) continue;
                map[i][j] = 0;
                visited = new boolean[H][W];
                visited[i][j] = true;

                que.offer(new Pair(i, j));
                int max = 0;
                while(!que.isEmpty()){
                    tempPair = que.poll();
                    int y = tempPair.y;
                    int x = tempPair.x;

                    max = map[y][x];
                    for(int k = 0; k < 4; k++){
                        int ny = y + dy[k];
                        int nx = x + dx[k];
                        if(nx < 0 || nx >= W || ny < 0 || ny >= H) continue;
                        if(!visited[ny][nx] && map[ny][nx] != -1){
                            que.offer(new Pair(ny,nx));
                            visited[ny][nx] = true;
                            map[ny][nx] = map[y][x] + 1;
                        }
                    }
                }

                ans = max > ans ? max : ans;
            }
        }


        System.out.println(ans);
    }
}
