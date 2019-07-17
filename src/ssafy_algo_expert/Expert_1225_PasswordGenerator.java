package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Expert_1225_PasswordGenerator {
	static Queue<Integer> que;
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		StringBuilder sb;// = new StringBuilder();
		for(int i = 0; i < 10; i++) {
			que = new LinkedList<Integer>();
			sb = new StringBuilder();
			st = new StringTokenizer(br.readLine());
			int testCase = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 8; j ++) {
				que.offer(Integer.parseInt(st.nextToken()));
			}
			
			for(int j = 1;  ; j = (j == 5 ? 1 : j + 1) ) {
				int temp = que.poll();
				temp -= j;
				if(temp <= 0) {
					temp = 0;
					que.offer(temp);
					break;
				}
				que.offer(temp);
			}
			while(!que.isEmpty()) {
				sb.append(que.poll() + " ");
			}

			System.out.println("#" + testCase + " " + sb);
		}
		que = new LinkedList<Integer>();
		
	}

}
