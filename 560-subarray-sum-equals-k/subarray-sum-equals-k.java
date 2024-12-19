class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1);

        int runningSum = 0;
        int count = 0;

        for(int num : nums){
            runningSum += num;

            if(prefixSumCount.containsKey(runningSum -k)){
                count +=prefixSumCount.get(runningSum - k);
            }

            prefixSumCount.put(runningSum, prefixSumCount.getOrDefault(runningSum, 0) + 1);
        }

        return count;
    }
}