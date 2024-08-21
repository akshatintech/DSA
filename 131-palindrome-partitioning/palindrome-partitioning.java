class Solution {
    public List<List<String>> partition(String s) {
      List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        recursion(0 , s , ans , temp);
        return ans;

    }

    public static void recursion( int index , String s , List<List<String>> ans, List<String> temp ){
        if (index == s.length()){
            ans.add(new ArrayList<>(temp));
            return;
        }

        for (int i =index; i< s.length() ;i++){
            if (isPalindrome(s , index, i)){
                temp.add(s.substring(index , i+1));
                recursion(i+1 , s , ans , temp);
                temp.remove(temp.size()-1);
            }
        }





    }
    static boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--))
                return false;
        }
        return true;
    }
}