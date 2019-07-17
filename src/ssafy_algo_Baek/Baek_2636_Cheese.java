package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


@SuppressWarnings("Duplicates")
public class Baek_2636_Cheese {
    static class Coord {
        int y, x;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[] dx = {1,-1,0,0};
    static int[] dy = {0,0,1,-1};
    static int R, C, ans, ansPre;
    static int map[][];
    
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        for(int i = 0; i < R; i++){
            st = new StringTokenizer(br.readLine());
                for(int j = 0; j < C; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }

        }

        Queue<Coord> que = new LinkedList<>(); // 공기 큐
        Queue<Coord> meltingQue = new LinkedList<>(); // 녹은 치즈 큐

        que.add(new Coord(0,0));
        map[0][0] = -1; // 맨처음 바깥 공기들 탐색용

        for(int hour = 0; ; hour++){
            while(!que.isEmpty()){
                Coord coord = que.poll();
                int y = coord.y;
                int x = coord.x;
                for(int dir = 0; dir < 4; dir++){
                    int ny = y + dy[dir];
                    int nx = x + dx[dir];
                    if(nx < 0 || ny < 0 || nx >= C || ny >= R) continue;
                        if(map[ny][nx] == 0){
                            que.add(new Coord(ny, nx));
                            map[ny][nx] = -1;
                            continue;
                        }
                        if(map[ny][nx] == 1){
                            meltingQue.add(new Coord(ny, nx));
                            map[ny][nx] = 99;
                        }
                }
            }

            /*for(int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    System.out.print(map[r][c] + "\t");
                }
                System.out.println();
            }
            System.out.println();*/

            if(meltingQue.isEmpty()){
                ans = hour;
                break;
            }
            ansPre = meltingQue.size();

            // 녹은 치즈위치가 공기가 되었기 때문에
            // 그 위치에서만 bfs하기 위해 공기 큐에 넣기
            while(!meltingQue.isEmpty()){
                que.add(meltingQue.poll());
                Coord coord = ((LinkedList<Coord>) que).getLast();
                map[coord.y][coord.x] = 99;
            }
        }

        System.out.println(ans);
        System.out.println(ansPre);
    }
}