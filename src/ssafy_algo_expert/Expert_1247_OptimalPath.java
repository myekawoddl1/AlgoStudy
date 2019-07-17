package ssafy_algo_expert;

/*
input

10
5
0 0 100 100 70 40 30 10 10 5 90 70 50 20
6
88 81 85 80 19 22 31 15 27 29 30 10 20 26 5 14
7
22 47 72 42 61 93 8 31 72 54 0 64 26 71 93 87 84 83
8
30 20 43 14 58 5 91 51 55 87 40 91 14 55 28 80 75 24 74 63
9
3 9 100 100 16 52 18 19 35 67 42 29 47 68 59 38 68 81 80 37 94 92
10
39 9 97 61 35 93 62 64 96 39 36 36 9 59 59 96 61 7 64 43 43 58 1 36
10
26 100 72 2 71 100 29 48 74 51 27 0 58 0 35 2 43 47 50 49 44 100 66 96
10
46 25 16 6 48 82 80 21 49 34 60 25 93 90 26 96 12 100 44 69 28 15 57 63
10
94 83 72 42 43 36 59 44 52 57 34 49 65 79 14 20 41 9 0 39 100 94 53 3
10
32 79 0 0 69 58 100 31 67 67 58 66 83 22 44 24 68 3 76 85 63 87 7 86

output

#1 200
#2 304
#3 265
#4 307
#5 306
#6 366
#7 256
#8 399
#9 343
#10 391
 */
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class Expert_1247_OptimalPath {
    static int tc, answer, N, office_x, office_y, home_x, home_y;
    static int people_x[], people_y[], numbers[];

    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        tc = Integer.parseInt(st.nextToken());
        for(int testCase = 1; testCase <= tc; testCase++) {
            answer = Integer.MAX_VALUE;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            people_x = new int[N];
            people_y = new int[N];
            numbers = new int[N];

            st = new StringTokenizer(br.readLine());
            office_x = Integer.parseInt(st.nextToken());
            office_y = Integer.parseInt(st.nextToken());

            home_x = Integer.parseInt(st.nextToken());
            home_y = Integer.parseInt(st.nextToken());

            for(int i = 0; i < N; i++){
                people_x[i] = Integer.parseInt(st.nextToken());
                people_y[i] = Integer.parseInt(st.nextToken());
                numbers[i] = i;
            }

            permutation(0);

            System.out.println("#" + testCase + " " + answer);
        }
    }

    private static void permutation(int index) {

        if(index == N) {
            //  System.out.println(Arrays.toString(numbers));
            answer = Math.min(answer, distance());
            // System.out.println(distance());
            return;
        }

        //1부터 N까지 시도
        for(int i = index; i < N; i++) {
            swap(index, i);
            permutation(index + 1);
            swap(i, index);
        }
    }

    static void swap(int i, int j) {
        int temp;

        temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private static int distance(){
        int d = 0;
        d += Math.abs(office_x - people_x[numbers[0]]) + Math.abs(office_y - people_y[numbers[0]]);
        for(int i = 0; i < N - 1; i++){
            d += Math.abs(people_x[numbers[i]] - people_x[numbers[i+1]]) + Math.abs(people_y[numbers[i]] - people_y[numbers[i+1]]);
        }

        d += Math.abs(people_x[numbers[N - 1]] - home_x) + Math.abs(people_y[numbers[N - 1]] - home_y);

        return d;
    }
}
