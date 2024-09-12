class Solution {
    public int[] t  = new int[101];
    public int rob(int[] nums) {
        int n = nums.length;
        Arrays.fill(t , -1);
        return solve(nums , 0 , n);
    }

    public int solve(int[] nums , int index , int n){
        if(index >=n){
            return 0;
        }


        if(t[index] != -1){
            return t[index];
        }

        int take = nums[index] + solve(nums , index +2 , n);
        int skip = solve(nums , index+1 , n);

        return t[index] = Math.max(take, skip);

    }

}