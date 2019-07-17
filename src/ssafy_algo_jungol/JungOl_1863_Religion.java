package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class JungOl_1863_Religion {
    static int N, M;
    static int[] parents;
    static boolean[] parentCheck;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        parents = new int[N];
        Arrays.fill(parents, -1);

        int ans = N;
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(union(a - 1, b - 1)){
                ans--;
            }
        }

        System.out.println(ans);
    }
    static int find(int a){
        if(parents[a] < 0) return a;
        return parents[a] = find(parents[a]);
    }

    static boolean union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot) {
            parents[bRoot] = aRoot;
            return true;
        }
        return false;
    }

}
