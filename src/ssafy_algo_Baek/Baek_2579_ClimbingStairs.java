package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2579_ClimbingStairs {
    static int stair[];
    static int dp[];
    static int N, num;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        stair = new int [N + 1];
        dp = new int [N + 1];
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            stair[i] = Integer.parseInt(st.nextToken());
        }

        dp[1] = stair[1];
        dp[2] = Math.max(stair[1] + stair[2], stair[2]);
        dp[3] = Math.max(stair[1] + stair[3], stair[2] + stair[3]);

        for (int i = 4; i <= N; i++) {
            dp[i] = Math.max(dp[i - 2] + stair[i], stair[i - 1] + stair[i] + dp[i - 3]);
        }
        System.out.println(dp[N]);
    }


}
