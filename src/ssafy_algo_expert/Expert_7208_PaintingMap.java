package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_7208_PaintingMap {
    static int T, N, ans;
    static int[][] adjMatrix;
    static int[] colorArr;
    static int[] initColor;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            ans = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());

            adjMatrix = new int[N][N];
            initColor = new int[N];
            colorArr = new int[N];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                initColor[i] = Integer.parseInt(st.nextToken());
                initColor[i]--;
            }
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    adjMatrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            mColoring(0);
            System.out.println("#" + tc + " " + ans);

        }
    }
    static void mColoring (int i){
        int color ;

        if (promising(i)) { // 현재 선택한 컬러가 답이 될 가능성이 있는가?
            if (i == N - 1) {
               /* for(int k = 0; k < N; k++){
                    System.out.print(colorArr[k] + " ");
                }
                System.out.println();*/
                int cnt = 0;
                for(int k = 0; k < N; k++){
                    if(initColor[k] != colorArr[k]){
                        cnt++;
                    }
                }
                ans = Math.min(ans, cnt);
            } else { //다음 정점에 모든 색을 시도해 본다
                for (color = 0; color < 4; color++) {
                    colorArr[i + 1] = color;
                    mColoring(i + 1);
                }
            }
        }
    }
    static boolean promising (int i) {
        int j;
        boolean sw = false;
        sw = true;
        j = 0 ;
        while (j < i && sw) { // 인접한 정점에 이 색이 이미 칠해져 있는지 점검한다
            if (adjMatrix[i][j] == 1 && colorArr[i] == colorArr[j] )
                sw = false;
            j++;
        }
        return sw;
    }
}
