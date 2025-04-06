class Solution {
    public int firstMissingPositive(int[] nums) {
        int min =nums[0];
           HashSet<Integer> set = new HashSet<>();
        for(int i = 0;i < nums.length;i++){
            set.add(nums[i]);
            if(nums[i] < min && nums[i] >0){
                min = nums[i];
            }
        }
     
        int num=1;
        while(set.contains(num)){
            num++;
        }
        return num;
    }
}