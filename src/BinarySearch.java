
public class BinarySearch {
	static int arr[] = {1,2,3,4,5,6};
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(binarySearch(arr, 5));
		System.out.println(binarySearchReculsive(arr, 0, arr.length - 1 ,5));

	}
	public static int binarySearch(int[] array, int key) {
	    int low = 0;
	    int high = array.length - 1;
	 
	    while (low <= high) {
	        int mid = (low + high) >>> 1;
	        int midVal = array[mid];
	 
	        //찾고자 하는 값이 중간요소 보다 큰경우
	        if (midVal < key)
	            low = mid + 1;
	        //찾고자 하는 값이 중간요소 보다 작은경우
	        else if (midVal > key)
	            high = mid - 1;
	        else
	            return mid; // key found
	    }
	    return -(low + 1); // key not found.
	}
	
	//재귀호출 스타일
	public static int binarySearchReculsive(int[] array, int low, int high, int key) {
	     
	    if (high < low)
	        return -1; // key not found.
	     
	    int mid = (low + high) >>> 1;
	 
	    //찾고자 하는 값이 중간요소 보다 작은경우
	    if (array[mid] > key)
	        return binarySearchReculsive(array, low, mid-1, key);
	    //찾고자 하는 값이 중간요소 보다 큰경우
	    else if (array[mid] < key)
	        return binarySearchReculsive(array, mid+1, high, key);
	    else
	        return mid; // key found
	}
}
