package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Baek_2635_NumContinue {
	private static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	static int N;
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt."));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());

		int max = 0; 
		LinkedList<Integer> result = new LinkedList<>(); 
		for (int i = N; i >= N / 2; i--) { 
			LinkedList<Integer> numberList = new LinkedList<>();
			numberList.add(N); 
			int tempN = N;
			int number = i; 
			while (true) { 
				if (tempN < 0) break; 
				int t = tempN;
				if (number >= 0) numberList.add(number); 
				tempN = number; 
				number = t - tempN; 
			} 
			if (max < numberList.size()) {
				max = numberList.size(); 
				result = numberList; 
			} 
		} 
		bw.write(max + "\n"); 
		for (int n : result) 
			bw.write(n + " "); 
		bw.flush();

	}

}
