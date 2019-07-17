package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_10250_ACMHotel {
    static int T, H, W, N, roomNum, floor;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int tc = 1; tc <= T; tc++){
            st = new StringTokenizer(br.readLine());
            H = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            floor = N % H;
            roomNum = N / H;
            if (floor == 0) {
                floor = H;
            }
            else {
                roomNum++;
            }
            if (roomNum < 10) {
                floor *= 10;
            }
            System.out.println(floor + "" + roomNum);
        }
    }

}
