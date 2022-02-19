package Tree;

/**
 * @ClassName: Lc111MinimumDepthofBinaryTree
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/30/22 11:29 pm
 * @Version 1.0
 */

public class Lc111MinimumDepthofBinaryTree {
    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
    }

    public int minDepth(TreeNode root) {

        if(root == null){
            return 0;
        }
        if ((root.left == null) && (root.right == null)){
            return 1;
        }
        if(root.left == null){
            return minDepth(root.right) + 1;
        }
        if(root.right == null){
            return minDepth(root.left) + 1;
        }
        int left = minDepth(root.left);
        int right = minDepth(root.right);

        return Math.min(left,right) + 1;
    }
}

