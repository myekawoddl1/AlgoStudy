package ssafy_algo_expert;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_5213_JinsuOddEven {
    static long oddDivisorSum[] = new long[1000001];
    static int T, L, R;
    static long ans;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        // 시간초과 1
        /*for(int i = 1; i <= 1000000; i++){
            int sum = 0;
            for(int j = 1; j <= i; j += 2){
                if(i % j == 0) sum += j;
            }
            oddDivisorSum[i] = sum;
        }*/

        // oddDivisorSum[i] 는 i의 홀수 약수의 합 -> 시간초과 2
        for(long i = 1; i <= 1000000; i += 2){
            for(long j = 1; j * i <= 1000000; j++){
                oddDivisorSum[(int) (i * j)] += i;
            }
        }
        // oddDivisorSum[i] 는 oddDivisorSum[1]부터 oddDivisorSum[i]까지의 합
        for(int i = 1; i <= 1000000; i++){ // 합들을 미리 구해보자
            oddDivisorSum[i] += oddDivisorSum[i - 1];
        }

        /*for(int test = 0; test < 11; test++){
            System.out.println(oddDivisorSum[test]);
        }*/

        for(int tc = 1; tc <= T; tc++){
            ans = 0;
            st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());

            // 시간초과 2
            /*for(int i = L; i <= R; i++){
                ans += oddDivisorSum[i];
            }*/

            ans = oddDivisorSum[R] - oddDivisorSum[L - 1];

            System.out.println("#" + tc + " " + ans);
        }

    }
}
