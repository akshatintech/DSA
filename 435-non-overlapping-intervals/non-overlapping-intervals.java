class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int count = 0;

        Arrays.sort(intervals , (a ,b) -> a[1] -b[1]);
        int[] curr = intervals[0];
        int start = curr[0];
        int end = curr[1];
        for(int i = 1 ; i< intervals.length; i++){
            curr = intervals[i];
            if(curr[0] >= start && curr[0] >=  end){
                if(curr[1] >= end && curr[1] >= start){
                    start= curr[0];
                    end = curr[1];
                }
            }
            else{
                count++;
            }
        }

        return count;
    }
}