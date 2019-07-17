package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_1868_MineSweeper {
    static class Coord{
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int dx[] ={0,0,1,1,-1,-1,1,-1};
    static int dy[] ={1,-1,1,-1,1,-1,0,0};
    static int T, N, mineCnt, openCnt;
    static int map[][];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            mineCnt = 0;
            openCnt = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];
            visited = new boolean[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                for(int j = 0; j < N; j++){
                    if(str.charAt(j) == '*'){
                        map[i][j] = -1;
                        mineCnt++;
                        continue;
                    }
                    map[i][j] = 0;
                }
            }

            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(map[i][j] == -1) continue;
                    int tempCnt = 0;
                    for(int k = 0; k < 8; k++){
                        int ny = i + dy[k];
                        int nx = j + dx[k];
                        if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                        if(map[ny][nx] == -1){
                            tempCnt++;
                        }
                    }
                    map[i][j] = tempCnt;
                }
            }

            int bfsCnt = 0;
            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(!visited[i][j] && map[i][j] == 0){
                        bfs(i, j);
                        bfsCnt++;
                    }
                }
            }
            int ans = (N * N) - mineCnt - openCnt + bfsCnt;
            /*for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    int tempCnt = 0;
                    if(!visited[i][j]){
                        for(int k = 0; k < 8; k++){
                            int ny = i + dy[k];
                            int nx = j + dx[k];
                            if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                            if(map[ny][nx] == -1){
                                tempCnt++;
                                break;
                            }
                        }
                        if(tempCnt == 0){
                            bfs(i, j);
                        }
                    }
                }
            }*/


            System.out.println("#" + tc + " " + ans);
        }
    }
    static void bfs(int y, int x){
        Queue<Coord> que = new LinkedList<>();
        que.offer(new Coord(y, x));
        visited[y][x] = true;
        openCnt++;
        while(!que.isEmpty()){
            Coord tempCoord = que.poll();
            y = tempCoord.y;
            x = tempCoord.x;
            for(int k = 0; k < 8; k++){
                int ny = y + dy[k];
                int nx = x + dx[k];
                if(ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
                if(!visited[ny][nx]){
                    if(map[ny][nx] == 0){
                        que.offer(new Coord(ny, nx));
                    }
                    if(map[ny][nx] != -1) openCnt++;
                    visited[ny][nx] = true;
                }

            }
        }
    }

}
