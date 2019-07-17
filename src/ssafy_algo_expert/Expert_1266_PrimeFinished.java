package ssafy_algo_expert;

/*
input

10
0 0
80 90
10 20
1 2
100 100
60 23
70 23
80 32
90 32
100 32

output

#1 0.000000
#2 0.503684
#3 0.783308
#4 0.062194
#5 0.000000
#6 0.716983
#7 0.721214
#8 0.612473
#9 0.642099
#10 0.471369
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_1266_PrimeFinished {
    static double tc, answer, pA, pB, pAFail, pBFail;
    static int r[] = {2, 3, 5, 7, 11, 13, 17};
    static int nCr[]; // = {153, 816, 8568, 31824, 31824, 8568, 18};
    static int n = 18;
    /*
        18 C 2 = 153
        18 C 3 = 816
        18 C 5 = 8568
        18 C 7 = 31824
        18 C 11 = 31824
        18 C 13 = 8568
        18 C 17 = 18

        nCr P^r(1-P)^(n-r)
     */

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tc = Integer.parseInt(st.nextToken());

        nCr = new int [r.length];
        for(int i = 0; i < r.length; i++){
            nCr[i] = comb(18,r[i]);
        }

        for(int testCase = 1; testCase <= tc; testCase++) {
            st = new StringTokenizer(br.readLine());
            pA = Double.parseDouble(st.nextToken());//
            pB = Double.parseDouble(st.nextToken());//
            pAFail = 100d - pA;
            pBFail = 100d - pB;

            pA /= 100d;
            pB /= 100d;
            pAFail /= 100d;
            pBFail /= 100d;
            double sumA = 0;
            double sumB = 0;
            for(int i = 0; i < r.length; i++){
                sumA += nCr[i] * Math.pow(pA,r[i]) * Math.pow(pAFail, n-r[i]);
                sumB += nCr[i] * Math.pow(pB,r[i]) * Math.pow(pBFail, n-r[i]);
            }
            answer = sumA + sumB - (sumA * sumB);
            //System.out.println(sumA + " llll " + sumB);


            // System.out.println(pA + " " + pAFail + " " + pB + " " + pBFail);
            // 소수 2 3 5 7 11 13 17
            System.out.println("#" + testCase + " " + String.format("%.6f",answer));
        }
    }
    public static int comb(int n, int r){
        int num = 1;
        for(int i = 1; i <= r; i++){
            num *= n - i + 1;
            num /= i;
        }
        return num;
    }

}
