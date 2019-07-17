package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
빈 곳 : 언제나 이동할 수 있다. ('.‘로 표시됨)
벽 : 절대 이동할 수 없다. (‘#’)
열쇠 : 언제나 이동할 수 있다. 이 곳에 처음 들어가면 열쇠를 집는다. (소문자 a - f)
문 : 대응하는 열쇠가 있을 때만 이동할 수 있다. (대문자 a - f)
민식이의 현재 위치 : 빈 곳이고, 민식이가 현재 서 있는 곳이다. (숫자 0)
출구 : 달이 차오르기 때문에, 민식이가 가야하는 곳이다. 이 곳에 오면 미로를 탈출한다. (숫자 1)
 */

@SuppressWarnings("Duplicates")
public class Baek_1194_MoonFill {
    static class Minsik{
        int y, x;
        int key;// = new boolean[6];

        public Minsik(int y, int x, int key) {
            this.y = y;
            this.x = x;
            this.key = key;
        }
    }


    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int N, M, x, y;
    static char maze[][];
    static int distance[][][];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        maze = new char[N][M];
        boolean find = false;
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            maze[i] = st.nextToken().toCharArray();
            for(int j = 0; j < M; j++){
                if(find) continue;
                if(maze[i][j] == '0') {
                    x = j;
                    y = i;
                    find = true;
                }
            }
        }

        distance = new int[N][M][1 << 6];
        // System.out.println(1 << 6);
        int ans = bfs(y, x);
        System.out.println(ans);
    }

    private static int bfs(int y, int x) {
        Queue<Minsik> que = new LinkedList<>();
        Minsik start  = new Minsik(y, x, 0);
        distance[y][x][0] = 1;

        que.offer(start);
        while(!que.isEmpty()){
            Minsik cur = que.poll();
            y = cur.y;
            x = cur.x;
            int k = cur.key;
            if(maze[y][x] == '1'){
                return distance[cur.y][cur.x][k] - 1;
            }
            for(int dir = 0; dir < 4; dir++){

                int nx = x + dx[dir];
                int ny = y + dy[dir];
                if(nx < 0 || nx >= M || ny < 0 || ny >= N || maze[ny][nx] == '#' || distance[ny][nx][k] != 0) continue;

                if(maze[ny][nx] >= 97 ){
                    int nk = k | (1 << (maze[ny][nx] - 'a'));
                    if(distance[ny][nx][nk] == 0){
                        distance[ny][nx][nk] = distance[y][x][k] + 1;
                        que.offer(new Minsik(ny, nx, nk));
                    }
                    continue;
                }

                if(maze[ny][nx] >= 65){
                    int nk = k & (1 << (maze[ny][nx] - 'A'));
                    if(nk != 0){
                        distance[ny][nx][k] = distance[y][x][k] + 1;
                        que.offer(new Minsik(ny, nx, k));
                    }
                    continue;
                }

                if(maze[ny][nx] == '.' || maze[ny][nx] == '0' ||  maze[ny][nx] == '1' ){
                    distance[ny][nx][k] = distance[y][x][k] + 1;
                    que.offer(new Minsik(ny, nx, k));
                    continue;
                }

            }
        }
        return -1;
    }
}
