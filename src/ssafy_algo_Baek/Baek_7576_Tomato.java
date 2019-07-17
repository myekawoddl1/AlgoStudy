package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Pair{
	int y,x;
	public Pair(int y, int x) {
		super();
		this.y = y;
		this.x = x;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pair [y=");
		builder.append(y);
		builder.append(", x=");
		builder.append(x);
		builder.append("]");
		return builder.toString();
	}

}
@SuppressWarnings("Duplicates")
public class Baek_7576_Tomato {

	static int dx[] = { 0,0,1,-1 };
	static int dy[] = { 1,-1,0,0 };
	static int map[][] = new int[1010][1010];

	static int M, N, num;
	static int emptyCount = 0, tomatoCount = 0, dayCount = 0;

	static Pair pair;
	static Queue<Pair> que = new LinkedList<Pair>();
	public static void main(String[] args) throws IOException {
		System.setIn(new FileInputStream("input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1){
					pair = new Pair(i, j);
					que.offer(pair);
					tomatoCount++;
				}else if(map[i][j] == -1) {
					emptyCount++;
				}
			}
		}


		if (tomatoCount == 0) {
			System.out.println(-1);
			return;
		}
		else if ((emptyCount + tomatoCount) == M * N) {
			System.out.println(0);
			return;
		}else {
			while(!que.isEmpty()) {
				Pair pairTemp = que.poll();
				int y = pairTemp.y;
				int x = pairTemp.x;
				if (dayCount <= map[y][x]) {
					dayCount = map[y][x];
				}
				for(int i = 0; i < 4; i++){
					int ny = pairTemp.y + dy[i];
					int nx = pairTemp.x + dx[i];
					//System.out.println(pairTemp.toString());
					if(0 <= ny && ny < N && 0 <= nx && nx < M) {
						if (map[ny][nx] == 0) {
							que.offer(new Pair(ny, nx));
							tomatoCount++;
							map[ny][nx] = map[y][x] + 1;
						}
					}
				}
			}
		}
		
		if ((emptyCount + tomatoCount) != M * N) {
			System.out.println(-1);
			return ;
		}

		System.out.println(dayCount - 1);

	}
}