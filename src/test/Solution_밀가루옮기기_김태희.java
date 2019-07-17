package test;

import java.util.Scanner;
import java.io.FileInputStream;

public class Solution_밀가루옮기기_김태희 {
	public static void main(String args[]) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			int target = sc.nextInt(); // 목표무게
			int cnt = sc.nextInt(); // 봉지개수
			int[] weights = new int[cnt];
			int[] D = new int[target+1];

			for(int i=0; i<cnt; ++i) {
				weights[i] = sc.nextInt();
				if(weights[i]<=target) D[weights[i]] = 1; // 해당 봉지의 무게 동적테이블에 해당봉지1개의 값으로 초기화
			}

			for(int i=0; i<cnt; ++i) { //  첫번째 봉지부터 마지막 봉지까지 처리
				for(int	j=weights[i]+1; j<=target; ++j) {// 각 봉지의 무게+1부터 시도
					if(D[j-weights[i]] != 0) { // 남은 무게 만큼을 사용할수 있는 봉투의 개수가 존재하면
						if(D[j] == 0) { // 기존에 메모된 결과가 없다면
							D[j] = D[j-weights[i]]+1;
						}else { // 기존에 메모된 결과가 있다면
							if(D[j-weights[i]]+1<D[j]) D[j] = D[j-weights[i]]+1;
						}
					}
				}
			}
			System.out.println("#"+tc+" "+(D[target]==0?-1:D[target]));
		}
	}
}
