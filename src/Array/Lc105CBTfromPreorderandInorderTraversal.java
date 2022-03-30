package Array;

import java.util.Arrays;

public class Lc105CBTfromPreorderandInorderTraversal {

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


    // 105. 从前序与中序遍历序列构造二叉树
    // 前序遍历：[根节点]{左子树的前序遍历}{右子树的前序遍历}
    // 中序遍历：{左子树的中序遍历}[根节点]{右子树的中序遍历}
    // 根据前序遍历，可以确定根节点的取值
    // 在中序遍历中查找根节点，可以确定左子树和右子树的元素数量
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        assert preorder.length == inorder.length; // 两种遍历法表示了同一棵树，那么遍历出来的节点数量应当永远相同
        if (preorder.length == 0) { // 空的遍历序列，得到null
            return null;
        }
        // 根据前序遍历的第一个取值，也就是根节点的取值，确定根节点在中序遍历里的下标
        int valueOfRoot = preorder[0];
        int indexOfRoot = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == valueOfRoot) {
                indexOfRoot = i;
                break;
            }
        }
        TreeNode node = new TreeNode(valueOfRoot);
        node.left = buildTree(
                Arrays.copyOfRange(preorder, 1, indexOfRoot + 1), // 切分出左子树的前序遍历
                Arrays.copyOfRange(inorder, 0, indexOfRoot) // 切分出左子树的中序遍历
        );
        node.right = buildTree(
                Arrays.copyOfRange(preorder, indexOfRoot + 1, preorder.length), // 切分出右子树的前序遍历
                Arrays.copyOfRange(inorder, indexOfRoot + 1, inorder.length) // 切分出右子树的中序遍历
        );
        return node;
    }

}
