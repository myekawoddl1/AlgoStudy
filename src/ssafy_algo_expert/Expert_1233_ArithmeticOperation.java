package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 연산자는 루트 노드이거나 가지 노드, 즉 자식이 있어야 함
 * 피 연산자는 모두 잎 노드, 즉 자식 노드가 있으면 안됨.
 */
public class Expert_1233_ArithmeticOperation {
	static int N, digitCnt, operCnt;
	static boolean isPossble;
	static char arr[];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;// = new StringTokenizer(br.readLine());
		StringBuilder sb;// = new StringBuilder();
		
		for(int testCase = 0; testCase < 10; testCase++) {
			sb = new StringBuilder();
			isPossble = true;
			digitCnt = 0;
			operCnt = 0;
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new char[N + 1];
			
			for(int i = 1; i <= N / 2; i++) {
				st = new StringTokenizer(br.readLine());
				if(isPossble) {
					st.nextToken();
					arr[i] = st.nextToken().charAt(0);
					if(Character.isDigit(arr[i])) { // 루트나 가지 노드에 피연산자 들어왔을 때
						isPossble = false;
					}
				}
			}
			/**
			 * N개의 노드가 있을 때 2/N 이후의 노드는 자식이 없음
			 */
			for(int i = N / 2 + 1; i <= N; i++) {
				st = new StringTokenizer(br.readLine());
				if(isPossble) {
					st.nextToken();
					arr[i] = st.nextToken().charAt(0);
					if(!Character.isDigit(arr[i])) {
						isPossble = false; // 리프 노드에 연산자 들어왔을 때
					}
				}
			}
			sb.append(isPossble ? "1" : "0");
			System.out.println("#" + (testCase + 1) + " " + sb);
		}
	}
}
