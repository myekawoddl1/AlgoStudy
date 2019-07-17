package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_3459_WinnerPrediction {
    static int T, winner, turn; // 0 == Alice , 1 == Bob
    static long x, N, depth;
    static String ans;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            x = 1;
            st = new StringTokenizer(br.readLine());
            N = Long.parseLong(st.nextToken());
            if(N == 1) winner = 1;
            else if(N <= 3) winner = 0;
            else{
                for(int i = 2; ; i++){
                    if(Math.pow(2, i) <= N && N < Math.pow(2, i + 1)){
                        depth = i;
                        break;
                    }
                }

                if(depth % 2 == 0) turn = 1; // 깊이가 짝수 == Bob이 만들 수 있는 수
                else turn = 0;// 깊이가 홀수 == Alice가 만들 수 있는 수

                if(turn == 1){
                    for(long i = 1; i <= depth - 1; i += 2){
                        x = x * 2 + 1; // A
                        x = x * 2; // B
                        if(i == depth - 1){
                            if(x <= N){
                                winner = 1;
                                break;
                            }else{
                                winner = 0;
                                break;
                            }
                        }
                    }
                } else{
                    for(long i = 1; i <= depth; i += 2){
                        x = x * 2; // A
                        if(i == depth){
                            if(x <= N){
                                winner = 0;
                                break;
                            }else{
                                winner = 1;
                                break;
                            }
                        }
                        x = x * 2 + 1; // B
                    }
                }
            }
            if(winner == 0) ans = "Alice";
            else ans = "Bob";

            System.out.println("#" + tc + " " + ans);
        }
    }

}
