package com.leetcode;

public class Recursion {
	
	public static void main(String[] args) {
			
		
		
		System.out.println(sumFirstN(3));
		
	}
	
	 public static long sumFirstN(long n) {
	        // Write your code here.
			long ans = sum(n , 1);
			return ans;
	    }

	public static long sum(long n , long ans){
		
		if(n ==0) {
			return 0;
		}
		ans = n + sum(n-1 , ans);
		
		return ans;
	}
	
	public static long fact(long n) {
		if(n == 1) {
			return 1;
		}
		
			return n * fact(n-1 );
		
		
	}


}
