package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Baek_13866_TeamDivide {
	static int arr[] = new int [4];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 4; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		//System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Math.abs(arr[0] + arr[3] - arr[1] - arr[2]));
	}


}
