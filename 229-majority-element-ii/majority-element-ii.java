class Solution {
    public List<Integer> majorityElement(int[] nums) {
        

        Map<Integer , Integer> map = new HashMap<>();

        for(int i = 0;i < nums.length ;i++){
            map.put(nums[i] ,map.getOrDefault(nums[i] , 0) +1);
        }


        List<Integer> majority = new ArrayList<>();
        int threshold = nums.length /3;

        //Iterate through the frequency map to identify majority elements
        for(Map.Entry<Integer , Integer> entry : map.entrySet()){
            int element = entry.getKey();
            int count = entry.getValue();

            //Check if the element count is greater than the threshold
            if(count > threshold){
                majority.add(element);
            }
        }

        return majority;

        
    }
}