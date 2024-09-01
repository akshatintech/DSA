class Solution {
    // this function is solution of House robber I. We just use it to solve House Robber II
    public int solve(int[] nums, int l, int r) {

        int prevPrev = 0, prev = 0;

        for (int i = l; i <= r; i++) {
            int skip = prev;
            int take = nums[i] + prevPrev;

            int temp = Math.max(skip, take);

            prevPrev = prev;
            prev = temp;
        }

        return prev;
    }

    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        int take_first_house = solve(nums, 0, n - 2);
        int skip_first_house = solve(nums, 1, n - 1);

        return Math.max(take_first_house, skip_first_house);
    }
}