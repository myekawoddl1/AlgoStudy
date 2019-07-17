package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_3124_MinimumSpaningTree {
    static class Edge implements Comparable<Edge>{
        int nodeA, nodeB;
        long cost;
        Edge(int a, int b, int c){
            nodeA = a;
            nodeB = b;
            cost = c;
        }

        @Override
        public int compareTo(Edge edge) {
            if(cost - edge.cost < 0){
                return -1;
            }else if(cost - edge.cost > 0){
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
    static int tc, V, E, unionCnt;
    static long ans;
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
            V = Integer.parseInt(st.nextToken());
            E = Integer.parseInt(st.nextToken());
            parents = new int[V + 1];
            Arrays.fill(parents, -1);
            edges = new Edge[E];

            for(int i = 0; i < E; i++){
                st = new StringTokenizer(br.readLine());
                edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            }

            Arrays.sort(edges);
            System.out.println(Arrays.toString(edges));

            for(int i = 0; i < E; i++){
                if(union(edges[i].nodeA, edges[i].nodeB)){
                    ans += edges[i].cost;
                }
                if(unionCnt == V - 1){
                    break;
                }
            }

            System.out.println("#" + t +  " " + ans);
        }

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
