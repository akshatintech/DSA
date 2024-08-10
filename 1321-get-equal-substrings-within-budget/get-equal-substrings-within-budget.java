class Solution {
    public int equalSubstring(String s, String t, int maxCost) {

        int len= s.length();
        int left = 0;
        int right =0;
        int sum =0;
        int maxLength = 0;

        while(right < len){

            sum += Math.abs(s.charAt(right) - t.charAt(right))   ;

            while(sum > maxCost){
                sum -= Math.abs(s.charAt(left) -t.charAt(left));
                left++;
            }
            // Calculate the max length of the valid window
            maxLength = Math.max(maxLength, right - left + 1);

            // Expand the window to the right
            right++;
        }

        return maxLength;
        
    }
}