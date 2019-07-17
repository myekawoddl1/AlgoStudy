package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Expert_1238_Contact {
    static int dataCnt, start, ans, endDist;
    static boolean visited[];
    static boolean map[][];
    static int dist[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        for(int tc = 1; tc <= 10; tc++){
            map = new boolean[101][101];
            visited = new boolean[101];
            dist = new int[101];
            st = new StringTokenizer(br.readLine());
            dataCnt = Integer.parseInt(st.nextToken());
            start = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < dataCnt; i += 2){
                map[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())] = true;
            }

            bfs();
            ArrayList<Integer> list = new ArrayList<>();
            for(int i = 1; i < 101; i++) {
                if(dist[i] == endDist) {
                    list.add(i);
                }
            }
            Collections.sort(list);
            ans = list.get(list.size()-1);
            System.out.println("#" + tc + " " + ans);
        }
    }
    static void bfs(){
        LinkedList<Node> queue = new LinkedList<>();
        visited[start] = true;
        queue.add(new Node(start, 0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int nodeNum = node.nodeNum;
            int count = node.count;
            dist[nodeNum] = count;
            for(int i = 1; i < 101; i++) {
                if(i != nodeNum && !visited[i]) {
                    if(map[nodeNum][i]) {
                        visited[i] = true;
                        queue.add(new Node(i, count + 1));
                    }
                }
            }

            if(queue.isEmpty()) {
                endDist = count;
            }
        }
    }
    static class Node{
        int nodeNum, count;

        public Node(int nodeNum, int count) {
            this.nodeNum = nodeNum;
            this.count = count;
        }
    }
}
