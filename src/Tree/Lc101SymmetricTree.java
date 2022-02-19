package Tree;

/**
 * @ClassName: Lc101SymmetricTree
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/29/22 1:30 pm
 * @Version 1.0
 */
public class Lc101SymmetricTree {

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
    // 101. 对称二叉树
    boolean isSymmetricLR(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        //左或右存在null
        if(left == null || right == null){
            return false;
        }
        //左和右的val不同
        if(left.val != right.val){
            return false;
        }
        //左节点的右子节点镜像对称于右节点的左子节点 && 左节点的左子节点镜像对称于右节点的右子节点
        if(isSymmetricLR(left.left,right.right) && isSymmetricLR(left.right, right.left)){
            return true;
        }else{
            return false;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        if(root == null){
            return true;
        }
        //树的左子节点镜像对称于右子节点
        if(isSymmetricLR(root.left,root.right)){
            return true;
        }else{
            return false;
        }
    }

}

