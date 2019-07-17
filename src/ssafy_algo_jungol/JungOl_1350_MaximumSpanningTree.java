package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class JungOl_1350_MaximumSpanningTree {
    static class Edge implements Comparable<Edge> {
        int a, b, val;

        public Edge(int a, int b, int val) {
            this.a = a;
            this.b = b;
            this.val = val;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "a=" + a +
                    ", b=" + b +
                    ", val=" + val +
                    '}';
        }

        @Override
        public int compareTo(Edge o) {
            return o.val - this.val;
        }
    }
    static int N, M, ans;
    static ArrayList<Edge> list = new ArrayList<>();
    static int[] parent = new int[1001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }
        for(int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new Edge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
        }

        // System.out.println(list);
        Collections.sort(list);
        // System.out.println(list);
        for(int i = 0; i < M; i++){
            Edge edge = list.get(i);
            int a = find(edge.a);
            int b = find(edge.b);
            if(a == b) continue;
            union(edge.a, edge.b);
            ans += edge.val;
             //System.out.println(ans);
        }
        System.out.println(ans);
    }

    public static int find(int a){
        if(a == parent[a]) return a;
        parent[a] = find(parent[a]);
        return parent[a];
    }

    public static void union(int a, int b){
        int aRoot = find(a);
        int bRoot = find(b);
        if(aRoot != bRoot){
            parent[aRoot] = b;
        }
    }
}
