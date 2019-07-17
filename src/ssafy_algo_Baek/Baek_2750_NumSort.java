package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Baek_2750_NumSort {
	static int N, num;
	static List<Integer> list = new LinkedList();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			num = Integer.parseInt(st.nextToken());
			list.add(num);
		}
		Collections.sort(list);

		for(int i = 0; i < N; i++) {
			System.out.println(list.get(i));
		}
	}
}
