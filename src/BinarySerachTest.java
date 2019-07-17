import java.util.Arrays;

public class BinarySerachTest {
	static int values[] = {3, 11, 15, 20, 21, 29, 45, 59, 65, 72};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(binarySearch(65));
		System.out.println(binarySearch(3));
		System.out.println(binarySearch(72));
		System.out.println(binarySearch(2));
		System.out.println(binarySearch(50));
		System.out.println("=========================================");
		System.out.println(binarySearch2(65, 0, values.length-1));
		System.out.println(binarySearch2(3, 0, values.length-1));
		System.out.println(binarySearch2(72, 0, values.length-1));
		System.out.println(binarySearch2(2, 0, values.length-1));
		System.out.println(binarySearch2(50, 0, values.length-1));
		System.out.println("=========================================");
		System.out.println(Arrays.binarySearch(values, 65));
		System.out.println(Arrays.binarySearch(values, 3));
		System.out.println(Arrays.binarySearch(values, 72));
		System.out.println(Arrays.binarySearch(values, 2));
		System.out.println(Arrays.binarySearch(values, 50)); // lowerbound
	}

	private static int binarySearch(int target) {
		int start = 0, end = values.length-1;
		
		while(start <= end) {
			int middle = (start + end)/2;
			if(values[middle] == target) return middle;
			else if(values[middle] < target) start = middle + 1;
			else end = middle -1;
		}
		return -1;
	}
	
	private static int binarySearch2(int target, int start, int end) {
		if(start > end) return -1;
		int middle = (start + end)/2;
		if(values[middle] == target) return middle;
		else if(values[middle] < target) return binarySearch2(target, middle + 1, end);
		else return binarySearch2(target, start, middle - 1);
	}
}
