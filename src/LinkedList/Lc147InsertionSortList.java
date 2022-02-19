package LinkedList;

/**
 * @ClassName: Lc147InsertionSortList
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/4/22 4:59 pm
 * @Version 1.0
 */

??
public class Lc147InsertionSortList {
    // Definition for singly-linked list.
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
    public ListNode insertionSortList(ListNode head) {

        if(head == null || head.next == null){
            return head;
        }

        ListNode myhead = head;
        ListNode mycurr = myhead;
        while (head != null){

            head = head.next;
            if(head.val > mycurr.val){
                mycurr.next = head;
                mycurr = mycurr.next;
            }else {
                ListNode traverseHead = myhead;
                while(traverseHead != null){
                    if(head.val < traverseHead.val){
                        ListNode temp = myhead;
                        myhead = head;
                        myhead.next = temp;
                    }
                    traverseHead = traverseHead.next;
                }
            }
        }
        return myhead;
    }
}

