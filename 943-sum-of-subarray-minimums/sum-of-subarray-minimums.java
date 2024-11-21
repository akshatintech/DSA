
class Solution {
    public int sumSubarrayMins(int[] arr) {
        int length = arr.length;

        Stack<Integer> stack = new Stack<>();

        // Arrays to store 
        int[] left = new int[length];
        int[] right = new int[length];
        int mod = (int) 1e9 + 7;

        // Fill the left array with previous less elements
        for (int i = 0; i < length ; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        stack.clear();

        // Fill the right array with next less elements
        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? length : stack.peek();
            stack.push(i);
        }

        long ans = 0;
        for (int i = 0; i < length; ++i) {
            // Number of subarrays in which arr[i] is the minimum
            long cntLeft = i - left[i];
            long cntRight = right[i] - i;
            ans = (ans + (cntLeft * cntRight % mod) * arr[i] % mod) % mod;
        }
        return (int) ans;
    }
}