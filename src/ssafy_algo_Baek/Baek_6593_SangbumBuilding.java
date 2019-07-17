package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Baek_6593_SangbumBuilding {
    static class Coord{
        int z, y, x;

        public Coord(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }
    static int[] dx = {1, -1, 0, 0, 0, 0};
    static int[] dy = {0, 0, 1, -1, 0, 0};
    static int[] dz = {0, 0, 0, 0, 1, -1};
    static int L, R, C, ans;
    static char map[][][];
    static int dist[][][];
    static boolean visited[][][];
    static Queue<Coord> que = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        while(true){
            que = new LinkedList<>();
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if(L == 0 && R ==0 && C == 0) break;
            map = new char[L + 1][R + 1][C + 1];
            dist = new int[L + 1][R + 1][C + 1];
            visited = new boolean[L + 1][R + 1][C + 1];
            for(int l = 1; l <= L; l++){
                for(int r = 1; r <= R; r++){
                    st = new StringTokenizer(br.readLine());
                    String str = st.nextToken();
                    for(int  c = 1; c <= C; c++) {
                        map[l][r][c] = str.charAt(c - 1);
                        if(map[l][r][c] == 'S'){
                            que.offer(new Coord(l, r, c));
                            visited[l][r][c] = true;
                        }
                    }
                }
                br.readLine();
            }

            /*for(int l = 1; l <= L; l++) {
                for (int r = 1; r <= R; r++) {
                    for (int c = 1; c <= C; c++) {
                        System.out.print(map[l][r][c]);
                    }
                    System.out.println();
                }
                System.out.println();
            }*/
            boolean flag = false;
            while(!que.isEmpty() && !flag){
                Coord cur = que.poll();
                int curZ = cur.z;
                int curY = cur.y;
                int curX = cur.x;

                for(int i = 0; i < 6; i++){
                    int nz = curZ + dz[i];
                    int ny = curY + dy[i];
                    int nx = curX + dx[i];

                    if(nx == 0 || ny == 0 || nz == 0 || nx > C || ny > R || nz > L){ continue;}
                    if(visited[nz][ny][nx]) continue;
                    if(map[nz][ny][nx] == '.'){
                        que.offer(new Coord(nz, ny, nx));
                        visited[nz][ny][nx] = true;
                        dist[nz][ny][nx] = dist[curZ][curY][curX] + 1;
                    }
                    if(map[nz][ny][nx] == 'E'){
                        ans = dist[curZ][curY][curX] + 1;
                        flag = true;
                    }
                }
            }

            if(flag){
                System.out.println("Escaped in " + ans + " minute(s).");
            }else{
                System.out.println("Trapped!");
            }

        }
    }
}
