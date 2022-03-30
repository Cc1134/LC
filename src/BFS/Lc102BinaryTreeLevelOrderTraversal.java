package BFS;

import java.util.ArrayList;
import java.util.List;

public class Lc102BinaryTreeLevelOrderTraversal {

    // Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) { // 特判: 没有根节点，直接返回层数为0
            return ans;
        }
        List<TreeNode> currentLayer = new ArrayList<>(1); // 当前的第一层
        currentLayer.add(root); // 第一层只有root一个节点
        while (!currentLayer.isEmpty()) { // 在当前层还有节点的情况下
            // task1: 把当前层每个节点的val导出到相应的List<Integer>里
            // task2: 从当前层的子节点里，构造出下一层的List<TreeNode>
            List<Integer> currentLayerValues = new ArrayList<>(currentLayer.size());
            List<TreeNode> nextLayer = new ArrayList<>(2 * currentLayer.size());
            for (TreeNode node : currentLayer) {
                currentLayerValues.add(node.val);
                if (node.left != null) {
                    nextLayer.add(node.left);
                }
                if (node.right != null) {
                    nextLayer.add(node.right);
                }
            }
            ans.add(currentLayerValues);
            currentLayer = nextLayer;
        }
        return ans;
    }

}
