class Solution {
    public int majorityElement(int[] nums) {

        int n = nums.length;

        HashMap<Integer , Integer > map = new HashMap<>();
        for(int num : nums){
            int value = map.getOrDefault(num , 0);
            map.put(num , value+1);
        }

        for(Map.Entry<Integer, Integer> it: map.entrySet()){
            if(it.getValue() > n/2){
                return it.getKey();
            }
        }

        return -1;
        
    }
}