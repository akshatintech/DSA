class Solution {
    public int firstMissingPositive(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        int count=1;
        for(int i:nums){
            map.put(i,count);
            count++;
        }
        Arrays.sort(nums);
        int missing=0;
        
        //Yestcase:[7,8,9,11,12]
        if(nums[0]>1){
            return 1;
        }
        
        for(int i=0;i<nums.length;i++){
             if(nums[i]>=0){
                missing=nums[i]+1;
                if(!map.containsKey(missing)){
                    return missing;
                }
             }
             //Testcase like [-5], [-1,-2]
             if(nums[i]<0){
                 missing=1;
                 if(!map.containsKey(missing)){
                    return missing;
                }
             }
        }
        return missing;
    }
}