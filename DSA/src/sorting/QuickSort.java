package sorting;

import java.util.Arrays;

//Choose any element as a pivot
// After the first pass all the elements < pivot will be on the LHS of the pivot and elements greater than pivot are on the RHS of pivot
// We will move the pivot element at the correct position
//best case is to select the middle element as the middle


public class QuickSort {
	public static void main(String[] args) {
		int[] arr = new int[] {5,4,3,2,1};
		sort(arr, 0, arr.length-1);
		System.out.println(Arrays.toString(arr));
		
		
	}
	static void sort(int[] nums , int low , int high) {{
			if(low >= high) {
				return;
			}
			
			int s = low;
			int e =high;
			int m  =s  + (e-s)/2;
			int pivot = nums[m];
			
			while(s <= e) {
				//also a reason that if array is sorted it will not swap
				while(nums[s] < pivot) {
					s++;
				}
				while(nums[e] > pivot) {
					e--;
				}
				
				if(s <= e) {
					int temp = nums[s];
					nums[s] = nums[e];
					nums[e] = temp;
					s++;
					e--;
				}
			}
			
			//now my pivot is at correct index , please sort 2 halves now
			sort(nums, low, e);
			sort(nums, s, high);
	}
		
	}
}

