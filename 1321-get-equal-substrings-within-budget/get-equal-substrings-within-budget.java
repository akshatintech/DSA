class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int len = s.length();
        int[] cost = new int[len];

        // Calculate the cost array
        for (int i = 0; i < len; i++) {
            cost[i] = Math.abs(s.charAt(i) - t.charAt(i));
        }

        int sum = 0;
        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < len; right++) {
            sum += cost[right];

            // If the current window exceeds maxCost, shrink it from the left
            while (sum > maxCost) {
                sum -= cost[left];
                left++;
            }

            // Update the maximum length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
