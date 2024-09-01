class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n ==1){
            return nums[0];
        }

        int[] t = new int[n+1];
        // t[i] = max profit till house i

        t[0] = 0;
        t[1] = nums[0];

        for(int i = 2 ;i <= n ;i++){
            int skip = t[i-1];
            int steal = nums[i-1] + t[i-2];

            t[i] = Math.max(skip  , steal);
        }

        return t[n];
    }
}