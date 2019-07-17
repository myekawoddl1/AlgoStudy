package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2523_Star13 {
	static int N;
	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken());
		for(int i = N - 1; i >= 0; i--) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = i; j < N; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
		for(int i = 1; i < N; i++) {
			for(int j = 0; j < i; j++) {
				System.out.print(" ");
			}
			for(int j = i; j < N; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}

	}
}

