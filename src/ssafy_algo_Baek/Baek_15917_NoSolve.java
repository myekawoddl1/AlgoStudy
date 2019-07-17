package ssafy_algo_Baek;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLOutput;
import java.util.StringTokenizer;

public class Baek_15917_NoSolve {
    static int Q;
    static int arr[] = new int[32];

    public static void main(String[] args) throws IOException {
        arr[0] = 1;
        for(int i = 1; i < 32; i++){
            arr[i] = arr[i - 1] * 2;
        }
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        Q = Integer.parseInt(st.nextToken());
        for(int i = 0; i < Q; i++){
            boolean isExist = false;
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            for(int j = 0; j < 32; j++){
                if(arr[j] == a) {
                    isExist = true;
                    break;
                }
            }
            if(isExist) System.out.println(1);
            else System.out.println(0);
        }
    }
}
