class Solution {
    public int maxArea(int[] height) {
        int length = 0;

        int n = height.length;
        int right;
        int left = 0;
        int max_area = 0;
             right = n-1;
            while(left < right){
                int area = Math.min(height[left] , height[right]) * (right - left);
                max_area = Math.max(area , max_area);
                if(height[left] < height[right]){
                    left++;
                }
                else{
                    right--;
                }
            }

            return max_area;
        
    }
}