package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert_1256_Suffix {
	static int N, tc;
	static char str[];
	static String strArr[];
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		tc = Integer.parseInt(st.nextToken());
		for(int t = 1; t <= tc; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			str = st.nextToken().toCharArray();
			strArr = new String[str.length];
			
			for(int i = 0; i < str.length; i++) {
				String temp = new String(Arrays.copyOfRange(str, i, str.length)); 
				strArr[i] = temp;
			}
			// System.out.println(Arrays.toString(strArr));
			Arrays.sort(strArr);
			//System.out.println(Arrays.toString(strArr));
			System.out.println("#" + t + " " + strArr[N - 1]);
		}
	}
}
