package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class BusBaek {
    static int T, N, ans;
    static int map[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ans = 0;

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Queue<Coord> que = new LinkedList<>();

        if(map[0][0] == 0 && map[0][1] == 0) {
            que.offer(new Coord(0, 1, 0));
        }
        // if(map[0][0] == 0 && map[1][0] == 0) que.offer(new Coord(1, 0, 1));

        while(!que.isEmpty()){
            Coord coord = que.poll();
            int y = coord.y;
            int x = coord.x;
            int dir = coord.dir;

            if(y == N-1 && x== N-1){
                //if(dir != 2){
                ans++;
                //     continue;
                //  }
            }

            switch (dir){
                case 0: // 오른쪽 방향일 때 오른쪽 대각선 가능한지 봐야 함
                    // 오른쪽
                    if(x + 1 < N && map[y][x + 1] == 0){
                        que.offer(new Coord(y, x + 1, 0));
                    }
                    // 대각선
                    if(x + 1 < N && y + 1 < N && map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0){
                        que.offer(new Coord(y + 1, x + 1, 2));
                    }
                    break;
                case 1: // 아래쪽 방향일 때 아래쪽 대각선 가능한지 봐야 함
                    // 아래쪽
                    if(y + 1 < N && map[y + 1][x] == 0){
                        que.offer(new Coord(y + 1, x, 1));
                    }
                    // 대각선
                    if(x + 1 < N && y + 1 < N && map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0){
                        que.offer(new Coord(y + 1, x + 1, 2));
                    }
                    break;
                case 2: //  대각선 방향일 때 오른쪽 아래쪽 대각선 가능한지 봐야 함
                    // 오른쪽
                    if(x + 1 < N && map[y][x + 1] == 0){
                        que.offer(new Coord(y, x + 1, 0));
                    }
                    // 아래쪽
                    if(y + 1 < N && map[y + 1][x] == 0){
                        que.offer(new Coord(y + 1, x, 1));
                    }
                    // 대각선
                    if(x + 1 < N && y + 1 < N && map[y][x + 1] == 0 && map[y + 1][x] == 0 && map[y + 1][x + 1] == 0){
                        que.offer(new Coord(y + 1, x + 1, 2));
                    }
                    break;
            }


        }


        System.out.println(ans);
    }
    static class Coord{
        int y, x, dir;  // 0 오른쪽 1 아래쪽 2 대각선

        public Coord(int y, int x, int dir) {
            this.y = y;
            this.x = x;
            this.dir = dir;
        }
    }
}
