package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class JungOl_1894_Upstairs {
    static int N;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        dp = new int[31];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i <= 30; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        System.out.println(dp[N]);
    }
}
