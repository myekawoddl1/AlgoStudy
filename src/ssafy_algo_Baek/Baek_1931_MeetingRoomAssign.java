package ssafy_algo_Baek;
/*
--회의실 배정

회의실이 하나 있다. 여러 회의들이 시작시간과 종료시간이 예약되어 있으며, 시간대가 겹치는 회의는 동시에 개최가 불가능하다. 따라서 같은 시간대에 속하는 회의들 중 하나만 개최하고 나머지 회의들은 버려야한다.

단, 종료시간과 시작시간이 같은 경우에는 시간이 겹친다고 말하지 않는다. 회의의 개수 N과 각 회의의 시작시간, 종료시간이 주어졌을 때 되도록 많은 회의를 개최하고자 한다.

회의를 최대한 많이 배정하는 프로그램을 작성하시오.

첫줄에는 회의의 수 N(5≤N≤500), 둘째 줄부터 i-1번 회의의 번호와 시작시간과 종료시간이 차례로 주어진다. (500 이하의 자연수)

첫줄에는 배정 가능한 최대의 회의수를 출력하고 다음 줄부터는 배정한 회의의 번호를 시간대순으로 출력한다. 만약, 답이 여러 가지(최대회의수가 될 수 있는 배정 방법이 여러가지)라면 그 중 아무거나 하나 출력한다.

--입력
11
1 4
3 5
0 6
5 7
3 8
5 9
6 10
8 11
8 12
2 13
12 14

--출력
3
2 5 4
 */

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Baek_1931_MeetingRoomAssign {
    static int N, meetingCount;
    static Meeting meetings[];

    static class Meeting implements Comparable<Meeting>{
        int num, start, end;
        Meeting(int n, int s, int e){
            this.num = n;
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Meeting o) {
            // return this.end - o.end;

            if (this.end < o.end) {
                return -1;
            } else if (this.end == o.end) {
                return this.start - o.start;
            } else {
                return 1;
            }
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "num=" + num +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        meetings = new Meeting[N];

        Meeting meeting;//
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            meeting = new Meeting(0, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            meetings[i] = meeting;
        }

        Arrays.sort(meetings);

        meeting = meetings[0];
        meetingCount++;
        // System.out.println(meeting);

        for(int i = 1; i < N; i++){
            if(meetings[i].start < meeting.end){
                continue;
            }
            meeting = meetings[i];
            meetingCount++;
            // System.out.println(meeting);
        }
        // System.out.println(meetings);

        System.out.println(meetingCount);
    }
}
