package LinkedList;

/**
 * @ClassName: SwapNodesInPairs
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/23/22 5:39 pm
 * @Version 1.0
 */
public class Lc24SwapNodesInPairs {
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

    ListNode head; // 题目所输入的链表的头
    ListNode myhead; // 自己新构造的链表的头
    ListNode mycurr; // 当前的自己的链表最后一次插入的节点

    public ListNode roll(){ // 取出题目给的链表的头，并且把题目给的链表向下滚动一步

        ListNode orgin = null;
        //记得要考虑链表头已经滚动到null的情况，不要null exception
        if(this.head != null){
            orgin = this.head;
            this.head = this.head.next;
        }
        return orgin;
    }

    public void insert(ListNode node){ // 向自己的链表(myhead,mycurr)插入一个新的节点
        if(myhead == null){
            myhead = node;
            mycurr = myhead;//插入头节点
        }else{
            mycurr.next = node;
            mycurr = mycurr.next;//插入其他节点
        }
        this.mycurr.next = null; // 对最新插入的节点的"mycurr.next"记得封尾
    }

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            //链表是空的，或者链表元素达不到2，都可以直接返回原链表
            return head;
        }
        this.head = head; // 对this对象中的head变量做初始化
        ListNode left; // 声明左节点
        ListNode right; // 声明右节点
        while(true){
            left = roll(); // 取出左节点
            if(left == null){ // 左节点是null的时候，停止循环
                break;// 打断循环
            }
            right = roll(); // 取出右节点
            if(right == null){ // 右节点是null的时候，停止循环
                insert(left); // 如果右节点是null，那么在停止循环之前，把提取出来的左节点记得插入回去
                break;// 打断循环
            }
            // 在其他循环不被打断的情况下
            // 反向插入两个节点
            insert(right); // 插入右节点
            insert(left); // 插入左节点
        }
        return this.myhead; // 返回自己的链表
    }
}

