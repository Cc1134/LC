package DFS;

/**
 * @ClassName: Lc226InvertBinaryTree
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/2/22 6:35 pm
 * @Version 1.0
 */
public class Lc226InvertBinaryTree {
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

    void dfs(TreeNode root){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            return;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        dfs(root.left);
        dfs(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        dfs(root);
        return root;
    }
}

