package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Solution522 {
    static int visited[] = new int[200101];
    static LinkedList<Integer> cony = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int tmp = C;
        int inc = 1;
        while (tmp <= 200000) {
            tmp += inc;
            cony.add(tmp);
            inc++;
        }

        int ans = -1;
        int sz = cony.size();
        for (int i = 0; i < sz; i++) {

            if (bfs(B, cony.get(i)) == i + 1) {
                ans = i + 1;
                break;
            }
        }
        System.out.println(ans);
    }

    static int bfs(int x, int y)
    {
        Queue<Integer> s = new LinkedList<>();
        int cnt = 0;
        Arrays.fill(visited, 0);
        s.add(x);
        visited[x] = 1;
        while (visited[y] == 0)
        {
            int ps = s.size();
            cnt++;
            while (ps != 0)
            {
                ps--;
                int pos = s.peek();
                s.poll();
                if (pos + 1 <= 200000 && visited[pos + 1] == 0) {
                    s.add(pos + 1);
                    visited[pos + 1] = 1;
                }
                if (pos - 1 >= 0 && visited[pos - 1] == 0) {
                    s.add(pos - 1);
                    visited[pos - 1] = 1;
                }
                if (pos * 2 <= 200000 && visited[pos * 2] == 0) {
                    s.add(pos * 2);
                    visited[pos * 2] = 1;
                }
            }
        }
        return cnt;
    }

}
