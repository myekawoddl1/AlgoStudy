package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_1018_ChessBoardPainting {
	static int N, M;
	static char arr[][];
	static char chessWhite[][] = 
		{
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'}
		};
	static char chessBlack[][] = 
		{
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'},
				{'B','W','B','W','B','W','B','W'},
				{'W','B','W','B','W','B','W','B'}
		};


	static int whiteBoard(int y, int x) {
		int cnt = 0;
		for (int i = y; i < y + 8; i++)
            for (int j = x; j < x + 8; j++)
                    if (arr[i][j] != chessWhite[i - y][j - x])
                            cnt++;
		return cnt;
	}
	static int blackBoard(int y, int x) {
		int cnt = 0;
		for (int i = y; i < y + 8; i++)
			for (int j = x; j < x + 8; j++)
				if (arr[i][j] != chessBlack[i - y][j - x])
					cnt++;
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = st.nextToken().toCharArray();
			//			System.out.println(arr[i]);
		}
		int ans = Integer.MAX_VALUE;
		for (int i = 0; i + 7 < N; i++) {
			for (int j = 0; j + 7 < M; j++) {
				ans = Math.min(ans,  Math.min(whiteBoard(i, j), blackBoard(i, j)));
			}
		}
		System.out.println(ans);

	}

}
