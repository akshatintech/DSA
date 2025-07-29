class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length -1;
        int left = 1;
        int[] output = new int[n+1];
        Arrays.fill(output , 1);
        for(int i = 0;i <=n ;i++){
            output[i] = output[i] * left;
            left = left * nums[i];
        }
        int right = 1;
        for(int i = n ;i >= 0;i--){
            output[i] = output[i] * right;
            right = right * nums[i];
        }

        return output;


        
    }
}