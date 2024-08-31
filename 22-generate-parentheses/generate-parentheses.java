class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", n, n);
        return list;
    }
    public void helper(List<String> list , String ref , int left , int right){
        if(left == 0 && right == 0){
            list.add(ref);
        }

        if(left > 0){
            helper(list, ref +"(" , left-1 , right);
        }
        if(right > left){
            helper(list , ref + ")" , left , right-1);
        }
    }
}