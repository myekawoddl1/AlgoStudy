package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Expert_1228_Cryptogram {
	static int N, M, x, y;
	static LinkedList<Integer> list = new LinkedList<>();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		StringBuilder sb;// = new StringBuilder();
		
		
		for(int i = 0; i < 10; i++) {
			st = new StringTokenizer(br.readLine());
			sb = new StringBuilder();
			N = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			st = new StringTokenizer(br.readLine());
			M =  Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				st.nextToken();
				x = Integer.parseInt(st.nextToken());
				y = Integer.parseInt(st.nextToken());
				for(int k = 0; k < y; k++) {
					list.add(x + k, Integer.parseInt(st.nextToken()));
				}
			}
			for(int j = 0; j < 10; j++) {
				sb.append(list.get(j) + " ");
			}
			System.out.println("#" + (i + 1) + " " + sb);
			list.clear();
		}
		
	}

}
