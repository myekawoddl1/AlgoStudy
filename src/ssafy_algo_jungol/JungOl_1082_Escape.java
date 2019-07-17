package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class JungOl_1082_Escape {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int R, C, ans;
    static char map[][];
    static boolean[][] visited;
    static boolean escape;
    static Queue<Coord> que = new LinkedList<Coord>();
    static Queue<Coord> fque = new LinkedList<Coord>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        visited = new boolean[R][C];

        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().toCharArray();
            for(int j = 0; j < C; j++){
                if(map[i][j]=='S'){
                    que.add(new Coord(i,j));
                    visited[i][j] = true;
                }
                if(map[i][j]=='*'){
                    fque.add(new Coord(i,j));
                    visited[i][j] = true;
                }
            }
        }

        bfs();
        if(escape){
            System.out.println(ans);
        }else{
            // System.out.println("impossible"); // 정올 1082
            System.out.println("KAKTUS"); // 백준 3055
        }
    }

    private static void bfs() {
        while(!que.isEmpty()){
            ans++;
            int size = fque.size();
            for(int i = 0; i < size; i++){
                Coord fire = fque.poll();
                for(int j = 0; j < 4; j++){
                    int nx = dx[j] + fire.x;
                    int ny = dy[j] + fire.y;

                    if(nx < 0 || ny < 0 || nx >= C || ny >= R || map[ny][nx] != '.' || visited[ny][nx]) continue;
                    map[ny][nx] = map[fire.y][fire.x];
                    visited[ny][nx] = true;
                    fque.add(new Coord(ny ,nx));

                }
            }
            size = que.size();
            for(int i = 0; i < size; i++){
                Coord gsub = que.poll();
                for(int j = 0; j < 4; j++){
                    int nx = dx[j] + gsub.x;
                    int ny = dy[j] + gsub.y;

                    if(nx < 0 || ny < 0 || nx >= C || ny >= R || map[ny][nx] == 'X' || map[ny][nx] == '*' || visited[ny][nx]) continue;
                    if(map[ny][nx] == 'D'){
                        escape = true;
                        return;
                    }
                    map[ny][nx] = map[gsub.y][gsub.x];
                    visited[ny][nx] = true;
                    que.add(new Coord(ny ,nx));
                }
            }
        }

    }

    static class Coord{
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
