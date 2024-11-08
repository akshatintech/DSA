class Solution {
    public int maxProduct(int[] nums) {
        double pref = 1, suf = 1;
        double max = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            if (pref == 0) pref = 1;  // Reset pref if it hits zero
            if (suf == 0) suf = 1;    // Reset suf if it hits zero

            pref *= nums[i];          // Product from the start
            suf *= nums[nums.length - i - 1];  // Product from the end

            max = Math.max(max, Math.max(pref, suf));  // Update max product
        }

        return (int) max;
    }
}