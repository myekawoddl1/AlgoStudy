package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_6485_BusRoute {
    static int T, N, P;
    static int arrA[], arrB[], arrP[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++){
            arrP = new int[5001];
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arrA = new int[N];
            arrB = new int[N];
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                arrA[i] = Integer.parseInt(st.nextToken());
                arrB[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            P = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < P; i++){
                st = new StringTokenizer(br.readLine());
                int point = Integer.parseInt(st.nextToken());
                if(arrP[point] != 0){
                    sb.append(" " + arrP[point]);
                    continue;
                }
                int count = 0;
                for(int j = 0; j < N; j++){
                    if(arrA[j] <= point && point <= arrB[j]){
                        count++;
                    }
                }
                arrP[point] = count;
                sb.append(" " + arrP[point]);
            }

            System.out.println("#" + tc + sb);
        }
    }
}
