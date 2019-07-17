package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_2007_PatternMadi {
    static int tc, ans;
    static String str;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tc = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= tc; t++) {
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();
            for(int i = 1; i < 10; i++){
                String subStr = str.substring(0,i);
                String remainStr = str.substring(i,i+i);
                if(remainStr.equals(subStr)){
                    ans = i;
                    break;
                }
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}