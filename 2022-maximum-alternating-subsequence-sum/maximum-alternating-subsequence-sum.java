class Solution {
    public long maxAlternatingSum(int[] nums) {
        long evenSum = 0; // Maximum sum when ending at an even index
        long oddSum = 0;  // Maximum sum when ending at an odd index
        
        for (int num : nums) {
            long newEvenSum = Math.max(evenSum, oddSum + num);
            long newOddSum = Math.max(oddSum, evenSum - num);
            evenSum = newEvenSum;
            oddSum = newOddSum;
        }
        
        return evenSum;
    }
}
