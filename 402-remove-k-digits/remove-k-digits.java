class Solution {
    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        for (Character ch : num.toCharArray()) {
            while (!st.isEmpty() && k > 0 && ch < st.peek()) {
                st.pop();
                k--;
            }

            if (!st.isEmpty() || ch != '0') {
                st.push(ch);
            }
        }

        // This is a special edge case --> 1 2 3 4
        while (!st.isEmpty() && k-- > 0) {
            st.pop();
        }
        if (st.isEmpty())
            return "0";

        // Store the ans -->
        String ans = "";
        while (!st.isEmpty()) {
            ans = st.peek() + ans;
            st.pop();
        }
        return ans;
    }
}