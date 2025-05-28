    class Solution {
        public int longestMonotonicSubarray(int[] nums) {
            int increasing = 1;
            int decreasing = 1;
            int val = nums[0];
            int ans = 1;
            for(int i = 1;i <nums.length ;i++ ){
                if(nums[i] > nums[i-1]){
                    increasing++;
                    decreasing = 1;
                }
               else  if(nums[i] < nums[i-1]){
                    decreasing++;
                     increasing = 1;
                }
                else{
                    increasing=1;
                    decreasing =1;
                }

        
                ans = Math.max(ans, Math.max(increasing, decreasing));
            }



            

            return ans;
        }
    }