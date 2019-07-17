package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
http://hochulshin.com/substring-sorting/

접미어 접두어수	LCP	누적 유효 부분 문자열 수
d		1	    0	    1
food	4	    0	    5
od		2	    0	    7
ood		3	    1	    9
 */
@SuppressWarnings("Duplicates")
public class Expert_1257_KthString {
    static int K, tc;
    static String str, suffixArray[];
    static int LCP[], subStringCnt;

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tc = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= tc; t++) {
            subStringCnt = 0;

            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            suffixArray = new String[str.length()];
            LCP = new int [str.length()];

            for (int i = 0; i < str.length(); i++){
                suffixArray[i] = str.substring(i);
            } // 접미어 배열

            // System.out.println(Arrays.toString(suffixArray));
            Arrays.sort(suffixArray); // 접미어 배열 정렬
            // System.out.println(Arrays.toString(suffixArray));

            for (int i = 1; i < str.length(); i++){
                String a = suffixArray[i - 1];
                String b = suffixArray[i];
                int j = 0;
                while (j < a.length() && j < b.length() && a.charAt(j) == b.charAt(j)){
                    j++; // 최장 공통 접두어 길이
                }
                LCP[i] = j;
            }
            // System.out.println(Arrays.toString(LCP));

            for(int i = 0; i < str.length(); i++){
                subStringCnt += suffixArray[i].length() - LCP[i];
                if(K <= subStringCnt){
                    System.out.println("#" + t + " " + suffixArray[i].substring(0, (suffixArray[i].length() - (subStringCnt - K))));
                    break;
                }
            }
            if(K > subStringCnt){
                System.out.println("#" + t + " none");
            }



        }
    }
}
