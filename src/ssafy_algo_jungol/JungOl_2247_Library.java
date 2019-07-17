package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class JungOl_2247_Library {
    static int N, ansStard, ansEnd, ansExist, ansEmpty;
    static LinkedList<Student> list = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            list.add(new Student(s, e));
        }

        Collections.sort(list);
        ansStard = list.get(0).start;
        ansEnd = list.get(0).end;
        ansExist = ansEnd - ansStard;
        for(int i = 1; i < N; i++){
            int tempS = list.get(i).start;
            int tempE = list.get(i).end;

            if(ansEnd < list.get(i).start){
                int emptyT = tempS - ansEnd;
                ansEmpty = ansEmpty < emptyT ? emptyT : ansEmpty;
                ansStard = tempS;
                ansEnd = tempE;
                int temp = ansEnd - ansStard;
                ansExist = temp < ansExist ? ansExist : temp;
                continue;
            }

            ansEnd = ansEnd < tempE ? tempE : ansEnd;
            ansExist = ansExist < ansEnd - ansStard ? ansEnd - ansStard : ansExist;
        }
        System.out.println(ansExist + " " + ansEmpty);
    }

    static class Student implements Comparable<Student>{
        int start, end;

        public Student(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Student o) {
            if(this.start == o.start)
                return this.end - this.end;
            return this.start - o.start;
        }
    }
}
