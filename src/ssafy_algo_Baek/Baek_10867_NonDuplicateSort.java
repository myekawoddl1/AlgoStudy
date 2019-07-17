package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Baek_10867_NonDuplicateSort {
	static int N;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		TreeSet<Integer> list = new TreeSet<Integer>();
		for (int i = 0; i < N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		while(!list.isEmpty()) {
			sb.append(list.pollFirst()).append(' ');
		}
		System.out.println(sb);
	}

}
