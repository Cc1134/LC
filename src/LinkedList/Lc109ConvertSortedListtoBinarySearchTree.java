package LinkedList;

/**
 * @ClassName: Lc109ConvertSortedListtoBinarySearchTree
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/3/22 2:22 pm
 * @Version 1.0
 */
public class Lc109ConvertSortedListtoBinarySearchTree {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }


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


    // 109. 有序链表转换二叉搜索树
    TreeNode bst(ListNode head, int count) {
        //输入以head为头节点、共有count个节点的链表(不保证第count个节点以.next=null封尾)
        //返回基于head构造出的二叉搜索树(bst)
        int right = (count-1)/2; // 右子树节点个数
        int left = count-1-right; // 左子树节点个数
        ListNode node = head;
        for(int i = 0; i < left; i++){
            node = node.next; //使node最终指向左子树、右子树之间的根节点元素(在链表上的对应节点)
        }
        TreeNode root = new TreeNode(node.val); // 从根节点的.val建立根节点对象
        if(left > 0){
            root.left = bst(head, left); // 使用链表的前半段建立左子树
        }
        if(right > 0){
            root.right = bst(node.next, right); // 使用链表的后半段建立右子树
        }
        return root;
    }
    public TreeNode sortedListToBST(ListNode head) {
        //空链表
        if(head == null){
            return null;
        }
        int count = 0;
        ListNode current = head;
        while(current != null){
            current = current.next;
            count++;// 统计链表节点的个数
        }
        return bst(head, count); // 返回构造出的二叉树
    }

}

