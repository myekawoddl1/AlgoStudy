package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_11722_LDS {
    static int N;
    static int[] sequence = new int[1000];
    static int[] count = new int[1000];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sequence[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < N; i++){
            count[i] = 1;
            for(int j = 0; j < i; j++){
                if(sequence[i] < sequence[j] && count[j]+1 > count[i])
                    count[i] = count[j] + 1;
            }
        }
        int result = count[0];
        for(int i = 0; i < N; i++){
            if(count[i] > result)
                result = count[i];
        }
        System.out.println(result);
    }
}
