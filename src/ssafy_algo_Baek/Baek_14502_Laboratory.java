package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Baek_14502_Laboratory {
    static class Coord{
        int y, x;
        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int N, M, MAX = Integer.MIN_VALUE, safeAreaCount = 0;
    static int[][] map, cloneMap;
    static ArrayList<String> wall = new ArrayList<>();
    static Queue<Coord> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 0) safeAreaCount++;
            }
        }

        // 벽세우기
        for (int i = 0; i < N * M; i++) {
            int row = i / M;
            int col = i % M;

            if (map[row][col] == 0) {
                wall.add(row + " " + col);
                recursive(i, 1);
            }
        }

        System.out.println(MAX);
    }

    private static void recursive (int num, int count) {
        // 벽 세개 세웠으면 바이러스 퍼트리기
        if (count == 3) {
            copyMap();
            bfs();
        } else {
            for (int i = num + 1; i < N*M; i++) {
                int row = i / M;
                int col = i % M;
                if (map[row][col] == 0) {
                    wall.add(row + " " + col);
                    recursive(i, count + 1);
                }
            }
        }
        int index = wall.indexOf(num / M + " " + num % M);
        wall.remove(index);
    }

    private static void copyMap () {
        queue.clear();
        cloneMap = new int[N][M];

        // 배열 복사
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cloneMap[i][j] != 1) cloneMap[i][j] = map[i][j];
                if (map[i][j] == 2) queue.offer(new Coord(i, j));
            }
        }

        // 3개 벽 추가
        for (int i = 0; i < 3; i++) {
            String[] str = wall.get(i).split(" ");
            cloneMap[Integer.parseInt(str[0])][Integer.parseInt(str[1])] = 1;
        }
    }

    private static void bfs () {
        int result = safeAreaCount - 3;

        // 바이러스 퍼트리기
        while(!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                Coord p = queue.poll();
                for (int j = 0; j < 4; j++) {
                    int nx = p.x + dx[j];
                    int ny = p.y + dy[j];

                    if (nx >= 0 && nx < M && ny >= 0&& ny < N && cloneMap[ny][nx] == 0) {
                        cloneMap[ny][nx] = 2;
                        result--;
                        queue.add(new Coord(ny, nx));
                    }
                }
            }
        }
        MAX = Math.max(MAX, result);
    }
}