class Solution {
    public int[] t = new int[101];

    public int solve(int[] nums, int i, int n) {
        if (i > n) {
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

        if (n == 1) {
            return nums[0];
        }

        if (n == 2) {
            return Math.max(nums[0], nums[1]);
        }

        Arrays.fill(t, -1);

        // case-1 - Take first house 0th index wala house
        int take_0th_index_house = solve(nums, 0, n - 2);

        Arrays.fill(t, -1);

        // case-2 - Take second house 1st index wala house
        int take_1st_index_house = solve(nums, 1, n - 1);

        return Math.max(take_0th_index_house, take_1st_index_house);
    }
}