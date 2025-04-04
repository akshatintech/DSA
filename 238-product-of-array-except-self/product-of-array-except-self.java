class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n= nums.length;
        int[] output =new int[n];
        for(int i = 0;i < n ;i++){
            output[i] = 1;
        }

        int left = 1;
        for(int i =0;i < n;i++){
            output[i] =output[i] * left;
            left = left * nums[i];
        }

        int right =1;
        for(int i = n-1;i >=0;i--){
            output[i] = output[i] * right;
            right = right* nums[i];
        }
        return output;
    }
}