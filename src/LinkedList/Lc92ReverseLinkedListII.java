package LinkedList;

/**
 * @ClassName: Lc92ReverseLinkedListII
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/24/22 5:15 pm
 * @Version 1.0
 */
public class Lc92ReverseLinkedListII {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    ListNode head;
    ListNode myhead;

    public ListNode roll(){
        ListNode origin = head;
        if(head != null){
            head = head.next;
        }
        return origin;
    }

    public void insertToHead(ListNode node){

        node.next = myhead;
        myhead = node;

    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }

        this.head = head;
        ListNode leftTail = null;
        for (int i = 0; i < left - 1; i++) {
            leftTail = roll();
        }

        ListNode middleHead = null;
        ListNode middleTail = null;
        for (int j = 0; j < right - left + 1; j++) { // 2
            ListNode node = null;
            node = roll();
            if (j == 0) {
                middleTail = node;
            }
            middleHead = node;
            insertToHead(middleHead);
        }


        ListNode rightHead = roll();

        //第一个和第二个链表连起来
        if (leftTail != null) {
            myhead = head;
            leftTail.next = middleHead;
        } else {
            myhead = middleHead;
        }

        //第二个和第三个链表连起来
        middleTail.next = rightHead;
        return myhead; // 第一个链表的链表头

    }

}

