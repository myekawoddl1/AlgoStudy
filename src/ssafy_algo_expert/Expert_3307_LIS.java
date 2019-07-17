package ssafy_algo_expert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Expert_3307_LIS{
	static int T, TCount = 0, N, max, low, high;
	static int num[];
	static ArrayList<Integer> dp = new ArrayList<Integer>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while(TCount < T) {
			low = 0;
			high = 0;

			N = sc.nextInt();
			num = new int [N];
			for(int i = 0; i < N; i++) {
				num[i] = sc.nextInt();
			}
			// 배열 입력 받음

			dp.add(num[0]);
			for(int i = 1; i < N; i++) {
				System.out.println(Arrays.toString(dp.toArray()));
				int endNum = dp.get(dp.size() - 1);
				int newNum = num[i];
				if(endNum < newNum) { // 새로운 숫자가 기존 dp끝 숫자보다 클 경우에 그냥 넣음
					dp.add(newNum);
				}
				else {	// 새로운 숫자가 기존 dp끝 숫자보다 작을 경우에 갱신하기
					low = 0;
					high = dp.size() - 1;
					while(low < high) {
						int mid = (low + high) / 2;
						if(dp.get(mid) < num[i]) {
							low = mid + 1;
						}else {
							high = mid;
						}
					} // high가 원하는 위치
					dp.set(high, newNum);
				}
			}
				System.out.println(Arrays.toString(dp.toArray()));



			TCount++;
			System.out.println("#" + TCount + " " + dp.size());
			dp.clear();
		}
	}

}
