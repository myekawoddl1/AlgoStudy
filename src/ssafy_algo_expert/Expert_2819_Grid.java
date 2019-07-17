package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_2819_Grid {
    static int tc;
    static int[][] map;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static HashSet<Integer> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt."));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tc = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= tc; i++) {
            map = new int[4][4];
            set.clear();

            for(int j = 0; j < 4; j++){
                st = new StringTokenizer(br.readLine());
                for(int k = 0; k < 4; k++)
                    map[j][k] = Integer.parseInt(st.nextToken());
            }

            for(int j = 0; j < 4; j++){
                for(int k = 0; k < 4; k++){
                    dfs(j, k, map[j][k],0);
                }
            }

            System.out.println("#" + i + " " + set.size());
        }
    }

    static void dfs(int y, int x, int val, int cnt) {

        if(cnt == 6) {
            set.add(val);
            return ;
        }

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(0 < nx && nx < 4 && 0 < ny && ny < 4){
                dfs(ny, nx, val*10 + map[ny][nx], cnt + 1);
            }
        }
    }
}
