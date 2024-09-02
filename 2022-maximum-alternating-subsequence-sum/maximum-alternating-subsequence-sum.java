class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;

        long[][] t = new long[n][2];
        // 0 is for even
        // 1 is for odd
        t[0][0] = Math.max(-nums[0], 0);
        t[0][1] = Math.max(nums[0], 0);

        for (int i = 1; i < n; i++) {
            t[i][0] = Math.max(t[i - 1][1] - nums[i], t[i - 1][0]);
            t[i][1] = Math.max(t[i - 1][0] + nums[i], t[i - 1][1]);
        }

        return Math.max(t[n - 1][0], t[n - 1][1]);
    }
}