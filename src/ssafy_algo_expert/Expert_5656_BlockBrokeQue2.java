package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_5656_BlockBrokeQue2 {
    static class Coord{
        int y, x, val;

        public Coord(int y, int x, int val) {
            this.y = y;
            this.x = x;
            this.val = val;
        }
    }
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int T, N, W, H, ans, result;
    static int[][] map = new int[15][12];
    static boolean[] isBroke;
    static Queue<Coord> que = new LinkedList<>();

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
            if(result == 10000) result = 0;
            System.out.println("#" + tc + " " + result);
        }
    }

    private static void permu(int idx) {
        if(idx == N){
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
                isBroke = new boolean[12];
                que.offer(new Coord(i, sIdx, map[i][sIdx]));
                ans--;
                map[i][sIdx] = 0;
                isBroke[sIdx] = true;
                blockBroke();
                blockDown();
                broke = true;
                break;
            }
        }
        return broke;
    }
    private static void blockBroke(){
        while(!que.isEmpty()){
            Coord coord = que.poll();
            int val = coord.val;
            int y = coord.y;
            int x = coord.x;

            int ny, nx;
            for(int i = 1; i < val; i++){
                for(int d = 0; d < 4; d++){
                    ny = y + dy[d] * i;
                    nx = x + dx[d] * i;
                    if(isPossible(ny, nx) && map[ny][nx] != 0){
                        ans--;
                        que.offer(new Coord(ny, nx, map[ny][nx]));
                        map[ny][nx] = 0;
                        isBroke[nx] = true;
                    }
                }
            }
        }
    }

    private static void blockDown() {
        for(int x = 0; x < W; x++){
            if(!isBroke[x]) continue;
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
    }

    private static boolean isPossible(int ny, int nx) {
        if(ny < 0 || nx < 0 || ny >= H || nx >= W) return false;
        return true;
    }
}
