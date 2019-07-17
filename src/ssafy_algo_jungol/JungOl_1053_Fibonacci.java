package ssafy_algo_jungol;

import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class JungOl_1053_Fibonacci {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int n = sc.nextInt();
            if (n == -1) return;
            if (n == 0)
            {
                System.out.println(0);
                continue;
            }

            int[][] res = { { 1, 0 }, { 0, 1 } };
            int[][] a = { { 1, 1 }, { 1, 0 } };
            while (n > 1) {
                if (n % 2 == 1) {
                    res = matrix(res, a);
                }
                a = matrix(a, a);
                n /= 2;
            }
            res = matrix(res, a);
            System.out.println(res[0][1]);

        }

    }

    public static int[][] matrix(int[][] ary1, int[][] ary2) {
        int[][] temp = new int[2][2];

        temp[0][0] = (ary1[0][0] * ary2[0][0] + ary1[0][1] * ary2[1][0]) % 10000;
        temp[0][1] = (ary1[0][0] * ary2[0][1] + ary1[0][1] * ary2[1][1]) % 10000;
        temp[1][0] = (ary1[1][0] * ary2[0][0] + ary1[1][1] * ary2[1][0]) % 10000;
        temp[1][1] = (ary1[1][0] * ary2[0][1] + ary1[1][1] * ary2[1][1]) % 10000;

        return temp;
    }
}
