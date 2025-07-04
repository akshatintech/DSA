class Solution {
    public int[] rearrangeArray(int[] nums) {
        List<Integer> pos = new ArrayList<>();
        List<Integer> neg = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) pos.add(num);
            else neg.add(num);
        }

        int[] result = new int[nums.length];
        int i = 0, j = 0, k = 0;

        while (i < pos.size() && j < neg.size()) {
            result[k++] = pos.get(i++);
            result[k++] = neg.get(j++);
        }

        // Optional: If one list is longer (can happen if input is unbalanced)
        while (i < pos.size()) 
        result[k++] = pos.get(i++);
        while (j < neg.size()) 
        result[k++] = neg.get(j++);

        return result;
    }
}
