package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_1258_FindMatrix {
    static class SubMatrix implements Comparable<SubMatrix>{
        int row, col;

        public SubMatrix(int row, int col) {
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(SubMatrix o) {
            if((this.row * this.col) == (o.row * o.col))
                return this.row - o.row;
            else return (this.row * this.col) - (o.row * o.col);
        }
    }
    static int T, N, matrixCnt;
    static int matrix[][];
    static boolean visited[][];
    static ArrayList<SubMatrix> matrixArr;// = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());

        for(int tc = 1; tc <= T; tc++){
            matrixCnt= 0;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            matrix = new int[N][N];
            visited = new boolean[N][N];
            matrixArr = new ArrayList<>();
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    matrix[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N; i++){
                for(int j = 0; j < N; j++){
                    if(!visited[i][j] && matrix[i][j] != 0){ // 부분 행렬 찾기
                        findSubMatrix(i, j);
                    }
                }
            }
            Collections.sort(matrixArr);
            System.out.print("#" + tc + " " + matrixCnt);
            for (SubMatrix temp : matrixArr) {
                System.out.print(" " + temp.row + " " + temp.col);
            }
            System.out.println();
        }
    }

    private static void findSubMatrix(int y, int x) {
        matrixCnt++;
        int ny = y;
        int nx = x;
        int colCnt = 0;
        for(; matrix[ny][nx] != 0; ny++){ // 부분 행렬 visit체크
            while(matrix[ny][nx] != 0){
                visited[ny][nx] = true;
                nx++;
            }
            colCnt = nx - x; // 부분 행렬 열 길이
            nx = x;
        }
        matrixArr.add(new SubMatrix(ny - y, colCnt));
    }
}
