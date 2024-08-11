package sorting;

import java.util.Arrays;
//Merge Sort is better in LinkedList due to memory allocation
public class MergeSort {
	public static void main(String[] args) {
		
		int[] arr=  new int[] {5,4,3,2,1};
		
		System.out.println(Arrays.toString(mergeSort(arr)));
		
	}
	
	
	static int[] mergeSort(int[] arr ) {
		if(arr.length ==1) {
			return arr;
		}
		//Take the middle element and split in into 2
		int mid = arr.length/2;
		
		int[] left = mergeSort(Arrays.copyOfRange(arr, 0, mid));
		int[] right =mergeSort(Arrays.copyOfRange(arr, mid, arr.length));
		
		return merge(left , right);
	}
	
	private static int[] merge(int[] first , int[] second) {
		int[] mix = new int[first.length + second.length];
		
		int i = 0;
		int j =0;
		int k = 0; 
		
		while(i < first.length && j < second.length) {
			if(first[i] < second[j]) {
				mix[k] = first[i];
				i++;
			}
			else {
				mix[k] = second[j];
				j++;
			}
			
			k++;
			
			
		}
		
		//it may be possible that one of the arrays is not complete
		//add all the remaning 	elements in the mix
		
		while(i < first.length) {
			mix[k] = first[i];
			i++;
			k++;
		}
		
		while(j < second.length) {
			mix[k] = second[j];
			j++;
			k++;
		}
		
		
		return mix;
	}
}