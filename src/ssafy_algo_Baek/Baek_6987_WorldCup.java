package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek_6987_WorldCup {
    static int ans[] = new int[4];
    static int tc;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for(tc = 0; tc < 4; tc++){
            int match[][];
            match = new int [6][3];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 6; i++){
                for(int j = 0; j < 3; j++){
                    match[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int winCnt = 0;
            int loseCnt = 0;
            int drawCnt = 0;
            boolean matchPossible = true;
            for(int i = 0; i < 6; i ++){
                winCnt += match[i][0];
                loseCnt += match[i][2];
                drawCnt += match[i][1];
                if(match[i][0] + match[i][1] + match[i][2] != 5) {
                    matchPossible = false;
                    break;
                }
            }
            if((winCnt + loseCnt + drawCnt) != 30 || winCnt != loseCnt || !matchPossible || drawCnt % 2 == 1) {
                ans[tc] = 0;
                continue;
            }

            dfs(match,0,1);

        }
        System.out.println(ans[0] + " " + ans[1] + " " + ans[2] + " " + ans[3]);
    }

    static void dfs(int match[][], int home, int away){
        if(ans[tc] == 1) return;

        if(home == 6) { // 마지막 팀까지 옴
            ans[tc] = 1;
            return;
        }

        if(away == 6) { // 홈팀이 다른 5팀과 모든 경기를 함
            dfs(match,home + 1, home + 2);
            return;
        }

        match[home][0]--;
        match[away][2]--;
        // home 승 away 패
        if(match[home][0] >= 0 && match[away][2] >= 0){
            dfs(match, home, away + 1);
            if(ans[tc] == 1) return;
        }
        match[home][0]++;
        match[away][2]++;

        match[home][1]--;
        match[away][1]--;
        // home away 무승부
        if(match[home][1] >= 0 && match[away][1] >= 0){
            dfs(match, home, away + 1);
            if(ans[tc] == 1) return;
        }
        match[home][1]++;
        match[away][1]++;

        match[home][2]--;
        match[away][0]--;
        // home 패 away 승
        if(match[home][2] >= 0 && match[away][0] >= 0){
            dfs(match, home, away + 1);
            if(ans[tc] == 1) return;
        }
        match[home][2]++;
        match[away][0]++;
    }

}
