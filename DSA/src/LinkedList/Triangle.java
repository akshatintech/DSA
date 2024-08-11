package LinkedList;

public class Triangle {
	
	public static void main(String [] args) {
		int[] arr = new int[] {1,4,21,41,14,51,5,1,5};
		selection(arr, arr.length, 0);
	}
	static void selection(int[] arr , int n , int index) {
		if(index ==n) {
			return ;
		}
		
		
		//find the minimum element in the unsorted array
		int minIdx = 0;
		for(int j = index +1 ; j< n ;j++) {
			if(arr[j] < arr[minIdx]) {
				minIdx = j;
			}
		}
		
		//swap the minimum found element
		int temp = arr[minIdx];
		arr[minIdx] = arr[index];
		arr[index] = temp;
		
		
		//recursively call the selection sort
		selection(arr, n, index+1);
	}
}
