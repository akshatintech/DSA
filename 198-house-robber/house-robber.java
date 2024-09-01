class Solution {
    public int[] t = new int[101];

    public int solve(int[] nums, int i, int n) {
        if (i >= n) {
            return 0;
        }

        if (t[i] != -1) {
            return t[i];
        }

        int take = nums[i] + solve(nums, i + 2, n); // steals ith house and moves to i+2 (because we can't steal adjacent)
        int skip = solve(nums, i + 1, n); // skips this house, now we can move to adjacent next house

        return t[i] = Math.max(take, skip);
    }

    public int rob(int[] nums) {
        int n = nums.length;
        Arrays.fill(t, -1);
        return solve(nums, 0, n);
    }
}