package Tree;

/**
 * @ClassName: Lc114FlattenBinaryTreetoLinkedList
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/31/22 5:24 pm
 * @Version 1.0
 */
public class Lc114FlattenBinaryTreetoLinkedList {
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
    void concatenateLinkedList(TreeNode headA, TreeNode headB){
        TreeNode tailA = headA;
        while(tailA != null){
            tailA = tailA.right;
        }
        tailA.right = headB;
    }
    void expandToRightLinkGuard(TreeNode node){
        // 输入子树的根节点node，将会把子树展开为右链表
        // 只有没有子树的两种情况：null或叶子节点，这时可以肯定node已经是
        // 有一个元素或者0个元素的右链表
        if(node == null || node.left == null && node.right == null){
            return;
        }
        //如果有左子树，那么先将左子树展开为右链表
        if(node.left != null){
            expandToRightLinkGuard(node.left);
        }
        if(node.right != null){
            expandToRightLinkGuard(node.right);
        }
        //特判：如果没有左子树，在上文又已经展开了右子树，因此整体已经构成右链表，不必再操作
        if (node.left == null) {
            return;
        }
        //当左子树不是null时，将左子树的右链表和右子树的右链表拼起来

        TreeNode leftHead = node.left;
        TreeNode rightHead = node.right;
        concatenateLinkedList(leftHead, rightHead);
        node.left = null;
        node.right = leftHead;

    }
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        expandToRightLinkGuard(root);
    }

}

