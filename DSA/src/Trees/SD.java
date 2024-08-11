package Trees;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class SD {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }


    public List<String> serialize(TreeNode node){
        List<String> string  = new ArrayList<>();
        helper(node , string);
        return string;
    }

    void helper(TreeNode node , List<String> strings){

        if(node == null){
            strings.add("null");
            return;
        }
        strings.add(String.valueOf(node.val));
        helper(node.left , strings);
        helper(node.right , strings);


    }

    TreeNode deserialize(List<String> string){
        Collections.reverse(string);
        TreeNode node = helper2(string);
        return node;

    }

    private TreeNode helper2(List<String> string) {

        String val = string.remove(string.size()-1);


        if(val.charAt(0) == 'n'){
            return  null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(val));

        node.right = helper2(string);
        node.left = helper2(string);
        return node;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helperforpath(root , targetSum , 0);
    }

    private boolean helperforpath(TreeNode node, int target, int ans) {

        if (node == null) {
            return false;
        }

        ans +=node.val;
        if (node.left == null && node.right == null) {
            return ans == target;
        }

        return helperforpath(node.left, target, ans) || helperforpath(node.right, target, ans);



    }

        public int sumNumbers(TreeNode root) {
           return helperforsum(root , 0);
        }

        private int helperforsum(TreeNode root,  int ab) {

            if(root == null){

                return 0;
            }
            ab = ab * 10 + root.val;


            if(root.left == null && root.right == null){
                return ab;
            }
            return Math.max(helperforsum(root.left ,ab ) + helperforsum(root.right , ab) , ab);
    }
}
