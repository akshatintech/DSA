class Solution {
    public int maxVowels(String s, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        String vowels = "aeiou";
        int maxCount = 0;
        while(right < s.length()){
            char ch = s.charAt(right);
            String str = String.valueOf(ch);
            if(vowels.contains(str)){
                count++;
            }
            
            if((right -left +1 ) > k){
                
                if(vowels.contains(String.valueOf(s.charAt(left)))){
                    count--;
                }
                left++;
                
            }
            maxCount = Math.max(count , maxCount);
            right++;
        }
        return maxCount;
    }
}