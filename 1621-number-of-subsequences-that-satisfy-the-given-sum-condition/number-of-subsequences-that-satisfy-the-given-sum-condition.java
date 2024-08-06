import java.util.Arrays;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int count = 0;
        int mod = 1_000_000_007;
        int n = nums.length;
        int left = 0, right = n - 1;

        // Precompute powers of 2 up to the length of nums
        int[] pow = new int[n];
        pow[0] = 1;
        for (int i = 1; i < n; i++) {
            pow[i] = (pow[i - 1] * 2) % mod;
        }

        while (left <= right) {
            if (nums[left] + nums[right] > target) {
                right--;
            } else {
                count = (count + pow[right - left]) % mod;
                left++;
            }
        }

        return count;
    }
}
