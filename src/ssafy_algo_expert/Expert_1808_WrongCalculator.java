package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_1808_WrongCalculator {
    static int T, X, ans;
    static boolean[] numArr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            ans = Integer.MAX_VALUE;
            numArr = new boolean[10];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 10; i++){
                int a = Integer.parseInt(st.nextToken());
                if(a == 1){
                    numArr[i] = true;
                }
            }
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());
            ans = go(X);
            if(ans == -1) ans = -2;
            System.out.println("#" + tc + " " + (ans + 1));
        }
    }

    static int go(int x) {
        int min = Integer.MAX_VALUE;
        for(int i = 2 ; i * i <= x ; ++i) {
            int a = x % i;
            if(a == 0) {
                int num = pushPossible(i);
                if(num != -1) {
                    int sub = go(x/i);
                    if(sub != -1)
                        min = (min > (sub + num + 1)) ? (sub + num + 1) : min;
                }
            }
        }

        int a = pushPossible(x);

        if(min==Integer.MAX_VALUE) {
            return (a != -1)? a : -1;
        }
        else
            return (a != -1 && a < min)? a : min;
    }

    static int pushPossible(int a) {
        if(a < 10)
            return (numArr[a] == true) ? 1 : -1;

        else {
            int num = a % 10;
            if(numArr[num]) {
                int b = pushPossible(a / 10);
                if(b != -1)
                    return b+1;
                else
                    return -1;
            }
            else
                return -1;
        }
    }
}
