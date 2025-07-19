import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLength = 0;

        // Count frequencies
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Check for harmonious pairs
        for (int key : map.keySet()) {
            if (map.containsKey(key + 1)) {
                int currentLength = map.get(key) + map.get(key + 1);
                maxLength = Math.max(maxLength, currentLength);
            }
        }

        return maxLength;
    }
}
