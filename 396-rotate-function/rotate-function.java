class Solution {
    public int maxRotateFunction(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int currentSum = 0;

        // Calculate the sum of array elements and F(0)
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            currentSum += i * nums[i];
        }

        int maxSum = currentSum;

        // Compute F(k) for k = 1 to n-1
        for (int i = 1; i < n; i++) {
            currentSum = currentSum + sum - n * nums[n - i];
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
