class Solution {
    public int minAddToMakeValid(String s) {
        Stack<Character> st = new Stack<>();
        int closeCount = 0;
        for(int i = 0;i < s.length(); i++){
            char ch = s.charAt(i);
            if(ch =='('){
                st.push(ch);
            }
            else if(ch ==')'){
                if(!st.isEmpty()){
                    if(st.peek() == '('){
                        st.pop();
                    }
                    else{
                       closeCount++; 
                    }
                }
                else{
                    closeCount++;
                }
            }
        }
        int ans = closeCount + st.size();
        return ans;
        
    }
}