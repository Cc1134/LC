package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName: Lc113PathSumII
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/31/22 3:49 pm
 * @Version 1.0
 */
public class Lc113PathSumII {
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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return new ArrayList<>();
        } else if (root.left == null && root.right == null) {

            List<List<Integer>> ans = new ArrayList<>();

            if (root.val == targetSum) {
                List<Integer> path = new LinkedList<Integer>();
                path.add(root.val);
                ans.add(path);
            }
            return ans;
        } else {
            List<List<Integer>> leftPath = pathSum(root.left, targetSum - root.val);
            List<List<Integer>> rightPath = pathSum(root.right, targetSum - root.val);
            ArrayList<List<Integer>> myans = new ArrayList<>();
            for (List<Integer> path : leftPath){
                path.add(0,root.val);
                myans.add(path);
            }
            for (List<Integer> path : rightPath){
                path.add(0,root.val);
                myans.add(path);
            }
            return myans;
        }
    }
}

