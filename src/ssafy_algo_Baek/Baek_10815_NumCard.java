package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Baek_10815_NumCard {
    static int N, M;
    static int card[];
    static int ans[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        card  = new int[N];
        for(int i = 0; i < N; i++){
            card[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(card);
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        ans = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < M; i++){
            int num = Integer.parseInt(st.nextToken());
            int mid = 0;
            int low = 0;
            int high = N;
            while(low < high){
                mid = (low + high) / 2;

                if(card[mid] == num) {
                    ans[i] = 1;
                    break;
                }

                if(card[mid] >= num){
                    high = mid;
                }else{
                    low = mid + 1;
                }
            }
        }

        for(int i = 0; i < M - 1; i++){
            System.out.print(ans[i] + " ");
        }
        System.out.println(ans[M - 1]);
    }
}
