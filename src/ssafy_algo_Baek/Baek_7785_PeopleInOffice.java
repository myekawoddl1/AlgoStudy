package ssafy_algo_Baek;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("Duplicates")
public class Baek_7785_PeopleInOffice {
    static int N;
    static HashSet<String> office;
    public static void main(String[] args) throws IOException {
        System.setIn(new FileInputStream("input.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        office = new HashSet<>();
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            if(office.add(name)){

            } else{
                office.remove(name);
            }
            st.nextToken();
        }
        String [] peoples = office.toArray(new String[0]);

        Arrays.sort(peoples, new Comparator<String>() {

            @Override
            public int compare(String o1, String o2) {
                return -1*o1.compareTo(o2);
            }
        });

        for(int i = 0; i < peoples.length; i++){
            System.out.println(peoples[i]);
        }
    }
}
