package ssafy_algo_Baek;
import java.util.Scanner;

@SuppressWarnings("Duplicates")
public class Baek_10974_Permutation {
	static int N, arr[], tempArr[];
	static boolean selected[];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		selected = new boolean[N + 1];
		arr = new int[N];
		tempArr = new int[N];
		/*for(int i = 1; i <= N; i++) {
			arr[i - 1] = i;
		}*/
		arr[0] = 4;
		arr[1] = 5;
		arr[2] = 7;
		arr[3] = 8;
		// N permu R : N개 중에 R개를 뽑아서 순열
		// permutation(순열 뽑을 배열, 0, 배열의 크기, 선택할 갯수);
		permutation(0);
		// permutation(arr,0,N,4);
	}
	static void permutation(int index) {
		if(index == N) {
			for (int i = 0; i < N; i++) {
				System.out.print(tempArr[i] + " ");
			}
			System.out.println();
			return;
		}
		
		// 1???? N ???? ???
		for(int i = 1; i <= N; i++) {
			if(!selected[i]) {
				tempArr[index] = arr[i - 1];
				selected[i] = true;
				permutation(index + 1);
				selected[i] = false;
			}
		}
		
	}
	static void permutation(int[] arr, int depth, int n, int k) {
		if (depth == k) {
			printPermutation(arr, k);
			return;
		}
		for (int i = depth; i < n; i++) {
			swap(arr, i, depth);
			permutation(arr, depth + 1, n, k);
			swap(arr, i, depth);
		}

	}

	static void printPermutation(int[] arr, int k) {
		for (int i = 0; i < k; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}

	static void swap(int[] arr, int i, int j) {
		int temp;

		temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
}
