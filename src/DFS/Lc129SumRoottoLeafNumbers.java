package DFS;

/**
 * @ClassName: Lc129SumRoottoLeafNumbers
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/2/22 4:18 pm
 * @Version 1.0
 */
public class Lc129SumRoottoLeafNumbers {
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

    int sumOfLeavesOnChildTree(TreeNode root, int parentValue){
        parentValue = parentValue*10 + root.val;
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null && parentValue == 0){
            return root.val;
        }
        if(root.left == null && root.right == null){
            //当前节点的值？
            return parentValue*10+root.val;
        }
        parentValue = parentValue*10 + root.val;
        return sumOfLeavesOnChildTree(root.left, parentValue) + sumOfLeavesOnChildTree(root.right, parentValue);
    }

    public int sumNumbers(TreeNode root) {
        return sumOfLeavesOnChildTree(root, 0);
    }

}

