class Solution {
    public List<String> generateParenthesis(int n) {
        ArrayList<String> list = new ArrayList<>();
        String ref = "";
        helper(n , list , ref , n , n);
        return list;
    }

    public void helper(int n , ArrayList<String> list , String ref , int left, int right){
        if(left == 0 && right == 0){
            list.add(ref);
        }

        if(left > 0){
            helper(n , list , ref +"(" , left-1 , right);
        }
        if(right > left){
            helper(n , list , ref +")" , left ,right-1 );
        }
    }
}