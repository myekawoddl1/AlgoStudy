package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2576_OddNumber {
	static int arr[] = new int [7];
	static int sum, minOdd = 100;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt."));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 7; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			if(arr[i] % 2 != 0) {
				sum += arr[i];
				minOdd = Math.min(minOdd, arr[i]);
			}
		}
		
		if(minOdd == 100) {
			System.out.println(-1);
		}else {
			System.out.println(sum);
			System.out.println(minOdd);
		}
	}

}
