package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_1251_Hanaro {
    static class Island{
        int x, y;

        public Island(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Island{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }

    static class Edge implements Comparable<Edge>{
        int nodeA, nodeB;
        double cost;
        Edge(int a, int b, double c){
            this.nodeA = a;
            this.nodeB = b;
            this.cost = c;
        }

        @Override
        public int compareTo(Edge edge) {
            if(this.cost - edge.cost < 0){
                return -1;
            }else if(this.cost - edge.cost > 0){
                return 1;
            }else return 0;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "nodeA=" + nodeA +
                    ", nodeB=" + nodeB +
                    ", cost=" + cost +
                    '}';
        }
    }

    static int tc, N, unionCnt;
    // static long ans;
    static double E, ans;
    static Island[] islands;
    static int[] parents;
    static Edge[] edges;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tc = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= tc; t++){
            ans = 0;
            unionCnt = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            islands = new Island[N];
            parents = new int[N];
            Arrays.fill(parents, -1);
            edges = new Edge[(N * (N - 1))/2];


            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                islands[i] = new Island(Integer.parseInt(st.nextToken()),0);
            }
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < N; i++){
                islands[i].y = Integer.parseInt(st.nextToken());
            }
            // String str = br.readLine();
            E = Double.parseDouble(br.readLine());

            //System.out.println(Arrays.toString(islands));

            int edgeIndex = 0;
            for(int i= 0 ; i < N; i++) {
                for(int j = i + 1; j < N; j++) {
                    edges[edgeIndex++] = new Edge(i, j, getCost(islands[i],islands[j], E));
                }
            }

            Arrays.sort(edges);

            for (Edge edge: edges) {
                if(union(edge.nodeA, edge.nodeB)){
                    ans += edge.cost;
                }
                if(unionCnt == N - 1){
                    break;
                }

            }

            System.out.println("#" + t +  " " + Math.round(ans));
        }

    }

    private static double getCost(Island a, Island b, double e) {
        // 환경 부담 세율(E)과 각 해저터널 길이(L)의 제곱의 곱(E * L2)만큼 지불
        long L = (long)
                (Math.pow(Math.abs(a.x - b.x), 2) + Math.pow(Math.abs(a.y - b.y),2));
//      return Math.round(e*L);
        return e*L;
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
            unionCnt++;
            return true;
        }
        else return false;
    }
}
