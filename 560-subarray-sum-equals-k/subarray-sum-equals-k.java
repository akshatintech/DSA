class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer , Integer> map = new HashMap<>();
        int sum = 0;
        int count = 0;
        int n = nums.length;

        for(int i = 0;i < n;i++){
            sum += nums[i];
            if(sum == k){
                count++;
            }

            int rem = sum -k;
            count += map.getOrDefault(rem , 0);
            map.put(sum , (map.getOrDefault(sum , 0)) +1);
        }

        return count;
        
    }
}