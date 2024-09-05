class Solution {
    Integer[][] dp = new Integer[2501][2501];  // Max size of nums is 2500 as per the constraint

    public int lengthOfLIS(int[] nums) {
        for (Integer[] row : dp) {
            Arrays.fill(row, -1);  // Fill the 2D array with -1
        }
        return helper(nums, -1, 0);  // Start with no previous index (-1) and at index 0
    }

    public int helper(int[] nums, int prevIndex, int index) {
        if (index == nums.length) {
            return 0;  // Base case: reached the end of the array
        }

        if (prevIndex != -1 && dp[prevIndex][index] != -1) {
            return dp[prevIndex][index];  // Use memoized result if available
        }

        // Option 1: include the current element if it is larger than the previous element
        int include = 0;
        if (prevIndex == -1 || nums[index] > nums[prevIndex]) {
            include = 1 + helper(nums, index, index + 1);
        }

        // Option 2: exclude the current element
        int exclude = helper(nums, prevIndex, index + 1);

        // Store the result and return the maximum of both options
        int result = Math.max(include, exclude);
        if (prevIndex != -1) {
            dp[prevIndex][index] = result;
        }

        return result;
    }
}
