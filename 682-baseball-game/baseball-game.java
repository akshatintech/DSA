class Solution {
    public int calPoints(String[] operations) {
        Stack<Integer> st = new Stack<>();
        int sum =0;
        for(int i = 0; i < operations.length; i++){
            String str = operations[i];

            if(str.equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(b);
                st.push(a);
                int ans = (a+b);
                st.push(ans);
            }
            else if(str.equals("D")){
                int a = st.peek();
                int ans = (a*2);
                st.push(ans);
            }
            else if(str.equals("C")){
                st.pop();
            }
            else {
                int a = Integer.valueOf(str);
                st.push(a);
            }
        }

        while(st.size() != 0){
            sum += st.pop();
        }
        return sum;
    }
}