package LinkedList;

/**
 * @ClassName: Lc138CopyListwithRandomPointer
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/4/22 12:20 pm
 * @Version 1.0
 */
public class Lc138CopyListwithRandomPointer {
    // Definition for a Node.
    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
    // 138. 复制带随机指针的链表
    public Node copyRandomList(Node head) {
        if(head == null){
            return null;
        }
        Node current = head;
        while(current != null){
            //克隆出新的节点，修改成以下这样的指向
            // (current)  --->  (new clone)  --->  (current.next)
            Node node = new Node(current.val);
            node.random = current.random; // 从current把random指针clone出来

            //修改指向
            node.next = current.next;
            current.next = node;

            //跳过(new clone)，直接指向下一个原有的节点
            current = current.next.next;
        }
        // 通过以上这个while循环，
        // 已经让每个原节点后面都跟着一个clone节点
        // 接下来逐个修改那些clone节点
        current = head.next; // 从第一个clone节点开始
        while(current != null){
            if(current.random != null){ // 如果随机指针指向null，那么不需要修改
                current.random = current.random.next; // 指向老节点，改成指向老节点后面紧跟的clone节点
            }
            if(current.next != null){ // 当前这个clone节点不是最后一个节点
                current = current.next.next; // 跳到下一个clone节点
            }else{
                current = null; // 没有下一个clone节点了
            }
        }
        Node myhead = null; // 构造自己的链表
        Node mycurr = null; // 正向插入pattern
        current = head; // 从每个原有节点开始
        while(current != null){
            Node node = current.next; // 取出原有节点后面的clone节点
            current.next = current.next.next; // 恢复原有节点指向的下一原有节点
            if(myhead == null){
                myhead = node;
                mycurr = myhead;
            }else{
                mycurr.next = node;
                mycurr = mycurr.next;
            } // pattern: 向myhead、mycurr插入node节点
            node.next = null; // 封尾
            current = current.next; // 遍历到下一节点
        }
        return myhead; // 新节点构成的链表
    }

//    // 138. 复制带随机指针的链表
//    public Node copyRandomList(Node head) {
//        if(head == null){
//            return null;
//        }
//        Node current = head;
//        while(current != null){
//            //克隆出新的节点，修改成以下这样的指向
//            // (current)  --->  (new clone)  --->  (current.next)
//            Node node = new Node(current.val);
//            node.random = current.random; // 从current把random指针clone出来
//
//            //修改指向
//            node.next = current.next;
//            current.next = node;
//
//            //跳过(new clone)，直接指向下一个原有的节点
//            current = current.next.next;
//        }
//        // 通过以上这个while循环，
//        // 已经让每个原节点后面都跟着一个clone节点
//        // 接下来逐个修改那些clone节点
//        current = head.next; // 从第一个clone节点开始
//        while(current != null){
//            if(current.random != null){ // 如果随机指针指向null，那么不需要修改
//                current.random = current.random.next; // 指向老节点，改成指向老节点后面紧跟的clone节点
//            }
//            if(current.next != null){ // 当前这个clone节点不是最后一个节点
//                current = current.next.next; // 跳到下一个clone节点
//            }else{
//                current = null; // 没有下一个clone节点了
//            }
//        }
//        Node myhead = null; // 构造自己的链表
//        Node mycurr = null; // 正向插入pattern
//        current = head; // 从每个原有节点开始
//        while(current != null){
//            Node node = current.next; // 取出原有节点后面的clone节点
//            current.next = node.next; // 恢复原有节点指向的下一原有节点
//            if(myhead == null){
//                myhead = node;
//                mycurr = myhead;
//            }else{
//                mycurr.next = node;
//                mycurr = mycurr.next;
//            } // pattern: 向myhead、mycurr插入node节点
//            node.next = null; // 封尾
//            current = current.next; // 遍历到下一节点
//        }
//        return myhead; // 新节点构成的链表
//    }

}

