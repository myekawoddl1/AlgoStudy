package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2443_Star6 {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        for(int i = N; i >= 1; i--){
            for(int j = N - 1; j >= i; j--){
                System.out.print(" ");
            }
            for(int j = 1; j <= i * 2 - 1; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
