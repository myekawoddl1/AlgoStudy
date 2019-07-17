package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Baek_1764_Dudbojob {
	static int N, M;
	static Set<String> noHear = new HashSet<>();
	static List<String> noHearNoSee = new LinkedList();
	
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			noHear.add(st.nextToken());
		}
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			String check = st.nextToken();
			if(!noHear.add(check)) {
				noHearNoSee.add(check);
			}
		}
		int size = noHearNoSee.size();
		System.out.println(size);
		Collections.sort(noHearNoSee);
		Iterator<String> iter = noHearNoSee.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
	}
}
