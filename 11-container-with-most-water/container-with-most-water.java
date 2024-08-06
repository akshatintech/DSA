class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int left = 0;
        int right = n-1;
        int area = 0;
        int maxArea = 0;
        while(left < right){
            int rodA = height[left];
            int rodB = height[right];
            int len = right - left;
            int width = Math.min(rodA , rodB);
            if(rodA > rodB){
                area=len * (width);
                right--;
            }
            else{
                area = len * (width);

                left++;
            }
            maxArea = Math.max(area , maxArea);
        }
        return maxArea;
    }
        
    
}