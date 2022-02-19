package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Lc94BinaryTreeInorderTraversal
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/29/22 5:37 pm
 * @Version 1.0
 */
public class Lc94BinaryTreeInorderTraversal {
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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if(root == null){
            return ans;
        }
        traverse(root,ans);
        return ans;
    }

    public void traverse(TreeNode root, List<Integer> ans){
        if(root == null){
            return;
        }
        traverse(root.left,ans);
        ans.add(root.val);
        traverse(root.right,ans);
    }
}

