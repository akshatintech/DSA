package Trees;

import java.util.*;

public class BFS {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode next;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }

        TreeNode(int val, TreeNode left, TreeNode right, TreeNode next) {
            this.val = val;
            this.left = left;
            this.right = right;
            this.next = next;
        }
    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> deque = new LinkedList<>();
        deque.offer(root);
        boolean reverse = false;

        while (!deque.isEmpty()) {
            int level = deque.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < level; i++) {
                if (!reverse) {
                    TreeNode currentNode = deque.pollFirst();   //this will remove the first element
                    currentLevel.add(currentNode.val);
                    if (currentNode.left != null) {
                        deque.addLast(currentNode.left);
                    }
                    if (currentNode.right != null) {
                        deque.addLast(currentNode.right);
                    }
                } else {
                    TreeNode currentNode = deque.pollLast();
                    currentLevel.add(currentNode.val);
                    if (currentNode.right != null) {
                        deque.addFirst(currentNode.right);
                    }
                    if (currentNode.left != null) {
                        deque.addFirst(currentNode.left);
                    }
                }
            }
            reverse = !reverse;
            res.add(currentLevel);
        }

        return res;
    }

    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();

        if (root == null) {
            return res;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int level = queue.size();
            double sum = 0;
            for (int i = 0; i < level; i++) {
                TreeNode currentNode = queue.poll();
                sum += currentNode.val;

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }
            res.add(sum / level);
        }

        return res;
    }

    public TreeNode findSuccessor(TreeNode root, int key) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode currentNode = queue.poll();

            if (currentNode.left != null) {
                queue.offer(currentNode.left);
            }
            if (currentNode.right != null) {
                queue.offer(currentNode.right);
            }

            if (currentNode.val == key) {
                break;
            }
        }

        return queue.peek();
    }


    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);

                if (node.left != null) {
                    queue.offer(node.left);

                }

                if (node.right != null) {
                    queue.offer(node.right);
                }
            }

            ans.add(0, level);
        }
        return ans;


    }


    public TreeNode connect(TreeNode root) {

        if (root == null) {
            return null;
        }

        //currently leftmost node  = root

        TreeNode leftMost = root;

        while (leftMost.left != null) {
            TreeNode current = leftMost;
            while (current != null) {
                current.left.next = current.right;
                if (current.next != null) {
                    current.right.next = current.next.left;
                }

                current = current.next;
            }
            leftMost = leftMost.left;
        }

        return root;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }


        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            TreeNode currentNode = queue.poll();
            for (int i = 0; i < levelSize - 1; i++) {

                if (currentNode.left != null) {
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.offer(currentNode.right);
                }
            }


            ans.add(currentNode.val);

        }

        return ans;
    }

    public boolean isSymmetric(TreeNode root) {

        if(root == null){
            return false;


        }


        Deque<TreeNode> deque = new LinkedList<>();
         deque.add(root.left);
         deque.add(root.right);


         while (!deque.isEmpty()){
             TreeNode left = deque.poll();
             TreeNode right = deque.poll();


             if (left == null && right == null) {
                 continue;
             }
             if (left == null || right == null) {
                 return false;
             }
             if (left.val != right.val) {
                 return false;
             }


             deque.add(left.left);
             deque.add(right.right);
             deque.add(left.right);
             deque.add(right.left);


         }

         return true;
    }

    public boolean isSymetric(TreeNode root){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root.left);
        queue.add(root.right);
        return false;
    }

    public boolean isCousins(TreeNode root, int x, int y){
        if(root ==null)

    {
        return false;
    }

    Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty())

    {
        int levelSize = queue.size();
        boolean foundX = false;
        boolean foundY = false;

        for (int i = 0; i < levelSize; i++) {
            TreeNode current = queue.poll();

            if (current.val == x) {
                foundX = true;
            }
            if (current.val == y) {
                foundY = true;
            }

            if (current.left != null && current.right != null) {
                // Check if x and y are siblings
                if ((current.left.val == x && current.right.val == y) ||
                        (current.left.val == y && current.right.val == x)) {
                    return false;
                }
            }

            if (current.left != null) {
                queue.offer(current.left);
            }
            if (current.right != null) {
                queue.offer(current.right);
            }
        }

        // If both x and y are found at the same level, return true
        if (foundX && foundY) {
            return true;
        }

        // If only one of them is found, they are not cousins
        if (foundX || foundY) {
            return false;
        }
    }

        return false; // If neither x nor y are found
}


    public static void main(String[] args) {
        BFS solution = new BFS();

        // Create a sample binary tree
        TreeNode root = solution.new TreeNode(1);
        root.left = solution.new TreeNode(2);
        root.right = solution.new TreeNode(3);
        root.left.left = solution.new TreeNode(4);
        root.left.right = solution.new TreeNode(5);
        root.right.left = solution.new TreeNode(6);
        root.right.right = solution.new TreeNode(7);

        // Test the zigzagLevelOrder method
        /*List<List<Integer>> zigzagResult = solution.zigzagLevelOrder(root);
        System.out.println("Zigzag Level Order: " + zigzagResult);

        // Test the averageOfLevels method
        List<Double> averageResult = solution.averageOfLevels(root);
        System.out.println("Average of Levels: " + averageResult);

        // Test the findSuccessor method
        TreeNode successor = solution.findSuccessor(root, 3);
        System.out.println("Successor of 3: " + (successor != null ? successor.val : "null"));*/

        //TreeNode ans = solution.connect(root);
        //List<Integer> ans = solution.rightSideView(root);
        boolean a = solution.isCousins(root , 4 ,7);
    }
}
