package ssafy_algo_expert;

import java.util.Scanner;

public class Expert_1289_Wonjae {

    static int T, TCount = 0, count;
    static String num;
    static char arr[];
    static boolean flag;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        while(TCount < T) {
            flag= false;
            count = 0;
            num = sc.next();
            num.length();
            arr = num.toCharArray();
            if(arr[num.length() - 1] == '0') count++;
            for (int i = num.length() - 1; i >= 0; i--) {
                if(arr[i] == '0') {
                    if(flag) count++;
                    flag = false;
                }else {
                    if(!flag) count++;
                    flag = true;
                }
            }
            if(!flag) count--;
            TCount++;
            System.out.println("#" + TCount + " " + count);
        }
    }
}