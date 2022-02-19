package LinkedList;

/**
 * @ClassName: rotateList
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/23/22 3:16 pm
 * @Version 1.0
 */
public class Lc61RotateList {


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


    ListNode indexOf(ListNode head, int index) {
        // 输入index，找到链表的第index个节点(下标从1开始计数)
        for (int i = 1; i < index; i++) {
            head = head.next;
        }
        return head;
    }

    int countLinkList(ListNode head) { // 数出链表的节点数量
        int count = 0;
        while (head != null){
            head = head.next;
            count++;
        }
        return count;
    }

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){ // 如果链表是空的，或者链表只有一个元素，那么直接返回链表本身
            return head;
        }
        int count = this.countLinkList(head);

        k = k % count; // 对k取k%count

        if(k == 0){
            return head;
        }//在k==0的时候 --> index = "count + 1" --> index就会指向一个null，那么current就是指向了一个null,那么43行就会得到一个空指针，所以会返回一个空链表所以在这里需要做一个特判

        int index = this.countLinkList(head) - k + 1; // 计算index
        ListNode prev = this.indexOf(head, index - 1); // “4”的前序节点
        ListNode current = this.indexOf(head, index); //第一个例子中的“4”，倒数第二个节点
        ListNode tail = this.indexOf(head, count); // 原先的尾节点

        tail.next = head;// 把head连接到tail的下一个
        prev.next = null;// 把prev的下一个设置成null
        return current;
    }

}