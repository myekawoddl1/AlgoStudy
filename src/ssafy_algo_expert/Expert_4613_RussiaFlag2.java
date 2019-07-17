package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_4613_RussiaFlag2 {
    static int T, N, M, ans;
    static char[][] flag;
    static int[][] colorCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            flag = new char [N][M];
            colorCnt = new int [N][3];

            for(int i = 0; i < N; i++){
                if(i != 0){
                    for(int j = 0; j < 3; j++){
                        colorCnt[i][j] = colorCnt[i - 1][j];
                    }
                }
                st = new StringTokenizer(br.readLine());
                flag[i] = st.nextToken().toCharArray();
                for(int j = 0; j < M; j++){
                    if(flag[i][j] == 'W'){
                        colorCnt[i][0]++; // W
                    }else if(flag[i][j] == 'B'){
                        colorCnt[i][1]++; // B
                    }else{
                        colorCnt[i][2]++; // R
                    }
                }
            }
            int max = 0;
            for(int i = 0; i < N - 2; i++){
                for(int j = i + 1;j < N - 1; j++){
                    int cnt = colorCnt[i][0] + colorCnt[N - 1][2] - colorCnt[i][1] + colorCnt[j][1] - colorCnt[j][2];
                    if(cnt > max){
                        max = cnt;
                    }
                }
            }
            sb.append("#" + tc + " " + (N * M - max) + "\n");
        }
        System.out.println(sb);
    }
}
