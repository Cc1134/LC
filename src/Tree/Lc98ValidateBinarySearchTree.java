package Tree;

/**
 * @ClassName: isValidBST
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/30/22 4:39 pm
 * @Version 1.0
 */
public class Lc98ValidateBinarySearchTree {
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

    int[] findMinMaxOfChildTree(TreeNode root) {
        //初始化：从假设root节点没有子节点开始
        //也就是暂时假设root是叶子节点
        int[] minmax = new int[]{root.val, root.val};
        if (root.left != null) {
            int[] leftRootMinmax = findMinMaxOfChildTree(root.left);
            if (leftRootMinmax == null) {
                return null;
            }
            //把左子树的最大值与root的取值做大小比较、检查
            if (leftRootMinmax[1] >= root.val) {
                return null;
            }
            //根据左子树的取值范围，修正整棵树root的取值范围
            minmax[0] = leftRootMinmax[0];
        }
        if (root.right != null) {
            int[] rightRootMinmax = findMinMaxOfChildTree(root.right);
            //把右子树的最小值与root的取值做大小比较、检查
            if (rightRootMinmax == null) {
                return null;
            }
            if (rightRootMinmax[0] <= root.val) {
                return null;
            }
            //根据右子树的取值范围，修正整棵树root的取值范围
            minmax[1] = rightRootMinmax[1];
        }
        //返回当前这棵树的取值范围
        return minmax;
    }
    public boolean isValidBST(TreeNode root) {
        int[] minmax = findMinMaxOfChildTree(root);
        if(minmax == null){
            return false;
        }else if(minmax[0] <= minmax[1]){
            return true;
        }else {
            return false;
        }
    }

}

