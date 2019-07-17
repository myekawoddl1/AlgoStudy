import java.util.ArrayList;
import java.util.Scanner;

public class GetPrime {
	public static void getPrime(int num, ArrayList<Integer> prime) {
		prime.add(2);
		for (int i = 2; i <= num; i++) {
			for (int j = 0; prime.size() > j; j++) {
				if (i % prime.get(j) == 0) break; // 소수가 아닌 경우 pass
				if (j + 1 == prime.size()) // 소수일 때
					prime.add(i);
			}
		}
		for (Integer result : prime) {
			System.out.println(result);
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> prime = new ArrayList<Integer>();
		long start = System.currentTimeMillis();
		getPrime(30000, prime);
		long end = System.currentTimeMillis();
		System.out.println("수행시간 : " + (end - start));
	}
}
