package ssafy_algo_jungol;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

@SuppressWarnings("Duplicates")
public class JungOl_1828_Refrigerator {
    static class Chemi implements Comparable<Chemi>{
        int start, end;
        Chemi(int s, int e){
            this.start = s;
            this.end = e;
        }

        @Override
        public int compareTo(Chemi o) {
            // return this.end - o.end;

            if(this.end != o.end) return this.end - o.end;
            else return this.start - o.start;
        }

        @Override
        public String toString() {
            return "Chemi{" +
                    "start=" + start +
                    ", end=" + end +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;// = new StringTokenizer(br.readLine());

        LinkedList<Chemi> chemis = new LinkedList<>();
        Chemi chemi;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()), b =Integer.parseInt(st.nextToken());
            chemi = new Chemi(a, b);
            chemis.add(chemi);
        }

        Collections.sort(chemis);
        System.out.println(chemis);
        int refCount = 0;
        while(chemis.size() > 0){
            chemi = chemis.poll();
            refCount++;
            for(int i = 0; i < chemis.size() ; i++){
                if(chemis.get(i).start <= chemi.end){
                    chemis.remove(i);
                    i--;
                }
            }
            //System.out.println(chemis);
        }

        System.out.println(refCount);
    }
}

