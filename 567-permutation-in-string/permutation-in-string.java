class Solution {
    public boolean checkInclusion(String s1, String s2) {
        
       
        int m = s1.length();
        int n = s2.length();
         if (m > n) return false;
        int[] s1count = new int[26];
        int[] s2count = new int[26];

        for(int i = 0;i < m ;i++){
            s1count[s1.charAt(i) -'a']++;
            s2count[s2.charAt(i) -'a']++;
        }

        if(Arrays.equals(s1count , s2count)){
            return true;
        }

        for(int i = m; i< n ;i++){
            s2count[s2.charAt(i) -'a']++;
            s2count[s2.charAt(i -m) -'a']--;

            if(Arrays.equals(s1count , s2count)) return true;
        }

        return false;
        
    }
}