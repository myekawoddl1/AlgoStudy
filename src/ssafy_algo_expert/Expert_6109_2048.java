package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_6109_2048 {
    static String command;
    static int T, N, ans;
    static int[][] map;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            command = st.nextToken();
            map = new int[N + 1][N + 1];

            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            LinkedList<Integer> list =  new LinkedList<>();

            if(command.equals("left")){
                for(int i = 0; i < N; i++){
                    list.clear();
                    for(int j = 0; j < N; j++) {
                        if (map[i][j] == 0) continue;
                        list.add(map[i][j]);
                        map[i][j] = 0;
                    }
                    for(int idx = 0; !list.isEmpty();) {
                        int a = list.poll();
                        map[i][idx] = a;
                        if(list.isEmpty()) break;
                        int b = list.peek();
                        if(a == b) {
                            map[i][idx] += b;
                            idx++;
                            list.poll();
                            continue;
                        }
                        idx++;
                    }
                }
            }else if(command.equals("right")){
                for(int i = 0; i < N; i++){
                    list.clear();
                    for(int j = N - 1; j >= 0; j--){
                        if (map[i][j] == 0) continue;
                        list.add(map[i][j]);
                        map[i][j] = 0;
                    }
                    for(int idx = N - 1; !list.isEmpty();) {
                        int a = list.poll();
                        map[i][idx] = a;
                        if(list.isEmpty()) break;
                        int b = list.peek();
                        if(a == b) {
                            map[i][idx] += b;
                            idx--;
                            list.poll();
                            continue;
                        }
                        idx--;
                    }
                }
            }else if(command.equals("up")){
                for(int j = 0; j < N; j++){
                    list.clear();
                    for(int i = 0; i < N; i++){
                        if (map[i][j] == 0) continue;
                        list.add(map[i][j]);
                        map[i][j] = 0;
                    }
                    for(int idx = 0; !list.isEmpty();) {
                        int a = list.poll();
                        map[idx][j] = a;
                        if(list.isEmpty()) break;
                        int b = list.peek();
                        if(a == b) {
                            map[idx][j] += b;
                            idx++;
                            list.poll();
                            continue;
                        }
                        idx++;
                    }
                }
            }else if(command.equals("down")){
                for(int j = 0; j < N; j++){
                    list.clear();
                    for(int i = N - 1; i >= 0; i--){
                        if (map[i][j] == 0) continue;
                        list.add(map[i][j]);
                        map[i][j] = 0;
                    }
                    for(int idx = N - 1; !list.isEmpty();) {
                        int a = list.poll();
                        map[idx][j] = a;
                        if(list.isEmpty()) break;
                        int b = list.peek();
                        if(a == b) {
                            map[idx][j] += b;
                            idx--;
                            list.poll();
                            continue;
                        }
                        idx--;
                    }
                }
            }
            sb.append("#" + tc + "\n");
            for(int i = 0; i < N; i++){
                for(int j = 0; j < N - 1; j++){
                    sb.append(map[i][j] + " ");
                }
                sb.append(map[i][N - 1] + "\n");
            }
        }
        System.out.println(sb);
    }
}
