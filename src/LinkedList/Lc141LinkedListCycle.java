package LinkedList;

/**
 * @ClassName: Lc141LinkedListCycle
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/3/22 2:58 pm
 * @Version 1.0
 */
public class Lc141LinkedListCycle {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //141. 环形链表
    public boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode ptr1 = head; // 慢指针
        ListNode ptr2 = head; // 快指针
        while(true){
            ptr2 = ptr2.next; // 快指针向前走一步
            if(ptr2 == null){
                return false; // 如果快指针走到null了，返回“没有环”
            }
            if(ptr2 == ptr1){ // 如果快指针走到跟慢指针是同一个元素
                return true; // 说明慢指针被套圈了，说明有环
            }
            ptr2 = ptr2.next; // 快指针再向前走一步
            if(ptr2 == null){
                return false;
            } // 如果快指针走到null了，返回“没有环”
            if(ptr2 == ptr1){
                return true;
            } // 如果快指针走到跟慢指针是同一个元素，返回“有环”
            ptr1 = ptr1.next; // 慢指针向前走一步
        }
    }

}

