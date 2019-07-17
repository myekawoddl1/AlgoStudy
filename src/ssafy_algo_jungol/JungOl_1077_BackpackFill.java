package ssafy_algo_jungol;

import org.omg.PortableInterceptor.INACTIVE;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class JungOl_1077_BackpackFill {
    static int N, W;
    static int weight[];
    static int value[];

    static int dp[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());

        weight = new int[N + 1];
        value = new int[N + 1];
        dp = new int[N + 1][W + 1];

        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st.nextToken());
            value[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 1; i <= N; i++) { // 모든 아이템 시도
            for(int w = 1; w <= W; w++) {
                if(weight[i] <= w) { // 현 아이템 무게가 구하고자 하는 무게보다 같거나 작다면 가방에 담을 수 있다.
                    dp[i][w] = Math.max(dp[i][w - weight[i]] + value[i], dp[i - 1][w]);
                }else {
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        System.out.println(dp[N][W]);
    }


}
