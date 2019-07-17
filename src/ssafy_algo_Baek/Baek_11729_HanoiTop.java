package ssafy_algo_Baek;

import java.util.Scanner;

public class Baek_11729_HanoiTop {
	static StringBuilder sb = new StringBuilder();
	static int N, count;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		hanoi(1, 2, 3, N);
		System.out.println(count);
		System.out.println(sb);
	}

	static void hanoi(int from, int by, int to, int N) {
		count++;
		if(1 == N) {
			sb.append(from + " " + to + "\n");
			return;
		}
		hanoi(from, to ,by, N - 1);
		sb.append(from + " " + to + "\n");
		hanoi(by, from, to, N - 1);
		/* 
		 *        1     2    3
		 * n-1 : from   to   by
		 * n   : from   by   to
		 * n-1 :  by   from  to
		 * 
		 * 
		 */
	}

}
