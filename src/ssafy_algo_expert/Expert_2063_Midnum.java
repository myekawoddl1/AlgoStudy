package ssafy_algo_expert;

import java.util.Arrays;
import java.util.Scanner;

public class Expert_2063_Midnum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int arr[] = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		
		Arrays.sort(arr);
		System.out.println(arr[N/2]);
	}

}
