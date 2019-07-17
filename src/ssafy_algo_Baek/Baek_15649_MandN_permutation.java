package ssafy_algo_Baek;

import java.util.Scanner;

public class Baek_15649_MandN_permutation {
	static int N, arr[];
	static boolean selected[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		selected = new boolean[N + 1];
		arr = new int[N];
		for(int i = 1; i <= N; i++) {
			arr[i - 1] = i;
		}
		int R = sc.nextInt();
		// N permu R : N개 중에 R개를 뽑아서 순열
		// permutation(순열 뽑을 배열, 0, 배열의 크기, 선택할 갯수);
		permutation(0, R);
	}
	static void permutation(int index, int r) {
		if(index == r) {
			for (int i = 0; i < r; i++) {
				System.out.print(arr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// 1부터 N 까지 시도
		for(int i = 1; i <= N; i++) {
			if(!selected[i]) {
				arr[index] = i;
				selected[i] = true;
				permutation(index + 1, r);
				selected[i] = false;
			}
		}
		
	}

}
