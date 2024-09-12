class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        dp[1] = nums[0];
        int prev = nums[0];
        int prevPrev = 0;
        int ans = 0;
        for(int i = 2 ; i <= nums.length ; i++){



            int skip = prev;
            int take = nums[i-1] + prevPrev;

            ans = Math.max(skip , take);
            prevPrev = prev;
            prev = ans;
        }

        return prev;
    }
}