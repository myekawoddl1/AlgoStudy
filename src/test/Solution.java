package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Integer.parseInt(st.nextToken());

        LinkedList<Long> arr = new LinkedList<>();
        for (long i = 1; i * i <= N; i++) {
            if (N % i == 0) {
                arr.add(i);
                if (i != N / i) arr.add(N / i);
            }
        }

        Collections.sort(arr);

        if (arr.size() % 2 == 1)
            System.out.println(0);
        else {
            int sz = arr.size();
            System.out.println(arr.indexOf(sz/2) - arr.indexOf((sz/2)-1));
        }
    }
}
