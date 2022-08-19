package LinkedList;

import java.util.PriorityQueue;

public class Lc23MergeKSortedLists_hard {
    //Definition for singly-linked list.
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeKLists(ListNode[] lists) {
        /*优先队列(堆)priorityQueue/heap
        放入一个元素的耗时取决于heap中已有元素的数量n，复杂度是O(logn)
        提取一个元素的耗时是O(logn)
        提取元素时的顺序等同于排好序的状态（每次提取出最大值/最小值）
        最优复杂度守恒：
        如果要对一个数组进行完整的排序：
        普通数组快速排序：O(nlogn)
        链表分治：O(nlogn)
        普通数组归并排序：O(nlogn)
        建一个priorityQueue，依次把数组元素塞进queue，再每次取出一个最小值，按顺序摆放
        queue.size == n
        for(O(n)){
            queue.offer(arr[i]) // O(logn)
        }
        for(O(n)){
            arr[i] = queue.poll() // O(logn)
        }
        最终的总复杂度还是O(n*logn)
        */
        if(lists.length == 0){
            return null;
        }
        PriorityQueue<ListNode> queue = new PriorityQueue<>(
                lists.length,
                (ListNode a, ListNode b) -> a.val - b.val
        );
        for(ListNode node: lists){
            if(node != null){
                queue.offer(node);
            }
        }
        // 归约(reduce/fold/gather)：把两个排好序的链表合并起来
        ListNode myhead = null;
        ListNode mycurr = null;
        while(!queue.isEmpty()){ // O(n)
            // 求出包含有全局最小值的链表 O(k)
            // 更优的办法可以做到O(logk)
            ListNode node = queue.poll();
            if(node.next != null){
                queue.offer(node.next);
            }
            // 把选中的节点插入到总的链表中(insert)
            if(myhead == null){
                myhead = node;
                mycurr = node;
            }else{
                mycurr.next = node;
                mycurr = mycurr.next;
            }
        }
        return myhead;

    }
}
