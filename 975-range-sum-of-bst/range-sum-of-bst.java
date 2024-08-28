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
    public int rangeSumBST(TreeNode root, int low, int high) {
    
        return recursion(root , low , high )   ;
    }

    public int recursion(TreeNode root , int low , int high ){
        if(root == null){
            return 0 ;
        }
        int count = 0;
        if(root.val >= low && root.val <= high){
            count+= root.val;
        
        }
        if(root.val < high){
            count += recursion(root.right , low , high );
        }
        if(root.val > low){
            count += recursion(root.left , low , high );
        }
        return count;
        
    }
}