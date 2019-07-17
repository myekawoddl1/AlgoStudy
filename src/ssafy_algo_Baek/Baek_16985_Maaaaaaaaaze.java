package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek_16985_Maaaaaaaaaze {
    static class Coord{
        int x, y, z;

        public Coord(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static int dx[] = {1,-1,0,0,0,0};
    static int dy[] = {0,0,1,-1,0,0};
    static int dz[] = {0,0,0,0,1,-1};

    static int arr[] = {0, 1, 2, 3, 4};
    static boolean selected[] = new boolean[5];

    static int panOrder[] = new int[5];

    static int pan[][][][] = new int[4][5][5][5]; // spin번 회전 한 ,i번째 판 j, k
    static int maze[][][] = new int[5][5][5]; // i번째 판 j, k
    static int distance[][][] = new int[5][5][5];

    static int ans = 99999;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st; // = new StringTokenizer(br.readLine());
        for(int i = 0; i < 5; i++){
            for(int j = 0; j < 5; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 5; k++){
                    pan[0][i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    pan[1][i][j][k] = pan[0][i][4 - k][j];
                }
            }
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    pan[2][i][j][k] = pan[1][i][4 - k][j];
                }
            }
            for(int j = 0; j < 5; j++){
                for(int k = 0; k < 5; k++){
                    pan[3][i][j][k] = pan[2][i][4 - k][j];
                }
            }
        }

        permutation(0);
        if(ans == 99999) ans = -1;
        System.out.println(ans);
    }

    static void permutation(int index) {
        if(index == 5) {
            for(int tmp = 0; tmp < 1024; tmp++) {
                int brute = tmp; // 5개의 판에 대해 회전횟수
                for (int i = 0; i < 5; i++) {
                    int dir = brute % 4; // 4진법을 이용하여 마스킹 해서 4^5 가지의 모든 경우의 수
                    brute /= 4;

                    for (int j = 0; j < 5; j++)
                        for (int k = 0; k < 5; k++)
                            maze[i][j][k] = pan[dir][panOrder[i]][j][k];
                }
                ans = Math.min(ans,bfs());
            }
            return;
        }

        for(int i = 0; i < 5; i++) {
            if(!selected[i]) {
                panOrder[index] = arr[i];
                selected[i] = true;
                permutation(index + 1);
                selected[i] = false;
            }
        }

    }

    private static int bfs() {
        if(maze[0][0][0] == 0 || maze[4][4][4] == 0) return 99999;
        for(int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    distance[i][j][k] = -1;
                }
            }
        }
        Queue<Coord> que = new LinkedList<>();
        que.offer(new Coord(0,0,0));
        distance[0][0][0] = 0;
        while(!que.isEmpty()){
            Coord coord = que.poll();
            for(int d = 0; d < 6; d++){
                int nx = coord.x + dx[d];
                int ny = coord.y + dy[d];
                int nz = coord.z + dz[d];
                if(0 > nx || 5 <= nx || 0 > ny || 5 <= ny || 0 > nz || 5 <= nz) continue;
                if(maze[nx][ny][nz] == 0 || distance[nx][ny][nz] != -1) continue;
                if(nx == 4 && ny == 4 && nz == 4)
                    return distance[coord.x][coord.y][coord.z]+1;
                distance[nx][ny][nz] = distance[coord.x][coord.y][coord.z]+1;
                que.offer(new Coord(nx,ny,nz));
            }
        }

        return 99999;
    }

}
