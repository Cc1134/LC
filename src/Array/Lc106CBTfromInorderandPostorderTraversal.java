package Array;

import java.util.Arrays;

public class Lc106CBTfromInorderandPostorderTraversal {
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

    // 106. 从中序与后序遍历序列构造二叉树
    // 中序遍历：{左子树的中序遍历}[根节点]{右子树的中序遍历}
    // 后序遍历：{左子树的前序遍历}{右子树的前序遍历}[根节点]
    // 根据后序遍历，可以确定根节点的取值
    // 在中序遍历中查找根节点，可以确定左子树和右子树的元素数量
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        assert postorder.length == inorder.length; // 两种遍历法表示了同一棵树，那么遍历出来的节点数量应当永远相同
        if (postorder.length == 0) { // 空的遍历序列，得到null
            return null;
        }
        // 根据后序遍历的最后一个取值，也就是根节点的取值，确定根节点在中序遍历里的下标
        int valueOfRoot = postorder[postorder.length - 1];
        int indexOfRoot = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == valueOfRoot) {
                indexOfRoot = i;
                break;
            }
        }
        TreeNode node = new TreeNode(valueOfRoot);
        node.left = buildTree(
                Arrays.copyOfRange(inorder, 0, indexOfRoot), // 切分出左子树的中序遍历
                Arrays.copyOfRange(postorder, 0, indexOfRoot) // 切分出左子树的后序遍历
        );
        node.right = buildTree(
                Arrays.copyOfRange(inorder, indexOfRoot + 1, inorder.length), // 切分出右子树的中序遍历
                Arrays.copyOfRange(postorder, indexOfRoot, postorder.length - 1) // 切分出右子树的后序遍历
        );
        return node;
    }

}
