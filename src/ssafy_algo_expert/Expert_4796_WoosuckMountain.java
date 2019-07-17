package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_4796_WoosuckMountain {
    static int T, N, ans;
    static int[] mountain;
    public static void main(String[] args) throws IOException {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());*/
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        for(int tc = 1; tc <= T; tc++){
            ans = 0;
            /*st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());*/
            N = sc.nextInt();
            mountain = new int[N];
            // st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++){
                // mountain[i] = Integer.parseInt(st.nextToken());
                mountain[i] = sc.nextInt();
            }

            go();

            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void go() {
        int i = 0;
        while(i < N) {
            int h = mountain[i];
            boolean upFlag = true;
            int upCnt = 1, downCnt = 0;

            for (int j = i + 1; j < N; j++) {
                if (upFlag) { // 올라갈 때
                    if (h < mountain[j]) {
                        h = mountain[j];
                        upCnt++;
                    } else {
                        upFlag = false;
                        h = mountain[j];
                        upCnt--;
                        downCnt++;
                    }
                } else { // 내려갈 때
                    if (h > mountain[j]) {
                        h = mountain[j];
                        downCnt++;
                    } else {
                        break;
                    }
                }
            }

            ans += upCnt * downCnt;

            i += upCnt + downCnt;
        }
    }
}
