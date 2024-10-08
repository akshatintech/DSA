class Solution {
    public TreeNode deleteNode(TreeNode root, int key) {
        return helper(root, key);
    }

    public TreeNode helper(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                TreeNode temp = findMin(root.right);
                root.val = temp.val;
                root.right = helper(root.right, temp.val);
            }
        } else if (root.val > key) {
            root.left = helper(root.left, key);
        } else {
            root.right = helper(root.right, key);
        }
        return root;
    }

    private TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
