class Solution {
    public int[] rearrangeArray(int[] nums) {
        for(int i=1; i<nums.length-1; i++){
            double a = (double)(nums[i-1]+nums[i+1])/2.0;
            if((double)nums[i] == a){
                int temp = nums[i];
                nums[i] = nums[i+1];
                nums[i+1] = temp;
            }
        }
        for(int i=nums.length-2; i>0; i--){
            double a = (double)(nums[i-1]+nums[i+1])/2.0;
            if((double)nums[i] == a){
                int temp = nums[i];
                nums[i] = nums[i-1];
                nums[i-1] = temp;
            }
        }
        return nums;
    }
}