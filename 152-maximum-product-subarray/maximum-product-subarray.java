class Solution {
    public int maxProduct(int[] nums) {

        double pref= 1 , suf = 1;
        double max = Integer.MIN_VALUE;

        for(int i =0;i < nums.length;i++){
            if(pref == 0) pref = 1;
            if(suf == 0) suf = 1;

            pref *= nums[i];
            suf *= nums[nums.length -i-1];

            max = Math.max(max , Math.max(pref , suf));
        }

        return (int)max;
        
    }
}