package ssafy_algo_expert;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Expert_1204_Mode {
	static int T, TCount, Tnum, num, modeNum, modeMax;
	//static 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		while(TCount < T) {
			Tnum = sc.nextInt();
			modeMax = 0;
			modeNum = 0;
			int score[] = new int[101];
			for(int i = 0; i < 1000; i++) {
				num = sc.nextInt();
				score[num]++;
				if(modeMax <= score[num]) {
					if(modeMax < score[num]) {
						modeMax = score[num];
						modeNum = num;
					}
					else {
						modeNum = modeNum < num ? num : modeNum;
					}
					
				}
			}
			//System.out.println(Arrays.toString(score));
			System.out.println("#" + Tnum + " " + modeNum);
			TCount++;
		}
	}

}
