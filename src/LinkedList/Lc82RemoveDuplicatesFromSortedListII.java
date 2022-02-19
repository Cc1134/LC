package LinkedList;

/**
 * @ClassName: RemoveDuplicatesFromSortedListII
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/23/22 6:35 pm
 * @Version 1.0
 */
public class Lc82RemoveDuplicatesFromSortedListII {


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
    ListNode mycurr;

    void insert(ListNode node) {
        if (myhead == null) {
            myhead = node;
            mycurr = myhead;
        } else {
            mycurr.next = node;
            mycurr = mycurr.next;
        }
        mycurr.next = null;
    }

    ListNode roll() { // 把head向后(next)指向下一格，并且返回原先曾作为head的上一个元素，在roll[n+1]次时返回null
        ListNode orgin = null;
        if (head != null){
            orgin = head;
            head = head.next;
        }
        return orgin;
    }

    public ListNode deleteDuplicates(ListNode head) {
        this.head = head;
        if (head == null || head.next == null) {
            return head;
        }
        while (true) {
            ListNode temp = roll();
            if (temp == null) { // 遍历已经完成
                return myhead;
            }
            //"temp节点有next" 并且 "temp节点的next的val与temp相等"
            if (temp.next != null && temp.next.val == temp.val) { // 遇到了连续的两个val一样的节点
                int value = temp.val; // 这组val一样的节点，它们的val取值是什么
                while (this.head != null && this.head.val == value) { // 后继的节点的val还是value
                    roll();
                }
            } else { // 这个val是单独的
                insert(temp);
            }
        }
    }
}

