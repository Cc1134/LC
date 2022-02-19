package LinkedList;

/**
 * @ClassName: RemoveDuplicatesfromSortedList
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/23/22 4:10 pm
 * @Version 1.0
 */
public class Lc83RemoveDuplicatesfromSortedList {

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


    ListNode myhead; // 自己新构造的链表的头
    ListNode mycurr; // 当前的自己的链表最后一次插入的节点

    public void insert(ListNode node) { // 向自己的链表(myhead,mycurr)插入一个新的节点
        if (myhead == null) {
            myhead = node;
            mycurr = myhead;
        } else {
            //插入其他节点
            mycurr.next = node;
            mycurr = mycurr.next;
        }
        mycurr.next = null;
    }

    public ListNode deleteDuplicates(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }
        while (head != null) {
            ListNode temp = null;
            temp = head;// roll
            head = head.next;
            //你自己的链表(myhead, mycurr) 的最后一项的.val不等于新提取出的链表节点.val
            if (mycurr == null || temp.val != mycurr.val) {
                insert(temp);
            }
        }

/*        [prev, next]
        if (prev.val == next.val) {
            prev.next = next.next.next;
        }*/
        return myhead;
    }

}


