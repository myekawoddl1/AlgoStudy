package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Expert_5672_TrainerOfTheYear {
    static int T, N;
    static String ans;
    static LinkedList<Character> name;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            name = new LinkedList<>();
            for(int i = 0; i < N; i++){
                st = new StringTokenizer(br.readLine());
                name.offer(st.nextToken().charAt(0));
            }
            String str = "";
            go(str);
            
            System.out.println("#" + tc + " " + ans);
        }
    }

    private static void go(String s) {
        if(s.length() == N){
            ans = s;
            return;
        }

        if(name.get(0) < name.get(name.size() - 1)){
            s += name.poll();
        }else if(name.get(0) > name.get(name.size() - 1)){
            s += name.pollLast();
        }else{
            int first = 0;
            int last = name.size() - 1;
            int addFirst = 0;
            while(first < last){
                addFirst = name.get(++first) - name.get(--last);
                if(addFirst != 0) break;
            }
            if(addFirst < 0){
                s += name.poll();
            }else{
                s += name.pollLast();
            }
        }
        go(s);
    }
}
