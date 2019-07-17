package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Expert_1240_BinaryPassword {
    static HashMap<String, Integer> map;//
    static int tc, N, M, startRow, startCol, endRow, endCol;
    static char [][]arr;
    static int []password = new int [9];
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input1240ex.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tc = Integer.parseInt(st.nextToken());
        map = new HashMap<String, Integer>();
        map.put("0001101", 0);
        map.put("0011001", 1);
        map.put("0010011", 2);
        map.put("0111101", 3);
        map.put("0100011", 4);
        map.put("0110001", 5);
        map.put("0101111", 6);
        map.put("0111011", 7);
        map.put("0110111", 8);
        map.put("0001011", 9);


        for(int testCase = 1; testCase <= tc; testCase++) {
            startRow = 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            arr = new char [N][M];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i] = st.nextToken().toCharArray();
            }

       /*     for(int i = 0; i < N; i++) {
                System.out.println(Arrays.toString(arr[i]));
            }*/

            boolean find = false;
            for(int i = N - 1; i >= 0 && !find; i--) {
                for(int j = M - 1; j >= 0; j--) {
                    if(arr[i][j] == '1') {
                        endRow = i;
                        endCol = j;
                        startCol = j - 55;
                        find = true;
                        break;
                    }
                }
            }

            for(int i = endRow; i >= 0; i--) {
                if(arr[i][endCol] == '0') {
                    startRow = i + 1;
                    break;
                }
            }
            // 암호 코드 범위 찾기 끝


           // System.out.println(startRow + " " + startCol + " "  + endRow + " "  + endCol);

            /* for(int i = startRow; i <= endRow; i++) {
                for(int j = startCol; j <= endCol; j++) {
                    System.out.print(arr[i][j]);
                }
                System.out.println();
            }*/

            String pattern = null;
            StringBuilder sb = new StringBuilder(new String(arr[startRow],startCol,56));
            // System.out.println(sb);
            for(int i = 0, j = 1; i < 56; i += 7, j++){
                pattern = sb.substring(i, i + 7);
               // System.out.println(map.get(pattern));
                password[j] = map.get(pattern);
            }
            int code = ((password[1] + password[3] + password[5] + password[7]) * 3) + password[2] + password[4] + password[6]  + password[8];
            if(code % 10 == 0){
                int answer = 0;
                for(int i = 1; i <= 8; i++){
                    answer += password[i];
                }
                System.out.println("#" + testCase + " " + answer);
            }else {
                System.out.println("#" + testCase + " " + 0);
            }

        }
    }
}
