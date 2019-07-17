package ssafy_algo_Baek;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Baek_2309_SevenDwarf {
	static int max = 0;
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[9];
		for(int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			max += arr[i];
		}
		Arrays.sort(arr);
		for(int i = 0; i < 8 && !flag; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(max - arr[i] - arr[j] == 100) {
					flag = true;
					arr[i] = 101;
					arr[j] = 101;
					break;
				}
			}
		}
		// System.out.println(max);
		// System.out.println(flag);
		for(int i = 0; i < 9; i++) {
			if(arr[i] != 101)
			System.out.print(arr[i] + " ");
		}
		
		//System.out.println(Arrays.toString(arr));
		
	}

}
