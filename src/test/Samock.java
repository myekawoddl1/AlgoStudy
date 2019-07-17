package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Samock {
    static int T, N, ans, turn; // turn 1 은 A 2 는 B
    static int APoint, BPoint;
    static int map[][];
    static int height[];
    static boolean isPossible;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            ans = 0;
            APoint = 0;
            BPoint = 0;
            isPossible = false;
            map = new int[102][6];
            height = new int[6];
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i ++){
                int x = Integer.parseInt(st.nextToken());

                if(i % 2 == 0){ // A 턴
                    turn = 1;
                    map[height[x]][x] = 1;
                    height[x]++;
                    go(turn);
                }else{ // B 턴
                    turn = 2;
                    map[height[x]][x] = 2;
                    height[x]++;
                    go(turn);
                }
            }

            ans = APoint - BPoint;
            if(ans < 0) ans *= -1;
            System.out.println(ans);
        }
    }

    private static void go(int turn) {
        while(true){
            int delBlock[][] = new int [102][2];

            for(int i = 0; i < N; i ++){
                int count = 1;
                for(int j = 1; j < 6; j++){
                    if(map[i][j] == 0 || map[i][j] == -1) count = 1;
                    else if(map[i][j] == map[i][j - 1]) count++;
                    else count = 1;

                    if(count >=4 ){
                        delBlock[i][0] = j - count + 1;
                        delBlock[i][1] = j;
                        isPossible = true;
                    }
                }
            }

            if(isPossible) deleteBlock(turn, delBlock);
            else break;
        }
    }

    private static void deleteBlock(int turn, int[][] delBlock) {
        for(int i = 0; i < N; i++){
            if(delBlock[i][1] == 0) continue;

            if(turn == map[i][delBlock[i][1]]){
                if(turn == 1){
                    APoint += delBlock[i][1] - delBlock[i][0] + 1;
                }else if(turn == 2){
                    BPoint += delBlock[i][1] - delBlock[i][0] + 1;
                }
            }

            for(int j = delBlock[i][0]; j <= delBlock[i][1]; j++){
                map[i][j] = -1;
            }
        }
        mapSetting();
        isPossible = false;
    }

    private static void mapSetting() {
        for(int j = 0; j < 6; j++){
            LinkedList<Integer> list = new LinkedList<>();
            for(int i = 0; i < N; i++){
                if(map[i][j] == 0 || map[i][j] == -1) continue;
                list.add(map[i][j]);
                map[i][j] = 0;
            }

            for(int i = 0; i < list.size(); i++){
                map[i][j] = list.get(i);
            }
            height[j] = list.size();
        }
    }
}
