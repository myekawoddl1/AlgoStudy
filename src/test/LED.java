package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class LED {
    static int T, N, ans;
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++) {
            ans = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            arr = new int[N + 1];
            st = new StringTokenizer(br.readLine());
            char temp[];// = new char[N];
            temp = st.nextToken().toCharArray();
            for(int i = 1; i <= N; i++){
                arr[i] = temp[i - 1] - '0';
            }
            //System.out.println(Arrays.toString(arr));
            for(int i = 1; i <= N; i++){
                if(arr[i] == 1){
                    ans++;
                    for(int j = i; j <= N; j += i){
                        if(arr[j] == 1) arr[j] = 0;
                        else if(arr[j] == 0) arr[j] = 1;
                    }
                }
            }

            System.out.println(ans);
        }
    }
}
