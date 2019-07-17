package ssafy_algo_expert;
/*
[제약 사항]

가로 길이는 항상 100으로 주어진다.

모든 위치에서 상자의 높이는 1이상 100이하로 주어진다.

덤프 횟수는 1이상 1000이하로 주어진다.

주어진 덤프 횟수 이내에 평탄화가 완료되면 더 이상 덤프를 수행할 수 없으므로 그 때의 최고점과 최저점의 높이 차를 반환한다 (주어진 data에 따라 0 또는 1이 된다).

[입력]

총 10개의 테스트 케이스가 주어지며, 각 테스트 케이스의 첫 번째 줄에는 덤프 횟수가 주어진다. 그리고 다음 줄에 각 상자의 높이값이 주어진다.

[출력]

#부호와 함께 테스트 케이스의 번호를 출력하고, 공백 문자 후 테스트 케이스의 최고점과 최저점의 높이 차를 출력한다.
 */

import java.util.Arrays;
import java.util.Scanner;

public class Expert_1208_Flatten {
	static int T = 0, dumpCount, min, max;
	static int box[] = new int[100];
	static int countBox[] = new int[100];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(T++ < 10) {
			dumpCount = sc.nextInt();

			for(int i = 0; i < 100; i++) {
				box[i] = sc.nextInt();
				countBox[box[i]]++;
			}

			Arrays.sort(box);
			System.out.println(Arrays.toString(box));

			// cunting 배열로 한번 해 볼것
			//
			//	min max 구하기.
			//
			//
		
			for(int i = 0; i < dumpCount; i++) {
				if(box[99] - box[0]  <= 1) {
					break;
				}
				countBox[min + 1]++;
				countBox[max + 1]++;
				
				if(--countBox[max] == 0) max--;
				if(--countBox[min] == 0) min++;
			}
			
			for(int i = 0; i < dumpCount; i++) {
				if(box[99] - box[0]  <= 1) {;
					break;
				}
				
				box[0]++;
				box[99]--;
				if(box[0]>= box[1]) {
					for(int j = 1; j < 100; j++) {
						if(box[0] <= box[j]) {
							int temp = box[0];
							box[0] = box[j - 1];
							box[j - 1] = temp;
							break;
						}
					}
				}
				
				if(box[99] <= box[98]) {
					for(int j = 98; j >= 0; j--) {
						if(box[99] >= box[j]) {
							int temp = box[99];
							box[99] = box[j + 1];
							box[j + 1] = temp;
							break;
						}
					}
				}
			}
			System.out.println("#" + T + " " + (box[99] - box[0]));
		}

	}

}
