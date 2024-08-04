class Solution {
    public int partitionString(String s) {
        HashSet<Character> set = new HashSet<>(); 
        int count= 0;
        for(int i = 0; i< s.length() ; i++){
            char ch = s.charAt(i);
            if(!set.contains(ch)){
                set.add(ch);
            }
            else{
               
                set.clear();
                i--;
                count++;

            }
        }
        if(!set.isEmpty()){
            count++;
        }
        return count;
        
    }
}