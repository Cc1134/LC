package Tree;

/**
 * @ClassName: Lc104MaximumDepthofBinaryTree
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/29/22 1:31 pm
 * @Version 1.0
 */
public class Lc104MaximumDepthofBinaryTree {
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
    // 104. 二叉树的最大深度
    public int maxDepth(TreeNode root) {
        //树是null
        if(root == null){
            return 0;
        }else{
            return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
        }
    }
}

