package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Baek_15656_NandM7 {
    static int N, M;
    static int arr[];
    static int tempArr[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int [N];
        tempArr = new int [N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        permutation(0, M);
        System.out.println(sb);
    }

    private static void permutation(int index, int m) {
        if(index == m){
            for(int i = 0; i < m; i++){
                sb.append(tempArr[i] + " ");
            }
            sb.append("\n");
            return;
        }

        for(int i = 0; i < N; i++){
            tempArr[index] = arr[i];
            permutation(index + 1, m);
        }

    }
}
