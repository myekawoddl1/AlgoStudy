import java.util.ArrayList;



public class GetPrime2 {
	static boolean num[] = new boolean [1000];
	public static void getPrime(int max) {
		for(int i = 2; i < max; i++){
			num[i] = true;
		}

		for(int i = 2; i <= (int)Math.sqrt(max); i++){
			if(num[i]){
				for(int j = i; j * i < max; j++){
					num[j * i] = false;
				}
			}
		}

	}

	public static void main(String[] args) {
		boolean isOK;
		for(int i=2;i<=1000;i++) {
			isOK = true;
			for(int j = 2; j <= (int)Math.sqrt(i); j++) { // i의 제곱근까지 루프
				if(i % j == 0) {
					isOK = false;
					break;
				}
			}
			if(isOK && i != 1) System.out.println(i);
		}


	}
}
