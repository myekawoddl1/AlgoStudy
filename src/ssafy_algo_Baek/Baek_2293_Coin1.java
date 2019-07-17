package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Baek_2293_Coin1 {
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
        dp[0] = 1; //최초 시작점
        for(int i = 0 ; i < N ; i++) {
            for(int j = 1 ; j <= K ; j++) {
                if(j - coin[i] >= 0) dp[j] += dp[j - coin[i]];
            }
        }
        System.out.println(dp[K]);
    }
}
