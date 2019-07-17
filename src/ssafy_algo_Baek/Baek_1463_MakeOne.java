package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Baek_1463_MakeOne {
    static int dp[];
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        dp = new int[1000002];

        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 1;

        for (int i = 4; i <= N; i++) {
            if (i % 6 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 2]);
                dp[i] = Math.min(dp[i], dp[i / 3]) + 1;
            }
            else if (i % 2 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 2]) + 1;
            }
            else if (i % 3 == 0) {
                dp[i] = Math.min(dp[i - 1], dp[i / 3]) + 1;
            }
            else {
                dp[i] = dp[i - 1] + 1;
            }
        }

        System.out.println(dp[N]);
    }
}
