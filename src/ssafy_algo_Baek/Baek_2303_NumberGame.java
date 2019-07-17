package ssafy_algo_Baek;

import javax.xml.transform.sax.SAXSource;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
@SuppressWarnings("Duplicates")

public class Baek_2303_NumberGame {
	static int N, winner;
	static int card[][], max[];
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt."));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		card = new int [N][5];
		max = new int [N];
		for(int i = 0; i < N; i ++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 5; j++) {
				card[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[] combArr = new int[5];

		for(int i = 0; i < N; i ++) {
			doCombination(combArr, 5, 3, 0,0, card[i], i);
		}
		for(int i = 0; i < N; i ++) {
			winner = max[winner] <= max[i] ? i : winner;
		}

		System.out.println(winner + 1);

	}

	public static void doCombination(int[] combArr, int n, int r, int index, int target, int[] arr, int people){
		// System.out.println("=> "+n+" "+r+" "+index+" "+target);

		// r ==0 이란 것은 뽑을 원소를 다 뽑았다는 뜻.
		if(r == 0){
			int sum = 0;
			for(int i = 0; i < index; i++){
				sum += arr[combArr[i]];
			}
			sum %= 10;
			max[people] = Math.max(max[people], sum);
			// System.out.println(Arrays.toString(combArr));
			// for(int i=0; i<index; i++) System.out.print(arr[combArr[i]] + " ");

			// System.out.println();

			// 끝까지 다 검사한 경우..1개를 뽑은 상태여도 실패한 경우임 무조건 return 으로 종료
		}else if(target == n){
			return;

		}else{
			combArr[index] = target;
			// (i) 뽑는 경우
			// 뽑으니까, r-1
			// 뽑았으니 다음 index + 1 해줘야 함
			doCombination(combArr, n, r-1, index+1, target+1, arr, people);

			//(ii) 안 뽑는경우
			// 안뽑으니까 그대로 r
			// 안뽑았으니, index는 그대로!
			doCombination(combArr, n, r, index, target+1, arr, people);
		}
	}

}
