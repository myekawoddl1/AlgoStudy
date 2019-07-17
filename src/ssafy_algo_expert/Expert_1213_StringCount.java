package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_1213_StringCount {
    static int tc, ans, index; //, curIndex;
    static String str, targetStr;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        tc = 10;// = Integer.parseInt(st.nextToken());
        for(int t = 1; t <= tc; t++) {
            ans = 0;
            index = 0;
            // curIndex = 0;
            br.readLine();
            st = new StringTokenizer(br.readLine());
            targetStr = st.nextToken();
            st = new StringTokenizer(br.readLine());
            str = st.nextToken();

             find(0);

 /*           while(index < str.length()) {
                index = str.indexOf(targetStr, curIndex);

                if(index != -1){
                    ans++;
                    curIndex = index + targetStr.length();
                }else {
                    break;
                }
            }*/

             System.out.println("#" + t + " " + ans);
        }
    }

    public static void find(int curIndex){
        index = str.indexOf(targetStr, curIndex);
        if(index != -1){
            ans++;
            find(index + targetStr.length());
        }
    }
}
