class Solution {
    public boolean validPalindrome(String s) {
        s = s.toLowerCase();

        int left = 0;
        int right = s.length()-1;
        int count = 0;
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return(isPalindrome(s , left+1 , right) || isPalindrome(s, left , right-1));
            }
            left++;
            right--;
        }


        return true;
    }
    private boolean isPalindrome(String s , int left , int right){
        while(left < right){
            if(s.charAt(left) != s.charAt(right)){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}