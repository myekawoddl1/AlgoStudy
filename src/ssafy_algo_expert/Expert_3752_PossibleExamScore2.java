package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Expert_3752_PossibleExamScore2 {
    static int T, N, ans;
    static boolean[] isPassible;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            ans = 0;
            isPassible = new boolean[100001];

            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            scores = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
            }

            combination(0, 0);

            sb.append("#" + tc + " " + ans + "\n");
        }

        System.out.println(sb);

    }

    private static void combination(int sum, int index) {
        if(!isPassible[sum]){
            isPassible[sum] = true;
            ans++;
        }
        if(index == N){
            // System.out.println(Arrays.toString(selected));
            return;
        }

        for(int i = index; i < scores.length; i++) {
            if(!isPassible[sum + scores[i]]) continue;
            combination(sum + scores[i], i + 1);
        }
    }

}
