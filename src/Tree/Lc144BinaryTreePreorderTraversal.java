package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Lc144BinaryTreePreorderTraversal
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/29/22 4:59 pm
 * @Version 1.0
 */
public class Lc144BinaryTreePreorderTraversal {
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

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        dfs(root,ans);
        return ans;
    }

    public void dfs(TreeNode root, List<Integer> ans ){
        if (root == null){
            return;
        }
        int value = root.val;
        ans.add(value);
        dfs(root.left, ans);
        dfs(root.right, ans);
    }
}

