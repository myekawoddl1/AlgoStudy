package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class JungOl_2577_RotationSushi {
    static int N, d, k, c, cnt, ans;
    static int sushi[] = new int[3000010];
    static int kinds[] = new int[3010];
    static LinkedList<Integer> list = new LinkedList<>();
    static HashSet<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            sushi[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < k; i++) {
            list.add(sushi[i]);
            set.add(sushi[i]);
            kinds[sushi[i]]++;
        }
        ans = set.size();

        for (int i = 0; i < N - 1; i++){
            list.remove(0);
            kinds[sushi[i]]--;
            if(kinds[sushi[i]] == 0) set.remove(sushi[i]);
            list.add(sushi[(i + k) % N]);
            set.add(sushi[(i + k) % N]);
            kinds[sushi[(i + k) % N]]++;
            if (kinds[c] == 0) ans = Math.max(ans, set.size() + 1);
            else ans = Math.max(ans, set.size());
        }

        System.out.println(ans);
    }
}
