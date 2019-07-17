package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_SwimmingPool {
    static int T, ans, dayPrice, monthPrice,threeMonthPrice, yearPrice;
    static int month[] = new int[13];
    static int minMonth[]; // 각 월의 최소 비용
    static int dp[]; // dp[n] == n월 까지의 최소 비용
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++){
            minMonth = new int[13];
            dp = new int[13];

            st = new StringTokenizer(br.readLine());
            dayPrice = Integer.parseInt(st.nextToken());
            monthPrice = Integer.parseInt(st.nextToken());
            threeMonthPrice = Integer.parseInt(st.nextToken());
            yearPrice = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i <= 12; i++){
                month[i] = Integer.parseInt(st.nextToken());
            }

            for (int i = 1; i <= 12; i++) {
                minMonth[i] = Math.min(dayPrice * month[i], monthPrice); // 각 월의 최소 비용
            }
            dp[0] = 0;
            dp[1] = minMonth[1];
            dp[2] = dp[1] + minMonth[2];
            for (int i = 3; i <= 12; i++) {
                dp[i] = dp[i - 1] + minMonth[i];
                if (dp[i] > dp[i - 3] + threeMonthPrice) {
                    dp[i] = dp[i - 3] + threeMonthPrice;
                }
            }

            if (dp[12] > yearPrice) {
                dp[12] = yearPrice;
            }
            ans = dp[12];
            System.out.println("#" + tc + " " + ans);
        }
    }

}