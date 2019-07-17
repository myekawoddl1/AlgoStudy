package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Expert_5607_Professional_Johap {
	static int tc, N, R, P = 1234567891;
	static long fac[], inv[];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input5607.txt."));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		tc = Integer.parseInt(st.nextToken());
		fac = new long [1000001];
		inv = new long [1000001]; // 1/a 의 역원 = a^(p-2)

		fac[1] = 1L;

		for(int i = 2; i <= 1000000; i++) {
			fac[i] = (fac[i - 1] * i) % P;
		}

		inv[1000000] = power(fac[1000000], (P - 2));

		for (int i = 1000000 - 1; i > 0; i--)
			inv[i] = (inv[i + 1] * (i + 1)) % P;

		for(int i = 1; i <= tc; i++) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			R = Integer.parseInt(st.nextToken());

			R = (R < N - R) ? R : N - R;

			long r = (fac[N] * inv[N - R]) % P;
			r = (r * inv[R]) % P;

			System.out.println("#" + i + " " + r);
		}
	}

	public static long power(long x, int y) {
		long result = 1L;
		while (y > 0) {
			if (y % 2 == 1) {
				result *= x;
				result %= P;
			}
			x *= x;
			x %= P;
			y /= 2;
		}
		return result;
	}
}
