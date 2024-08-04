import java.util.*;

class Solution {
    public int rangeSum(int[] nums, int n, int left, int right) {
        // To prevent overflow, we use modulo 10^9 + 7
        int MOD = 1_000_000_007;

        List<Integer> subarraySums = new ArrayList<>();
        
        // Generate all possible subarray sums
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = i; j < n; j++) {
                sum = (sum + nums[j]) % MOD;  // Ensure sum doesn't overflow
                subarraySums.add(sum);
            }
        }
        
        // Sort the list of subarray sums
        Collections.sort(subarraySums);
        
        // Calculate the sum of elements from `left-1` to `right-1`
        int result = 0;
        for (int i = left - 1; i < right; i++) {
            result = (result + subarraySums.get(i)) % MOD;
        }
        
        return result;
    }
}
