package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_5656_BlockBroke {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int T, N, W, H, ans, result;
    static int[][] map = new int[15][12];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++){
            ans = 0;
            result = 10000;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());

            for(int i = 0; i < H; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] != 0) ans++;
                }
            }
            permu(0);
            System.out.println("#" + tc + " " + result);
        }
    }

    private static void permu(int idx) {
        if(idx == N || ans == 0){
            result = Math.min(ans,result);
            return;
        }

        for(int i = 0; i < W; i++){
            int[][] map2 = new int[15][12];
            int ans2 = ans;
            for(int y = 0; y < H; y++) {
                for (int x = 0; x < W; x++) {
                    map2[y][x] = map[y][x];
                }
            }
            if(shoot(i)){
                permu(idx + 1);
                map = map2;
                ans = ans2;
            }
        }
    }

    private static boolean shoot(int sIdx) {
        boolean broke = false;
        for(int i = 0; i < H; i ++){
            if(map[i][sIdx] != 0) {
                blockBroke(i, sIdx);
                blockDown();
                broke = true;
                break;
            }
        }
        return broke;
    }
    private static void blockBroke(int y, int x){
        if(map[y][x] == 0) return;
        int val = map[y][x] - 1;
        map[y][x] = 0;
        ans--;
        for(int i = 1; i <= val; i++){
            for(int d = 0; d < 4; d++){
                int ny = y + dy[d] * i;
                int nx = x + dx[d] * i;
                if(isPossible(ny, nx) && map[ny][nx] != 0){
                    blockBroke(ny, nx);
                }
            }
        }
    }

    private static void blockDown() {
        for(int x = 0; x < W; x++){
            LinkedList<Integer> list = new LinkedList<>();
            for(int y = 0; y < H; y++){
                if(map[y][x] == 0) continue;
                list.add(map[y][x]);
                map[y][x] = 0;
            }
            for(int y = 0; y < list.size() ; y++){
                int a = list.get(list.size() - 1 - y);
                map[H - 1 - y][x] = a;
            }
        }
        /*for(int x = 0; x < W; x++) {
            int tempY = H; //이동해야할 위치
            for(int y = H-1; y >= 0; y--) {
                if(map[y][x]!=0) {
                    tempY--;
                    map[tempY][x] = map[y][x];
                    if(y != tempY) map[y][x] = 0;
                }
            }
        }*/
    }

    private static boolean isPossible(int ny, int nx) {
        if(ny < 0 || nx < 0 || ny >= H || nx >= W) return false;
        return true;
    }
}
