class Solution {
    public void nextPermutation(int[] nums) {
        int n = nums.length;

        int pivot = -1;
        for(int i = n -2;i >=0;i--){
            if(nums[i] < nums[i+1]){
                pivot = i;
                break;
            }
        }
        

        if(pivot == -1){
            reverse(nums , 0 , n-1);
            return;
        }

        //Find the next greater element
        for(int i=n-1;i > pivot ;i--){
            if(nums[i] > nums[pivot]){
                swap(nums , i , pivot);
                break;
            }
        }

        reverse(nums , pivot+1 , n-1);



    }

    public void reverse(int[] nums , int start , int end){
        while(start < end){
            swap(nums , start++ , end--);
        }
    }

    public void swap(int[] nums , int start , int end){
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        
    }
}