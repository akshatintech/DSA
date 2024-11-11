class Solution {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            } else if (!st.isEmpty()) {
                char cha = st.peek();
                if ((ch == '}' && cha != '{') ||
                    (ch == ']' && cha != '[') ||
                    (ch == ')' && cha != '(')) {
                    return false;
                } else {
                    st.pop();
                }
            } else {
                // If stack is empty and there is a closing bracket, it's invalid
                return false;
            }
        }

        // The stack should be empty if all brackets were matched
        return st.isEmpty();
    }
}
