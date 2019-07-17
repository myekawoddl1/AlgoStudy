package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_5656_BlockBrokeQue {
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
    static int T, N, W, H, ans, ans2, result;
    static int[][] map = new int[15][12];
    static int[][] map2 = new int[15][12];
    static int[] num = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11};
    static int[] select = new int[4];
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
                    map2[i][j] = map[i][j];
                    if(map[i][j] != 0) ans++;
                }
            }
            ans2 = ans;
            permu(0);
            System.out.println("#" + tc + " " + result);
        }
    }

    private static void permu(int idx) {
        if(idx == N){
            simul();
            for(int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    map[i][j] = map2[i][j];
                }
            }

            result = Math.min(ans,result);
            ans = ans2;
            return;
        }

        for(int i = 0; i < W; i++){
            select[idx] = i;
            permu(idx + 1);
        }
    }

    private static void simul() {
        for(int i = 0; i < N; i++){
            shoot(select[i]);
        }
    }

    private static void shoot(int sIdx) {
        for(int i = 0; i < H; i ++){
            if(map[i][sIdx] != 0) {
                que.offer(new Coord(i, sIdx, map[i][sIdx]));
                ans--;
                map[i][sIdx] = 0;
                break;
            }
        }

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
                    }
                }
            }
        }
        blockDown();
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
    }

    private static boolean isPossible(int ny, int nx) {
        if(ny < 0 || nx < 0 || ny >= H || nx >= W) return false;
        return true;
    }
}
