package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_1861_SquareRoom {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int T, ansNum, ansCnt, N;
    static int[][] map;
    static int[][] distance;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            ansCnt = 0;
            ansNum = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    distance = new int[N][N];
                    int result = bfs(i, j);
                    if(ansCnt < result){
                        ansCnt = result;
                        ansNum = map[i][j];
                        continue;
                    }
                    if(ansCnt == result){
                        ansNum = ansNum < map[i][j] ? ansNum : map[i][j];
                    }

                }
            }

            sb.append("#" + tc + " " + ansNum + " " + ansCnt + "\n");
        }
        System.out.println(sb);

    }

    private static int bfs(int i, int j) {
        Queue<Coord> que = new LinkedList<>();
        que.offer(new Coord(i, j));
        distance[i][j] = 1;
        int count = 0;
        while (!que.isEmpty()){
            Coord coord = que.poll();
            int y = coord.y;
            int x = coord.x;
            count = distance[y][x];
            for(int dir = 0; dir < 4; dir++){
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if(map[ny][nx] == map[y][x] + 1){
                    que.offer(new Coord(ny, nx));
                    distance[ny][nx] = distance[y][x] + 1;
                }

            }
        }
        return count;
    }

    static class Coord{
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
