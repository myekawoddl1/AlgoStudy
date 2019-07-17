package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Expert_1244_MaxReward {
	static int[] arr, maxArr;
	static int tc, N, swapCount, maxCount;
	static int answer;

	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt."));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		tc = Integer.parseInt(st.nextToken());
		for(int testCase = 1; testCase <= tc; testCase++) {
			answer = 0;
			maxCount = -1;

			st = new StringTokenizer(br.readLine());
			String str = st.nextToken();
			N = str.length();
			swapCount = Integer.parseInt(st.nextToken());

			arr = new int[N];
			maxArr = new int[N];
			for (int i = 0; i < N; i++) {
				arr[i] = str.charAt(i) - '0';
			}

			// System.out.println(Arrays.toString(arr));
			// 가장 큰 수 swap
			// 맨 앞에 있으면 그 다음 수로 반복.
			
			dfs(0, 0);

			System.out.println(Arrays.toString(maxArr));

			if (swapCount > maxCount) {
				remainSwap();
			}

			System.out.println("#" + testCase + " " + answer);
		}
	}
	
	static void dfs(int maxIndex, int count) {
		maxCount = Math.max(maxCount, count);

		// 교환 끝
		if (count == swapCount) {
			int num = getNum(arr);
			answer = Math.max(answer, num);
			return;
		}

	//	if (count == maxCount) { // 제일 큰 수 저장, 횟수가 남았을 때 사용
			maxArr = arr.clone();
	//	}

		int max = 0;
		for (int i = maxIndex; i < N; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}

		for (int i = maxIndex; i < N; i++) {
			if (i != maxIndex && max == arr[i]) {
				swap(arr, maxIndex, i);
				dfs(maxIndex + 1, count + 1);
				swap(arr, i, maxIndex);
			}

			if (i == maxIndex && max == arr[i]) {
				dfs(maxIndex + 1, count);
			}
		}
	}

	static int getNum(int[] arr) {
		int num = 0;
		for (int i = 0; i < N; i++) {
			num += arr[i];
			if (i != N - 1)
				num *= 10;
		}
		return num;
	}

	static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	static void remainSwap() {
		int remainCnt = swapCount - maxCount;

		for (int i = 0; i < N - 1; i++) {
			// 제일 큰 수 일때 중복이 있는 경우
			if (maxArr[i] == maxArr[i + 1]) {
				answer = getNum(maxArr);
				return;
			}
		}

		// 남은 swap 횟수 스왑
		if (remainCnt % 2 == 0) { // 짝수일 때는 그냥 그대로
			answer = getNum(maxArr);
			return;
		} else { // 홀수 일 때는 맨 마지막 수만 스왑
			swap(maxArr, N - 1, N - 2);
			answer = getNum(maxArr);
			return;
		}
	}

}
