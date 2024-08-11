package Trees;

import com.sun.source.tree.Tree;

import java.util.*;

public class TreeSolution {
    int diameter = 0;

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode() {

        }
    }

    int i = 0;
    public TreeNode bstFromPreorder(int[] A) {
        return bstFromPreorder(A, Integer.MAX_VALUE);
    }

    public TreeNode bstFromPreorder(int[] A, int bound) {
        if (i == A.length || A[i] > bound)
            return null;
        TreeNode root = new TreeNode(A[i++]);
        root.left = bstFromPreorder(A, root.val);
        root.right = bstFromPreorder(A, bound);
        return root;
    }

  public List<TreeNode> delNodes(TreeNode root , int[] to_delete){
            List<TreeNode> ans = new ArrayList<>();
            Set<Integer> st = new HashSet<>();
            for(int i = 0; i< to_delete.length;i++){
                st.add(to_delete[i]);
            }
            return ans;
  }
    public void helper(TreeNode root,  Set<Integer> st , List<TreeNode> ans){

        if(root == null){
            return;
        }
        if(st.contains(root.val)){
            ans.add(null);
            return;
        }
        ans.add(root);
        helper(root.left , st , ans );
        helper(root.right , st ,ans);

    }










    public static void main(String[] args) {
        TreeSolution solution = new TreeSolution();
        // Creating a binary tree
        TreeNode node4 = solution.new TreeNode(4);
        TreeNode node5 = solution.new TreeNode(5);
        TreeNode node2 = solution.new TreeNode(2, node4, node5);


        TreeNode node6 = solution.new TreeNode(6);
        TreeNode node7 = solution.new TreeNode(7);
        TreeNode node3 = solution.new TreeNode(3 , node6 , node7);
        TreeNode root = solution.new TreeNode(1, node2, node3);
        int[] arr = new int[]{8,5,1,7,10,12};
        TreeNode ans = solution.bstFromPreorder(arr);
        // Calculating the diameter
        /*int result = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + result);*/
        //invertTree(root);
        //flatten(root);



        //int[] arr1 = new int[]{9,3,15,20,7};
        //buildTree(arr , arr1);


    }
}
