package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_2383_LunchTime {
    static int dx[] = {0, 0, 1, -1};
    static int dy[] = {1, -1, 0, 0};
    static int T, N, ans;
    static int map[][];
    static boolean[] stairone;
    static LinkedList<User> userlist = new LinkedList<>();
    static LinkedList<Stair> stairs = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++){
            stairone = new boolean[11];
            userlist.clear();
            stairs.clear();
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            map = new int[N][N];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                    if(map[i][j] == 1) {
                        userlist.add(new User(i, j, 0));
                        continue;
                    }
                    if(map[i][j] >= 2){
                        stairs.add(new Stair(i, j, map[i][j]));
                    }
                }
            }

            stairchoice(1);

            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void stairchoice(int idx) {
        if(idx > userlist.size()){
            go();
            return;
        }
        stairone[idx] = true;
        stairchoice(idx + 1);
        stairone[idx] = false;
        stairchoice(idx + 1);
    }

    private static void go() {

    }

    static class User{
        int y, x, target;

        public User(int y, int x, int target) {
            this.y = y;
            this.x = x;
            this.target = target;
        }
    }
    static class Stair{
        int y, x, len;

        public Stair(int y, int x, int len) {
            this.y = y;
            this.x = x;
            this.len = len;
        }
    }
}
