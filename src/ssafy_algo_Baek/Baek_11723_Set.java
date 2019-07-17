package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baek_11723_Set {
	static int M, x;
	static String command;
	static HashSet<Integer> set = new HashSet<>(); 
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < M; i ++) {
			st = new StringTokenizer(br.readLine());
			command = st.nextToken();
			switch (command) {
			case "add":
				x = Integer.parseInt(st.nextToken());
				set.add(x);
				break;
			case "remove":
				x = Integer.parseInt(st.nextToken());
				set.remove(x);
				break;
			case "check":
				x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) {
					sb.append(1 + "\n");
				}else {
					sb.append(0 + "\n");
				}
				break;
			case "toggle":
				x = Integer.parseInt(st.nextToken());
				if(set.contains(x)) {
					set.remove(x);
				}else {
					set.add(x);
				}
				break;
			case "all":
				for(int j = 1; j <= 20; j ++) {
					set.add(j);
				}
				break;
			case "empty":
				set.clear();
				break;
			default:
				break;
			}
		}
		System.out.print(sb);
	}

}
