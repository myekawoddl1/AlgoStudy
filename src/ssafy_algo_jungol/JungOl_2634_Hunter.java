package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class JungOl_2634_Hunter {
    static int N, M, L;
    static int hunterCoord[];
    static int animalCoord[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        hunterCoord = new int[M];
        animalCoord = new int [N][2];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            hunterCoord[i] = Integer.parseInt(st.nextToken());
        }
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            animalCoord[i][0] = Integer.parseInt(st.nextToken());
            animalCoord[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(hunterCoord);
        // System.out.println(Arrays.toString(hunterCoord));
        Arrays.sort(animalCoord, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

      /*  for(int i = 1; i <= N; i++){
            System.out.println(animalCoord[i][0] + " " + animalCoord[i][1]);
        }*/
        int ans = 0;
        int index = 0;
        for(int i = 0; i < N; i++){ // 동물

            while(index < M - 1 && hunterCoord[index + 1] < animalCoord[i][0]){
                index++;
            }
            if(Math.abs(hunterCoord[index] - animalCoord[i][0]) + animalCoord[i][1] <= L){
                ans++;
                continue;
            }
            if(index < M - 1 && Math.abs(hunterCoord[index + 1] - animalCoord[i][0]) + animalCoord[i][1] <= L){
                ans++;
                continue;
            }

        }
        System.out.println(ans);
    }
}
