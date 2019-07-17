package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Baek_2294_Coin2 {
    static int N, K;
    static int[] coin;
    static int[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dp = new int[K + 1];
        coin = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            coin[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 1; i <= K; i++){
            dp[i] = 1000010;
        }
        dp[0] = 0; //최초 시작점
        for(int i = 0 ; i < N ; i++) {
            for(int j = coin[i]; j <= K ; j++) {
                dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);
            }
        }
        if(dp[K] == 1000010) dp[K] = -1;
        System.out.println(dp[K]);
    }
}
