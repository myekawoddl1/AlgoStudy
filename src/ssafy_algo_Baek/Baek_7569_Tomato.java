package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Baek_7569_Tomato {
    static class Coord{
        int z, y, x;

        public Coord(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    static int dx[] = {1, -1, 0, 0, 0, 0};
    static int dy[] = {0, 0, 1, -1, 0, 0};
    static int dz[] = {0, 0, 0, 0, 1, -1};
    static int M, N, H, emptyCnt, tomatoCnt, dayCnt;
    static int map[][][];
    static Queue<Coord> que = new LinkedList<Coord>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int [H][N][M]; // 높이 y x

        for(int z = 0; z < H; z++){
            for(int y = 0; y < N; y++){
                st = new StringTokenizer(br.readLine());
                for(int x = 0; x < M; x++){
                    map[z][y][x] = Integer.parseInt(st.nextToken());
                    if(map[z][y][x] == 1) {
                        tomatoCnt++;
                        que.offer(new Coord(z, y, x));
                        continue;
                    }
                    if(map[z][y][x] == -1){
                        emptyCnt++;
                    }
                }
            }
        }
        if (tomatoCnt == 0) {
            System.out.println(-1);
            return;
        }
        else if ((emptyCnt + tomatoCnt) == M * N * H) {
            System.out.println(0);
            return;
        }else {
            while(!que.isEmpty()) {
                Coord coord = que.poll();
                int x = coord.x;
                int y = coord.y;
                int z = coord.z;
                if (dayCnt <= map[z][y][x]) {
                    dayCnt = map[z][y][x];
                }
                for(int i = 0; i < 6; i++){
                    int nx = coord.x + dx[i];
                    int ny = coord.y + dy[i];
                    int nz = coord.z + dz[i];

                    if(nz < 0 || nz >= H || ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

                    if (map[nz][ny][nx] == 0) {
                        que.offer(new Coord(nz, ny, nx));
                        tomatoCnt++;
                        map[nz][ny][nx] = map[z][y][x] + 1;
                    }
                }
            }
        }

        if ((emptyCnt + tomatoCnt) != M * N * H) {
            System.out.println(-1);
            return;
        }
        System.out.println(dayCnt - 1);

    }
}
