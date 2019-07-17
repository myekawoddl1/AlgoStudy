package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_3074_Immigration {
    static int T, N, M, ans;
    static int time[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            time = new int[N];
            long max = 0;
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                time[i] = Integer.parseInt(st.nextToken());
                if(max < time[i]) max = time[i];
            }

            long low = 0;
            long high = max * M;
            while (low <= high) {
                long mid = (low + high) / 2L;
                long cnt = 0L;
                for(int i = 0; i < N; i++){
                    cnt += mid / time[i];
                }
                if(cnt >= M){
                    high = mid - 1;
                }else{
                    low = mid + 1;
                }
            }
            System.out.println("#" + tc + " " + low);
        }
    }
}