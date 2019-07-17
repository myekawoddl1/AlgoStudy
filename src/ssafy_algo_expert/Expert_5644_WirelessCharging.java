package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_5644_WirelessCharging {
    static int[] dx = {0, 0, 1, 0, -1};
    static int[] dy = {0, -1, 0, 1, 0};
    static int T, M, A, volume, ans;
    static int[][] map;
    static int[] moveA;
    static int[] moveB;
    static BC[] bcArr;
    static User[] user;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            ans = 0;
            volume = 0;
            map = new int[11][11];
            user = new User[2];
            user[0] = new User(1,1);
            user[1] = new User(10,10);
            st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            A = Integer.parseInt(st.nextToken());
            moveA = new int[M];
            moveB = new int[M];
            bcArr = new BC[A];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                moveA[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; i++){
                moveB[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < A; i ++){
                st = new StringTokenizer(br.readLine());
                bcArr[i] = new BC(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()), false);
            }
            go();
            sb.append("#" + tc + " " + ans);
        }
        System.out.println(sb);
    }

    static void go() {
        charge(0, 0);
        ans += volume;
        for(int m = 0; m < M; m++){
            volume = 0;
            user[0].x += dx[moveA[m]];
            user[0].y += dy[moveA[m]];
            user[1].x += dx[moveB[m]];
            user[1].y += dy[moveB[m]];
            charge(0,0);
            ans += volume;
        }
    }

    static void charge(int u, int sum) {
        if(u == 2){
            volume = Math.max(volume, sum);
            return;
        }
        for(int bc = 0; bc < A; bc++){
            if(!bcArr[bc].used && isPossible(u, bc)){
                bcArr[bc].used = true;
                charge(u + 1,sum + bcArr[bc].p);
                bcArr[bc].used = false;
            }
        }
        charge(u + 1,sum);
    }

    static boolean isPossible(int u, int bc) {
        if(Math.abs(user[u].x - bcArr[bc].x) + Math.abs(user[u].y - bcArr[bc].y) <= bcArr[bc].c)
            return true;
        else
            return false;
    }
    static class BC{
        int x, y, c, p;
        boolean used;

        public BC(int x, int y, int c, int p, boolean used) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
            this.used = used;
        }
    }

    static class User{
        int x, y;
        public User(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
