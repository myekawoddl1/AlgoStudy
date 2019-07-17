package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Expert_1494_LoveCounsler {
    static long T, N, ans, cnt;
    static boolean[] selected;
    static ArrayList<Coord> arr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            ans = Long.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            selected = new boolean[(int) N];

            arr = new ArrayList<>();
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                arr.add(new Coord(y, x));
            }

            // System.out.println(arr);

            dfs(0);

            // System.out.println(vecX + " " + vecY);

            // ans = (vecX * vecX) + (vecY * vecY);

            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void dfs(int index) {
        cnt++;
        selected[index] = true;

        if(cnt == N / 2){
            go();
            selected[index] = false;
            cnt--;
            return;
        }

        for(int i = index + 1; i < N; i++){
            if(!selected[i]){

                dfs(i);
            }
        }
        selected[index] = false;
        cnt--;

    }

    private static void go() {
        long vecX = 0;
        long vecY = 0;
        for(int i = 0; i < N; i++){
            if(selected[i]){
                vecX += arr.get(i).x;
                vecY += arr.get(i).y;
            }else{
                vecX -= arr.get(i).x;
                vecY -= arr.get(i).y;
            }
        }
        long temp = (vecX * vecX) + (vecY * vecY);
        ans = temp < ans ? temp : ans;
    }

    static class Coord implements Comparable<Coord> {
        int y, x;
        int sum;

        public Coord(int y, int x) {
            this.y = y;
            this.x = x;
            this.sum = y + x;
        }

        @Override
        public int compareTo(Coord o) {
            return this.sum - o.sum;
        }

        @Override
        public String toString() {
            return "Coord{" +
                    "y=" + y +
                    ", x=" + x +
                    ", sum=" + sum +
                    '}';
        }
    }
}
