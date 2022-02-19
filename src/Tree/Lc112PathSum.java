package Tree;

/**
 * @ClassName: Lc112PathSum
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/31/22 2:52 pm
 * @Version 1.0
 */
public class Lc112PathSum {
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

    public boolean hasPathSum(TreeNode root, int targetSum) {
        boolean ans;
        if(root == null){
            ans = false;
        }else if(root.val == targetSum && (root.left == null && root.right == null)){
            ans = true;
        }else {
            ans = (hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val));
        }
        return ans;
    }
}

