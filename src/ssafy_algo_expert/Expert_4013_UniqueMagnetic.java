package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_4013_UniqueMagnetic {
    static int T, K, ans;
    static int[] isRotate;
    static int[][] magnet;
    static int[][] rotation;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            ans = 0;
            isRotate = new int[5];
            magnet = new int[5][8];
            st = new StringTokenizer(br.readLine());
            K = Integer.parseInt(st.nextToken());
            rotation = new int[K][2];
            for(int i = 1; i <= 4; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 8; j++){
                    magnet[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < K; i++){
                st = new StringTokenizer(br.readLine()); // [k][0] == 톱니번호, [k][1] == 회전방향
                rotation[i][0] = Integer.parseInt(st.nextToken());
                rotation[i][1] = Integer.parseInt(st.nextToken()); // 1 == 시계방향, -1 == 반시계방향
            }
            go();
            for(int i = 1; i <= 4; i++){
                ans += magnet[i][0] * Math.pow(2, i - 1);
            }
            System.out.println("#" + tc+ " " + ans);
        }
    }

    private static void go() {
        for(int i = 0; i < K; i++){
            isRotate = new int[5];
            int magnetNum = rotation[i][0];
            int dirRotate = rotation[i][1];

            isRotate[magnetNum] = dirRotate;
            for(int mm = magnetNum - 1; mm > 0; mm--){
                if(magnet[mm][2] == magnet[mm + 1][6]){break;}
                isRotate[mm] = isRotate[mm + 1] * -1;
            }
            for(int mm = magnetNum + 1; mm <= 4; mm++){
                if(magnet[mm - 1][2] == magnet[mm][6]){break;}
                isRotate[mm] = isRotate[mm - 1] * -1;
            }

            roatateCheck();
            System.out.println((i + 1) + "회전");
            print();
        }
    }

    private static void roatateCheck() {
        for(int i = 1; i <= 4; i++){
            if(isRotate[i] == 0) continue;
            else rotateMagnet(i, isRotate[i]);
        }
    }

    private static void rotateMagnet(int mNum, int dirR) {
        if(dirR == 1){ // 시계방향 회전
            int temp = magnet[mNum][7];
            for(int i = 7; i > 0; i--)
                magnet[mNum][i] =magnet[mNum][i - 1];
            magnet[mNum][0] = temp;
        }else{ // 반시계방향 회전
            int temp = magnet[mNum][0];
            for(int i = 0; i < 7; i++)
                magnet[mNum][i] =magnet[mNum][i + 1];
            magnet[mNum][7] = temp;
        }
    }

    public static void print(){
        for(int i = 1; i <= 4; i++){
            for(int j = 0; j <= 7; j++){
                System.out.print(magnet[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
