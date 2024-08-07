class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] arr = new int[n];
        int left = 0;
        int right = n - 1;
        Arrays.sort(nums); // Sort the input array
        int index = 0;

        while (left <= right) {
            if (index % 2 == 0) {
                arr[index] = nums[left];
                left++;
            } else {
                arr[index] = nums[right];
                right--;
            }
            index++;
        }

        return arr;
        
    }
}