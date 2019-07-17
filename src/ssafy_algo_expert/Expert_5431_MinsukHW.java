package ssafy_algo_expert;

import java.util.Scanner;

public class Expert_5431_MinsukHW {
	static int T, Tcount, N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while(Tcount < T) {
			Tcount++;
			N = sc.nextInt();
			K = sc.nextInt();
			boolean student[] = new boolean[N + 1];
			
			for(int i = 0; i < K; i++){
				student[sc.nextInt()] = true; 
			}
			System.out.print("#" + Tcount + " ");
			for(int i = 1; i <= N; i++) {
				if(!student[i]) System.out.print(i + " ");
			}
			System.out.println();
		}

	}

}
