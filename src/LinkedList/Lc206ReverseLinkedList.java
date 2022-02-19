package LinkedList;

/**
 * @ClassName: Lc206ReverseLinkedList
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/24/22 3:42 pm
 * @Version 1.0
 */
public class Lc206ReverseLinkedList {
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
    ListNode myhead;


    ListNode roll(){
        ListNode origin = null;
        if(head != null){
            origin = head;
            head = head.next;
        }
        return origin;
    }

    //在这个情况下，head == null是valid，roll()和insert()就完全对称了。
    void insertToHead(ListNode node){
//        if(myhead == null){
//            myhead = node;
//            myhead.next = null;
//        }else{
            node.next = myhead;
            myhead = node;
//        }

    }
    public ListNode reverseList(ListNode head) {
        this.head = head;
        if(head == null || head.next == null){
            return head;
        }
        while(this.head != null){
            insertToHead(roll());
        }
        return myhead;
    }
}

