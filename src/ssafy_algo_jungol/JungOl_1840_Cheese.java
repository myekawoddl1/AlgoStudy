package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class JungOl_1840_Cheese {
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int R, C, ans, ansPre;
    static int map[][];
    static boolean[][] visited, airVisited;
    static Queue<Coord> meltingQue = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new int[R][C];
        for(int r = 0; r < R; r++){
            st = new StringTokenizer(br.readLine());
            for(int c = 0; c < C; c++){
                map[r][c] = Integer.parseInt(st.nextToken());
            }
        }

        while(true){
            airSpread(); // 외부 공기 체크
            visited = new boolean[R][C];

            for(int r = 1; r < R - 1; r++){
                for(int c = 1; c < C - 1; c++){
                    if(map[r][c] != 1) continue;
                    for(int dir = 0; dir < 4; dir++){
                        int ny = r + dy[dir];
                        int nx = c + dx[dir];
                        if(nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
                        if(map[ny][nx] == -1){
                            bfs(r, c);
                            break;
                        }
                    }
                }
            }
     /*       for(int r = 1; r < R - 1; r++) {
                for (int c = 1; c < C - 1; c++) {
                    System.out.print(map[r][c] + "\t");
                }
                System.out.println();
            }
            System.out.println();*/

            if(meltingQue.size() == 0) break;
            ansPre = meltingQue.size();
            ans++;

            while(!meltingQue.isEmpty()){
                Coord coord = meltingQue.poll();
                map[coord.y][coord.x] = -1;
            }
        }
        System.out.println(ans);
        System.out.println(ansPre);

    }

    private static void bfs(int y, int x) {
        Queue<Coord> que = new LinkedList<>();
        que.offer(new Coord(y, x));

        while(!que.isEmpty()){
            Coord coord = que.poll();
            y = coord.y;
            x = coord.x;
            visited[y][x] = true;

            for(int dir = 0; dir < 4; dir++){
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(nx < 0 || ny < 0 || nx >= C || ny >= R) continue;

                if(map[ny][nx] == -1){
                    map[y][x] = 99;
                    meltingQue.offer(new Coord(y, x));
                    break;
                }
            }


            for(int dir = 0; dir < 4; dir++){
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(nx < 0 || ny < 0 || nx >= C || ny >= R || visited[ny][nx]) continue;

                if(map[ny][nx] == 1){
                    que.offer(new Coord(ny,nx));
                    visited[ny][nx] = true;
                }
            }
        }
    }

    private static void airSpread() {
        airVisited = new boolean[R][C];
        airVisited[0][0] = true;

        Queue<Coord> que = new LinkedList<>();
        que.offer(new Coord(0, 0));
        while(!que.isEmpty()){
            Coord coord = que.poll();
            int y = coord.y;
            int x = coord.x;
            map[y][x] = -1;

            for(int dir = 0; dir < 4; dir++){
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(nx < 0 || ny < 0 || nx >= C || ny >= R || airVisited[ny][nx]) continue;

                if(map[ny][nx] <= 0){
                    que.offer(new Coord(ny,nx));
                    airVisited[ny][nx] = true;
                }
            }
        }
    }

    static class Coord {
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
