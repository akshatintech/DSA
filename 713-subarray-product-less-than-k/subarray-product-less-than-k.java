class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int left = 0;
        int right = 1;
        int len = nums.length;
        int count = 0;
        int prod = 1;
        while(left < len){
            prod = 1;
            right = left+1;
            prod = prod * nums[left];
            if(prod < k){
                count++;
            }
            while(prod < k && right < len){
                prod= prod * nums[right];
                if(prod < k){
                    count++;
                    right ++;
                }
            }
            left++;

        }

        return count;
    }
}