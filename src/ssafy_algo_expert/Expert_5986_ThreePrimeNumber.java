package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Expert_5986_ThreePrimeNumber {
    static int sumArr[] = new int [1000];
    static Integer[] primeArr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> primeList = new ArrayList<>();

        boolean isOK;
        for(int i = 2; i <= 1000; i++) {
            isOK = true;
            for(int j = 2; j <= (int)Math.sqrt(i); j++) { // i의 제곱근까지 루프
                if(i % j == 0) {
                    isOK = false;
                    break;
                }
            }
            if(isOK) primeList.add(i);
        }
        primeArr = primeList.toArray(new Integer [primeList.size()]);
        // System.out.println(Arrays.toString(primeArr));
        int tc = Integer.parseInt(st.nextToken());

        combination(0,0,0);

        for(int t = 1; t <= tc; t++){
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());

            System.out.println("#" + t + " " + sumArr[N]);
        }


    }
    private static void combination(int cnt, int sum, int index) {
        if(sum > 999) {
            return;
        }
        if(cnt == 3) {
            sumArr[sum]++;
            return;
        }
        for(int i = index; i < primeArr.length; i++) {
            combination(cnt + 1, sum + primeArr[i], i);
        }
    }
}
