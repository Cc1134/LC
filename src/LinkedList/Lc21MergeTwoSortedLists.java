package LinkedList;

/**
 * @ClassName: Lc21MergeTwoSortedLists
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/24/22 7:30 am
 * @Version 1.0
 */
public class Lc21MergeTwoSortedLists {
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


    ListNode myhead;
    ListNode mycurr;
    ListNode list1;
    ListNode list2;

    /*
    为什么不能写一个roll(ListNode node)的函数?
    如果把list1和list2当参数传进去，拿到node之后，list1和list2是没有被滚动的
    ListNode node1 = roll(list1); 滚动链表1的链表头
        ListNode tempParamValue = list1;
        ListNode returnValue;
            {
                ListNode node = tempParamValue;
                ListNode origin = node;
                if(node != null){
                    node = node.next;
                }
                returnValue = origin; // return origin
            }
            ListNode node1 = returnValue;
    */
    ListNode roll1(){
        ListNode origin = list1;
        if(list1 != null){
            list1 = list1.next;
        }
        return origin;
    }

    ListNode roll2(){
        ListNode origin = list2;
        if(list2 != null){
            list2 = list2.next;
        }
        return origin;
    }

    void insert(ListNode node){
        if(myhead == null){
            myhead = node;
            mycurr = myhead;
        }else {
            mycurr.next = node;
            mycurr = mycurr.next;
        }

    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        this.list1 = list1;
        this.list2 = list2;
        while (this.list1 != null || this.list2 != null) { // 两个链表之中有任意一个还没结束的情况下，循环
            ListNode temp = null; // 用来暂存将被插入链表的节点
            if (this.list1 != null && ((this.list2 == null) || (this.list2 != null && this.list1.val <= this.list2.val))) { // 插入链表1而不是链表2的条件(链表1或链表2有空null的情况都需要考虑到)
                temp = this.list1; // 设置temp变量
                roll1(); //滚动链表1的链表头
            } else {
                temp = this.list2; // 设置temp变量
                roll2(); //滚动链表2的链表头
            }
            //到这里，temp变量已经设置好
            //把temp插入自己的链表里
            insert(temp);
        }
        return myhead; // 返回头节点
    }

//    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
//        ListNode head = null;
//        ListNode current = null;
//        while (list1 != null || list2 != null) { // 两个链表之中有任意一个还没结束的情况下，循环
//            ListNode temp = null; // 用来暂存将被插入链表的节点
//            if (list1 != null && ((list2 == null) || (list2 != null && list1.val <= list2.val))) { // 插入链表1而不是链表2的条件(链表1或链表2有空null的情况都需要考虑到)
//                temp = list1; // 设置temp变量
//                list1 = list1.next; //滚动链表1的链表头
//            } else {
//                temp = list2; // 设置temp变量
//                list2 = list2.next; //滚动链表2的链表头
//            }
//            //到这里，temp变量已经设置好
//            //把temp插入自己的链表里
//            if (head == null) { // 对插入头节点的情况进行特殊处理
//                head = temp;
//                current = head;// 插入头节点
//            } else {
//                current.next = temp;
//                current = current.next;// 插入其他节点
//            }
//        }
//        return head; // 返回头节点
//    }


    //method2
    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null){
            return list2;
        }else if(list2 == null){
            return list1;
        }else if(list1.val > list2.val){
            list2.next = mergeTwoLists2(list1,list2.next);
            return list2;
        }else {
            list1.next = mergeTwoLists2(list1.next,list2);
            return list1;
        }
    }

}

