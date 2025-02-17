/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public void flatten(TreeNode root) {
        TreeNode prev = null;
        helper(root , prev);
    }


    public TreeNode  helper(TreeNode root , TreeNode prev){
        if(root == null){
            return prev;
        }
        prev = helper(root.right , prev);
        prev = helper(root.left , prev);
        root.right = prev;
        root.left = null;
        return root;
    }
}