package Tree;


/**
 * @ClassName: Lc100SameTree
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/29/22 1:09 pm
 * @Version 1.0
 */
public class Lc100SameTree {


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

    // 100. 相同的树
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //p和q节点都是null
        if (p == null && q == null) {
            return true;
        }
        //(又不都是null,因为都null的情况在上一个if解决了)
        if (p == null || q == null ) {
            return false;
        }
        //p和q的val不同
        if (p.val != q.val) {
            return false;
        }
        //p和q的俩左节点相同，且它俩右节点相同
        if (isSameTree(p.left,q.left) && isSameTree(p.right,q.right)) {
            return true;
        } else {
            return false;
        }
    }

}

