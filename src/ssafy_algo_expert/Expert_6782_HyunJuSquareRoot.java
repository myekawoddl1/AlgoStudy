package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_6782_HyunJuSquareRoot {
	static int tc, count;
	static long N;
	static double a;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt."));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		tc = Integer.parseInt(st.nextToken());

		for(int i = 1; i <= tc; i++) {
			count = 0;
			st = new StringTokenizer(br.readLine());
			N = Long.parseLong(st.nextToken());
			while(N != 2) {
				if(N == 1) {
					count++;
					break;
				}
				
				long squareRoot = (long) Math.sqrt(N);
				if (squareRoot * squareRoot == N) {
					N = squareRoot;
					count++;
				} else {
					long temp = squareRoot + 1;
					count += temp * temp - N;
					N = temp * temp;
				}
			}
			
			System.out.println("#" + i + " " + count);
		}
	}
}
