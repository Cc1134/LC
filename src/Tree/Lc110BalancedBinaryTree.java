package Tree;

/**
 * @ClassName: Lc110BalancedBinaryTree
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/30/22 6:44 pm
 * @Version 1.0
 */
public class Lc110BalancedBinaryTree {
    //Definition for a binary tree node.
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

    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            if(leftDepth == -1 || rightDepth == -1){
                return -1;
            }
            if(Math.abs(leftDepth - rightDepth) > 1){
                return -1;
            }
            return Math.max(leftDepth,rightDepth) + 1;
        }

    }

    public boolean isBalanced(TreeNode root) {
        int treeDepth = maxDepth(root);
        if(treeDepth != -1){
            return true;
        }else {
            return false;
        }
    }
}

