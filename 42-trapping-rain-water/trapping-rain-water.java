class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int trappedWater =0;
        int[] leftMax = new int[n];
        leftMax[0] = arr[0];

        for(int i = 1 ;i < n ;i++){
            leftMax[i] = Math.max(arr[i] , leftMax[i-1]);
        }


        int[] rightMax = new int[n];
        rightMax[n-1] = arr[n-1];

        for(int i = n-2 ;i >= 0 ;i--){
            rightMax[i] = Math.max(arr[i] , rightMax[i+1]);
        }


        //Calculating the rain water   
        int trapperWater = 0;

        for(int i = 0; i < n ;i++) {

            int waterLevel = Math.min(leftMax[i] , rightMax[i]);

            trappedWater = trappedWater + waterLevel - arr[i];
        }

        return trappedWater;
    }
}