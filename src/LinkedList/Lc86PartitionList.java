package LinkedList;

/**
 * @ClassName: Lc86PartitionList
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/25/22 5:00 pm
 * @Version 1.0
 */
public class Lc86PartitionList {
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

    ListNode head;


    ListNode roll() {
        ListNode origin = head;
        if (head != null) {
            head = head.next;
        }
        return origin;
    }

    void insert(ListNode[] listNodes, ListNode node) {
        ListNode myhead = listNodes[0];
        ListNode mycurr = listNodes[1];

        if (myhead == null) {
            myhead = node;
            mycurr = myhead;
        } else {
            mycurr.next = node;
            mycurr = mycurr.next;
        }
        listNodes[0] = myhead;
        listNodes[1] = mycurr;
    }

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode[] left = new ListNode[2];

        ListNode[] right = new ListNode[2];

        this.head = head;
        while (this.head != null) {
            ListNode mynode = roll();

            if (mynode.val < x) {
                insert(left, mynode);
            } else {
                insert(right, mynode);
            }
        }
        if (left[0] == null){
            return right[0];
        }else if (right[0] == null){
            return left[0];
        }else{
            left[1].next = right[0];
            right[1].next = null;
            return left[0];
        }
    }

}




