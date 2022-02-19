package LinkedList;

/**
 * @ClassName: Solution
 * @Description:
 * @Author Cassie Chen
 * @Date 1/21/22 10:16 pm
 * @Version 1.0
 *
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 *
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 *
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 *
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class Lc2AddTwoNumbers {

    //if l1 & l2 are in the same length, ans = l1.val + l2.val

    //if l1 has more digits, then for the rest of l1, ans.val = l1.val + 0

    //if l2 has more digits, then for the rest of l2, ans.val = l2.val + 0

    //if l1.val + l2.val >= 10, ans -= 10
    // & ans.next.val = l1.next.val + l2.next.val + 1
    //if no more l1.next or l2.next, then ans.val = 1

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode current = null;
        int ans = 0;
        boolean carryDigit = false;
        while(l1 != null || l2 != null){
            ans = ((l1 == null)?0: l1.val) + ((l2 == null)?0: l2.val) + ((carryDigit)?1:0);
            if(ans > 10){
                ans = ans % 10;
                carryDigit = true;
            }else{
                carryDigit = false;
            }

            if(current == null){
                head = new ListNode(ans);
                current = head;

            }else {
                current.next = new ListNode(ans);
                current = current.next;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }

        }
        if(carryDigit){
            current.next = new ListNode(1);
        }
        return head;
    }



}

