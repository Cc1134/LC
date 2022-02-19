package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Lc199BinaryTreeRightSideView
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/1/22 4:35 pm
 * @Version 1.0
 */
public class Lc199BinaryTreeRightSideView {
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

//    public List<Integer> rightSideView(TreeNode root) {
//        List<Integer> ans = new ArrayList<>();
//        //遍历一棵以root为根的(子)树
//        //返回这棵(子)树的右视图
//        //右视图由左子树的右视图为基础，
//        //将右子树的右视图覆盖上去而得到
//        if (root == null) {
//            return ans;
//        }
//        if (root.left == null && root.right == null) {
//            ans.add(root.val);
//            return ans;
//        }
//        //剩下一种没处理的情况：当前节点不是叶子节点
//        List<Integer> viewLeft = rightSideView(root.left);
//        List<Integer> viewRight = rightSideView(root.right);
//        if (viewRight.size() >= viewLeft.size()) {
//            ans = viewRight;
//            ans.add(0, root.val);
//            return ans;
//        }
//
//        for (int level = 0; level <= viewRight.size() - 1; level++) {
//            viewLeft.set(level, viewRight.get(level));
//        }
//        viewLeft.add(0, root.val);
//        return viewLeft;
//    }

    List<Integer> merge(List<Integer> viewLeft, List<Integer> viewRight, TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (viewRight.size() >= viewLeft.size()) {
            list = viewRight;
            list.add(0, root.val);
            return list;
        }

        for (int level = 0; level <= viewRight.size() - 1; level++) {
            viewLeft.set(level, viewRight.get(level));
        }

        viewLeft.add(0, root.val);
        return viewLeft;
    }

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        //遍历一棵以root为根的(子)树
        //返回这棵(子)树的右视图
        //右视图由左子树的右视图为基础，
        //将右子树的右视图覆盖上去而得到
        if (root == null) {
            return ans;
        }
        if (root.left == null && root.right == null) {
            ans.add(root.val);
            return ans;
        }
        //剩下一种没处理的情况：当前节点不是叶子节点
        List<Integer> viewLeft = rightSideView(root.left);
        List<Integer> viewRight = rightSideView(root.right);

        return merge(viewLeft,viewRight,root);
    }
}

