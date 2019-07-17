import java.util.ArrayList;

public class test {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(127);
        arr.add(127);
        arr.add(128);
        arr.add(128);
        System.out.println(arr.get(0) == arr.get(1));
        System.out.println(arr.get(2) == arr.get(3));

        Integer it1 = 127;
        Integer it2 = 127;
        System.out.println(it1 == 127);
        System.out.println(it1 == it2);
        it1 = new Integer(127);
        it2 = new Integer(127);
        System.out.println(it1 == 127);
        System.out.println(it1 == it2);
    }
}