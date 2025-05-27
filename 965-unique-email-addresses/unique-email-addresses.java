class Solution {
    public int numUniqueEmails(String[] emails) {
        
        Set<String> st = new HashSet<>();
        
        for(int i = 0 ; i< emails.length ; i++){
            int index= 0;
            String str = emails[i];
            String ans= "";
            while(str.charAt(index) != '@' && str.charAt(index) != '+'){
                if(str.charAt(index) == '.'){
                    
                }
                else{
                     ans = ans + str.charAt(index);

                }
                index++;
               
            }
            while(str.charAt(index)!= '@') {
            	index++;
            }
            String domain  = str.substring(index, str.length()-1);
            st.add(ans+domain);

        }

        return st.size();
        
    
        
    }
}