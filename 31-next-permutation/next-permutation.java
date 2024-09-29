class Solution {
    public void nextPermutation(int[] nums) {

        int n= nums.length;

        int idx = -1;       //break point

        for(int i = n-2 ;i >=0 ;i--){
            if(nums[i] < nums[i+1]){
                idx = i;
                break;              //idx  = i
            }
        }


        //if we do not get the break point reverse the array
        if(idx == -1){
            rev(nums , 0 , n-1);
            return;
        }

        //swap the index with the next greater element

        for(int i = n-1 ;i > idx ;i--){
            if(nums[i] > nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] =temp;
                break;
            }
        }

        rev(nums , idx+1 , n-1);
        return;
        
    }


    private void rev(int[] arr , int low , int high){

        int i = low;
        int j = high;

        while(i < j){
            int temp = arr[i];
            arr[i]=  arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}