class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int n = numbers.length;
        
        int[] ans = new int[2];
        for(int i =0; i <n -1;i++ ){
            int a = numbers[i];
            for(int j = i+1 ; j < n ;j++){
                int b = numbers[j];
                if((a + b) == target){
                    ans[0] = i+1;
                    ans[1] = j+1;
                    return ans;
                }
            }
        }
        return ans;
    }
}