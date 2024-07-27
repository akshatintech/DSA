class Solution {
    public long interchangeableRectangles(int[][] rectangles) {
        Map<Double , Long> map =new HashMap<>();
        long ans = 0;

        for(int [] rect : rectangles){
            double ratio = (double) rect[0] / rect[1];
            map.put(ratio, map.getOrDefault(ratio, 0L) + 1);
        }

        for(long count : map.values()){
            ans += count * (count -1)/2;
        }
        return ans;

    }
}