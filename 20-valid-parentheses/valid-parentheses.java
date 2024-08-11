class Solution {
    public boolean isValid(String s) 
        {
            if(s.length() ==1){
                return false;
            }
            if(s.length() == 0){
                return true;
            }
        Stack<Character> st = new Stack<>();
        for(int i = 0; i< s.length() ;i++){
            char ch = s.charAt(i);

            if(ch =='(' || ch =='{' || ch == '['){
                st.push(ch);
            }
            else  {
                if(!st.isEmpty()) {


                    char out = st.pop();
                    if ((out == '(' && ch != ')') ||
                            (out == '[' && ch != ']') ||
                            (out == '{' && ch != '}')) {
                        return false;
                    }
                }
                else{
                    return false;
                }
            }
        }
        
        if (!st.isEmpty()){
            return false;
        }

        return true;

    }
    
        
    
}