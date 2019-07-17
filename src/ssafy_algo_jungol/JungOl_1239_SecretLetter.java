package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class JungOl_1239_SecretLetter {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        HashMap<String,String> list = new HashMap<>();
        list.put("000000","A");
        list.put("001111","B");
        list.put("010011","C");
        list.put("011100","D");
        list.put("100110","E");
        list.put("101001","F");
        list.put("110101","G");
        list.put("111010","H");

        boolean dontKnow = true;
        String x;
        String ans;
        StringBuilder sb = new StringBuilder();
        int size = N * 6;
        for(int i = 0;i < size; i += 6) {
            x = s.substring(i, i + 6);
            ans = list.get(x);
            if(ans == null) {
                dontKnow = true;
                for(String t:list.keySet()) {
                    int cnt = 0;
                    for(int j = 0; j < 6; j++) {
                        if(x.charAt(j) != t.charAt(j)) cnt += 1;
                        if(cnt > 1) break;
                    }
                    if(cnt == 1) {
                        dontKnow = false;
                        sb.append(list.get(t));
                        break;
                    }
                }
                if(dontKnow == true) {
                    System.out.println(i/6 + 1);
                    return;
                }
            }else sb.append(ans);
        }

        System.out.println(sb);
    }
}
