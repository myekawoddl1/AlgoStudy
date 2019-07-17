package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Baek_11652_Card {
    static int N, max = 1;
    static long cardNum, maxIndex;
    static HashMap<Long, Integer> card = new HashMap<>();
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            card.clear();
            maxIndex = 1;
            st = new StringTokenizer(br.readLine());
            cardNum = Long.parseLong(st.nextToken());
            if(!card.containsKey(cardNum)){
                card.put(cardNum, 1);
            } else{
                int a = card.get(cardNum);
                card.replace(cardNum, a + 1);
                if(max < a + 1){
                    max = a + 1;
                    maxIndex = cardNum;
                }else if(max == a + 1){
                    maxIndex = Math.min(maxIndex, cardNum);
                }
            }
        }
        System.out.println(maxIndex);

    }
}
