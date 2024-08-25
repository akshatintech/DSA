class Solution {
    public int findDuplicate(int[] nums) {
        int[] arr = new int[1000001];
        for(int i = 0; i < nums.length ;i++){
            int num1 = nums[i];
            if(arr[num1] >=1){
                return num1;
            }
            else{
                arr[num1] ++;
            }
        }
        return -1;
    }
}