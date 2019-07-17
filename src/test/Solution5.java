package test;

import sun.misc.InnocuousThread;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Solution5 {
    static Boolean arr[][];//  = new Boolean[650][200001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new Boolean[651][200001];
        int cx = Integer.parseInt(st.nextToken());
        int bx = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 651; i++){
            Arrays.fill(arr[i], false);
        }
        int ans = 0;
        int bxMax = bx;
        arr[0][bx] = true;
        while(!arr[ans][cx]){
            ans++;
            cx = cx + ans;

            for(int i = 0; i <= bxMax; i++){
                if(arr[ans - 1][i]){
                    int ni = i + 1;
                    if(ni >= 0 && ni <= 200000) {
                        arr[ans][ni] = true;
                        bxMax = Math.max(ni, bxMax);
                    }
                    ni = i - 1;
                    if(ni >= 0 && ni <= 200000) {
                        arr[ans][ni] = true;
                    }
                    ni = i * 2;
                    if(ni >= 0 && ni <= 200000) {
                        arr[ans][ni] = true;
                        bxMax = Math.max(ni, bxMax);
                    }
                }
            }

        }
        System.out.println(ans);


    }
}
