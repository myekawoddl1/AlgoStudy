package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Baek_11508_2Plus1Sale {
    static int N, ans;
    static int C[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = new int[N];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            C[i] = Integer.parseInt(st.nextToken());
            ans += C[i];
        }
        Arrays.sort(C);
        for (int i = N - 3; i >= 0; i -= 3) {
            ans -= C[i];
        }
        System.out.println(ans);
    }
}
