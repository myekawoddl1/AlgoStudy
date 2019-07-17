package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_4613_RussiaFlag {
    static int T, N, M, ans;
    static char[][] flag;
    static int[][] colorCnt;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            flag = new char [N][M];
            colorCnt = new int [N][3];
            dp = new int [N][3];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                // String str = st.nextToken();
                flag[i] = st.nextToken().toCharArray();
                for(int j = 0; j < M; j++){
                    if(flag[i][j] == 'W'){
                        colorCnt[i][0]++; // W
                    }else if(flag[i][j] == 'B'){
                        colorCnt[i][1]++; // B
                    }else{
                        colorCnt[i][2]++; // R
                    }
                  /*  switch (flag[i][j]){
                        case 'W':
                            colorCnt[i][0]++; // W
                            break;
                        case 'B':
                            colorCnt[i][1]++; // B
                            break;
                        case 'R':
                            colorCnt[i][2]++; // R
                            break;
                    }*/
                }
            }
            ans = go(0, 0);
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }

    static int go(int row, int color) { // W == 0, B == 1, R == 2
        if (dp[row][color] != 0) {
            return dp[row][color];
        }

        int cnt = M - colorCnt[row][color];

        if (row == N - 1) {
            if (color == 2) {
                return dp[row][color] = M - colorCnt[row][2];
            } else {
                return dp[row][color] = 99999;
            }
        }

        if (color == 0) {
            cnt += Math.min(go(row + 1, 0), go(row + 1, 1));
        }else if (color == 1) {
            cnt += Math.min(go(row + 1, 1), go(row + 1, 2));
        }else if (color == 2) {
            for (int r = row + 1; r < N; r++) {
                cnt += M - colorCnt[r][2];
            }
        }

        return dp[row][color] = cnt;
    }
}
