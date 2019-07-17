package ssafy_algo_jungol;

import com.sun.xml.internal.bind.v2.runtime.output.SAXOutput;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class JungOl_2097_Subway {
    static int dist[]; /// 출발지로부터 최단거리를 저장할 배열
    static int path[], visit[]; /// 경로, 방문 체크
    static int N, M, INF = 999999;
    static int adjMatrix[][];
    public static void main(String[] args) throws IOException {
        // System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        adjMatrix = new int[N + 1][N + 1];
        dist = new int[N + 1];
        path = new int[N + 1];
        visit = new int[N + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= N; j++){
                adjMatrix[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        Dijkstra();

        System.out.println(Arrays.toString(path));
        System.out.println(dist[M]);
        pathPrint(M);
        System.out.println(M);

    }
    static void Dijkstra(){
        for (int i = 1; i <= N; i ++) dist[i] = INF; /// init dist
        dist[1] = 0; /// init dist[시작점]
        for (int i = 1; i <= N; i ++){
            int minNode = 0, minVal =INF;
            for (int j = 1; j <= N; j ++){
                if(visit[j] == 0 && minVal > dist[j]){
                    minNode = j;
                    minVal = dist[j];
                }
            }
            visit[minNode] = 1;
            for (int j = 1; j <= N; j ++){
                if(dist[j] > minVal + adjMatrix[minNode][j]){
                    dist[j] = minVal + adjMatrix[minNode][j];
                    path[j] = minNode;
                }

            }
        }
    }
    static void pathPrint(int e) {
        if (path[e] == 0)  return;
        pathPrint(path[e]);
        System.out.print(path[e] + " ");
        //pathPrint(e);
    }
}
