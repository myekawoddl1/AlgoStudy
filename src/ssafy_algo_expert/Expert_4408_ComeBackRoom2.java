package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_4408_ComeBackRoom2 {
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int tc = Integer.parseInt(st.nextToken());

        for(int t = 1; t <= tc; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int curRoom[] = new int[N + 1];
            int targetRoom[] = new int[N + 1];
            int dpRoomNo[]= new int [2 * N + 1];
            int dpCount[]= new int [2 * N + 1];
            for(int i = 1, j = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()), b =Integer.parseInt(st.nextToken());

                curRoom[i] = a < b ? a : b;
                dpRoomNo[j++] = curRoom[i];
                targetRoom[i] = a < b ? b : a;
                dpRoomNo[j++] = targetRoom[i];
            }
            //System.out.println(Arrays.toString(dpRoomNo));

            for(int i = 1; i <= N; i++){
                if(curRoom[i] % 2 == 0){
                    curRoom[i]--;
                }
                if(targetRoom[i] % 2 == 1){
                    targetRoom[i]++;
                }
                for(int j = 1; j <= 2*N; j++){
                    if(curRoom[i] <= dpRoomNo[j] && dpRoomNo[j] <= targetRoom[i]){
                        dpCount[j]++;
                    }
                    // System.out.println(Arrays.toString(dpCount));
                }
                // System.out.println();
            }

            Arrays.sort(dpCount);

            System.out.println("#" + t + " " + dpCount[2*N]);
        }
    }
}
