package LinkedList;

/**
 * @ClassName: removeNthNodeFromEndOfList
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/22/22 4:51 pm
 * @Version 1.0
 */
public class Lc19RemoveNthNodeFromEndOfList {


      //Definition for singly-linked list.
      public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


        public ListNode removeNthFromEnd(ListNode head, int n) {
          if (head == null){
              return null;
          }

          int count = 0;
          int count2 = 1;
          int index = 0;
          ListNode temp = head;
          while(head != null){
              head = head.next;
              count++;
          }
          index = count - n + 1;
          head = temp;
          while (head != null){
              if(count2 == index){
                  head = head.next.next;
              }
              head = head.next;
              count2++;
          }
          return head;
        }
    }


