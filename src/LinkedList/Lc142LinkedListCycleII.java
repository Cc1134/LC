package LinkedList;

/**
 * @ClassName: Lc142LinkedListCycleII
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/4/22 9:07 pm
 * @Version 1.0
 */

??
public class Lc142LinkedListCycleII {
    // Definition for singly-linked list.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    //参考160题。找到双头链表的交点
    //如果从循环的点的后面砍断，那么就形成了一个双头链表
    //一个头是原来那个头，另一个头是相交点后面那个节点
    public ListNode hasCycle(ListNode head) {
        if(head == null){
            return head;
        }
        ListNode ptr1 = head; // 慢指针
        ListNode ptr2 = head; // 快指针
        while(true){
            ptr2 = ptr2.next; // 快指针向前走一步
            if(ptr2 == null){
                return null; // 如果快指针走到null了，返回“没有环”
            }
            if(ptr2 == ptr1){ // 如果快指针走到跟慢指针是同一个元素
                break; // 说明慢指针被套圈了，说明有环
            }
            ptr2 = ptr2.next; // 快指针再向前走一步
            if(ptr2 == null){
                return null;
            } // 如果快指针走到null了，返回“没有环”
            if(ptr2 == ptr1){
                break;
            } // 如果快指针走到跟慢指针是同一个元素，返回“有环”
            ptr1 = ptr1.next; // 慢指针向前走一步
        }
        return ptr2;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = 0;
        int countB = 0;
        ListNode myheadA = headA;
        ListNode myheadB = headB;
        while(myheadA != null){
            myheadA = myheadA.next;
            countA++;
        }
        while(myheadB != null){
            myheadB = myheadB.next;
            countB++;
        }
        myheadA = headA;
        myheadB = headB;
        if(countA <= countB){
            int step = countB - countA;
            for (int i = 0; i < step; i++) {
                myheadB = myheadB.next;
            }
        }else {
            int step = countA - countB;
            for (int i = 0; i < step; i++) {
                myheadA = myheadA.next;
            }
        }
        while(myheadA != myheadB){
            myheadA = myheadA.next;
            myheadB = myheadB.next;
        }
        return myheadA;
    }

    public ListNode detectCycle(ListNode head) {
        ListNode head1 = head;
        ListNode head2 = hasCycle(head).next;
        return getIntersectionNode(head1,head2);

    }

//    public ListNode detectCycle(ListNode head) {
//        if(head == null){
//            return null;
//        }
//        ListNode ptr1 = head; // 慢指针
//        ListNode ptr2 = head; // 快指针
//        while(true){
//            ptr2 = ptr2.next; // 快指针向前走一步
//            if(ptr2 == null){
//                return null; // 如果快指针走到null了，返回“没有环”
//            }
//            if(ptr2 == ptr1){ // 如果快指针走到跟慢指针是同一个元素
//                break; // 说明慢指针被套圈了，说明有环
//            }
//            ptr2 = ptr2.next; // 快指针再向前走一步
//            if(ptr2 == null){
//                return null;
//            } // 如果快指针走到null了，返回“没有环”
//            if(ptr2 == ptr1){
//                break;
//            } // 如果快指针走到跟慢指针是同一个元素，返回“有环”
//            ptr1 = ptr1.next; // 慢指针向前走一步
//        }
//        ListNode headA = head;
//        ListNode headB = ptr1.next;
//        ptr1.next = null;
//
//        int countA = 0;
//        int countB = 0;
//        ListNode myheadA = headA;
//        ListNode myheadB = headB;
//        while(myheadA != null){
//            myheadA = myheadA.next;
//            countA++;
//        }
//        while(myheadB != null){
//            myheadB = myheadB.next;
//            countB++;
//        }
//        myheadA = headA;
//        myheadB = headB;
//        if(countA <= countB){
//            int step = countB - countA;
//            for (int i = 0; i < step; i++) {
//                myheadB = myheadB.next;
//            }
//        }else {
//            int step = countA - countB;
//            for (int i = 0; i < step; i++) {
//                myheadA = myheadA.next;
//            }
//        }
//        while(myheadA != myheadB){
//            myheadA = myheadA.next;
//            myheadB = myheadB.next;
//        }
//        return myheadA;
//    }

}

