package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2562_MaxValue {
	static int arr[] = new int [9];
	static int maxVal, maxIndex;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt."));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
			if(maxVal < arr[i]) {
				maxVal = arr[i];
				maxIndex = i;
			}
		}

		System.out.println(arr[maxIndex]);
		System.out.println(maxIndex + 1);
	}

}
