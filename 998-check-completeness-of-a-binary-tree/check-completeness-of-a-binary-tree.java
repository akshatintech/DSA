/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        if (root == null) {
            return false;
        }
        return helper(root);
    }

    public boolean helper(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean end = false;

        while (!q.isEmpty()) {
            int qsize = q.size();

            for (int i = 0; i < qsize; i++) {
                TreeNode currNode = q.poll();
                if (currNode.left != null) {
                    if (end)
                        return false; // If we've already seen a node with missing children, tree can't be complete
                    q.offer(currNode.left);
                } else {
                    end = true; // Once we see a node without a left child, set the flag
                }
                if (currNode.right != null) {
                    if (end)
                        return false; // If left child was null but right child exists, tree isn't complete
                    q.offer(currNode.right);
                } else {
                    end = true; // Once we see a node without a right child, set the flag
                }
            }
        }
        return true;
    }
}