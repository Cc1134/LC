package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Lc116PopulatingNextRightPointersinEachNode
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/1/22 6:01 pm
 * @Version 1.0
 */
public class Lc116PopulatingNextRightPointersinEachNode {
    // Definition for a Node.
    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    }

    List<Node> merge(List<Node> viewLeft, List<Node> viewRight, Node root) {
        List<Node> list = new ArrayList<>();
        if (viewRight.size() >= viewLeft.size()) {
            list = viewRight;
            list.add(0, root);
            return list;
        }

        for (int level = 0; level <= viewRight.size() - 1; level++) {
            viewLeft.set(level, viewRight.get(level));
        }

        viewLeft.add(0, root);
        return viewLeft;
    }

    List<List<Node>> getLeftRightView(Node root){
        List<List<Node>> ans = new ArrayList<ArrayList<Node>>();
        List<Node> leftView = new ArrayList<>();
        List<Node> rightView = new ArrayList<>();
        if(root == null){

            return new ArrayList<Node>{leftView,rightView};
        }
        if(root.left == null && root.right == null){
            leftView.add(root);
            rightView.add(root);
            ans[0] = leftView;
            ans[1] = rightView;
            return ans;
        }
        //剩下的情况：分支节点
        List<Node>[] viewOfLeft = getLeftRightView(root.left);
        List<Node>[] viewOfRight = getLeftRightView(root.right);

        leftView = merge(viewOfRight[0],viewOfLeft[0],root);
        rightView = merge(viewOfLeft[1],viewOfRight[1],root);

        for(int i = 0; i < viewOfLeft[1].size(); i++){
            leftView.get(i).right = rightView.get(i);
        }
        ans[0] = leftView;
        ans[1] = rightView;
        return ans;
    }
    public Node connect(Node root) {

    }

}

