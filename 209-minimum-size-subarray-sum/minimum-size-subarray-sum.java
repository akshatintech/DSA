class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int len = nums.length;
        int sum = 0;

        int minAns = Integer.MAX_VALUE;
        while(right < len){
                sum +=nums[right];
            
            while(sum >= target){
                int ans = right-left+1;
                minAns = Math.min(minAns , ans);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return (minAns == Integer.MAX_VALUE) ? 0 : minAns;
    }
}