class Solution {
    public int partitionString(String s) {
        String ans = "";
        int count= 0;
        for(int i = 0; i< s.length() ; i++){
            String ch = String.valueOf(s.charAt(i));
            if(!ans.contains(ch)){
                ans += s.charAt(i);
            }
            else{
                System.out.println(ans);
                ans= "";
                i--;
                count++;

            }
        }
        if(!ans.equalsIgnoreCase("")){
            count++;
        }
        return count;
        
    }
}