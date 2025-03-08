class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0; // Edge case: empty array
        }

        int size = 1; // The first element is always unique
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) { // Compare with the previous element
                nums[size] = nums[i]; // Place the unique element in the correct position
                size++; // Increment the size of the unique elements array
            }
        }

        return size; // Return the number of unique elements
    }
}