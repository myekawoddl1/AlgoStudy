package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_2501_FindingDivisor {

	static int N, K;
	static int count, result;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt."));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		int half = N / 2;
		for(int i = 1; i <= half; i++) {
			if(N % i == 0) {
				count++;
				if(count == K) {
					result = i;
				}
			}
		}
		count++;
		if(count == K) {
			result = N;
		}
		
		System.out.println(result);
	}

}
