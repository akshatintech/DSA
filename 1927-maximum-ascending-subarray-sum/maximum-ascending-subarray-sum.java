class Solution {
    public int maxAscendingSum(int[] nums) {
        
	        int num= 0;
	        int sum = 0;
	        int ans = nums[0];
	        sum = nums[0];
	        for(int i = 1;i < nums.length ;i++){
	            	
	            if(nums[i] > nums[i-1]){
	            	if(sum == 0) {
	            		sum = nums[i-1];
	            	}
	                sum += nums[i];
	            }
	            else{
	                sum = 0;
	            }
	            ans = Math.max(ans , sum);
	        }
	        return ans;
	    
    }
}