package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Expert_3752_PossibleExamScore {
    static int T, N, ans;
    static boolean[] isPossible;
    static int[] scores;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        T = Integer.parseInt(st.nextToken());
        for (int tc = 1; tc <= T; tc++) {
            int max = 0;
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            scores = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                scores[i] = Integer.parseInt(st.nextToken());
                max += scores[i];
            }
            isPossible = new boolean[max + 1];
            isPossible[0] = true;
            // ans++;
            max = 0;
            for (int i = 0; i < N; i++) {
                max += scores[i];
                for(int j = max; j >= 0; j--){
                    if(isPossible[j]){
                        if(scores[i] + j > max) continue;
                        isPossible[scores[i] + j] = true;
                    }
                }
            }
            for(int j = max; j >= 0; j--){
                if(isPossible[j]) ans++;
            }
            sb.append("#" + tc + " " + ans + "\n");
        }
        System.out.println(sb);
    }
}
