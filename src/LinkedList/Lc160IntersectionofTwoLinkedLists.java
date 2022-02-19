package LinkedList;

/**
 * @ClassName: Lc160IntersectionofTwoLinkedLists
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/4/22 4:16 pm
 * @Version 1.0
 */
public class Lc160IntersectionofTwoLinkedLists {
    // Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
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
}

