class Solution {
    public boolean isValid(String s) {

        Stack<Character> st= new Stack<>();
        for(int i = 0;i < s.length() ;i++){
            char ch = s.charAt(i);
            char temp;
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }
            else if(!st.isEmpty()){
                 if(ch ==')'){
                temp = st.pop();
                
                if(temp != '('){
                    return false;
                }
            }
             else if(ch =='}'){
                if(!st.isEmpty()){}
                temp = st.pop();
                if(temp != '{'){
                    return false;
                }
            }
             else if(ch ==']'){
                temp = st.pop();
                if(temp != '['){
                    return false;
                }
            }

            }
            else if(st.isEmpty()){
                return false;
            }
            
        }
        return st.isEmpty();
        
        
    }
}