package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert_4408_ComeBackRoom {
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
            int dpCount[]= new int [401];
            for(int i = 1; i <= N; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()), b =Integer.parseInt(st.nextToken());

                curRoom[i] = a < b ? a : b;
                targetRoom[i] = a < b ? b : a;
            }
            // System.out.println(Arrays.toString(dpRoomNo));

            for(int i = 1; i <= N; i++){
                for(int j = curRoom[i]; j <= targetRoom[i]; j++){
                    dpCount[j]++;
                }
                if(curRoom[i] % 2 == 0){
                    dpCount[curRoom[i] - 1]++;
                }
                if(targetRoom[i] % 2 == 1){
                    dpCount[targetRoom[i] + 1]++;
                }
            }

            Arrays.sort(dpCount);

            System.out.println("#" + t + " " + dpCount[400]);
        }
    }
}
