package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1561_Noligongwon {
	static int n, m;
	static int[] play;
	
	public static long check(long x) {
		if (x == -1) {
			return 0;
		}
		long cnt = m;
		for (int i = 0; i < m; i++) {
			cnt += x / play[i];
		}
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		play = new int[m];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			play[i] = Integer.parseInt(st.nextToken());
		}
		
		long low = 0;
		long high = 60000000000L;
		while (low <= high) {
			long mid = (low + high) / 2;
			long begin = check(mid - 1);
			long end = check(mid);
			if (n <= begin) {
				high = mid - 1;
			} else if (n > end) {
				low = mid + 1;
			} else {
				for (int i = 0; i < m; i++) {
					if (mid % play[i] == 0 && ++begin == n) {
						System.out.println(i + 1);
						break;
					}
				}
				break;
			}
		}
		
		br.close();
	}
}