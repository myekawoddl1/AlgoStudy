package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;
@SuppressWarnings("Duplicates")
public class Solution4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int arr[] = new int[N + 1];
        int arr2[] = new int[N + 1];
        for(int i = 1; i <= N; i++){
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }


        int curH = arr[1];
        int curL = 0;
        int startX = 1;
        for(int i = 2; i <= N; i++){
            if(arr[i] < curH){
                continue;
            }
            curL = Math.max(curL, i - startX);
            curH = arr[i];
            startX = i;
        }

        System.out.println(curL);

    }
}
