package BFS;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Lc103BinaryTreeZigzagLevelOrderTraversal_medium {
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


    public List<List<Integer>> zigzagLevelOrderI(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        List<TreeNode> currentLayer = new ArrayList<>(1);
        currentLayer.add(root);
        int layerIndex = 0;

        while (!currentLayer.isEmpty()) {
            List<Integer> currentLayerValue = new ArrayList<>(currentLayer.size());
            List<TreeNode> nextLayer = new ArrayList<>(currentLayer.size() * 2);


            for(TreeNode node : currentLayer){
                currentLayerValue.add(node.val);
                Collections.reverse(currentLayerValue);
                if(layerIndex % 2 == 0){
                    if(node.left != null){
                        nextLayer.add(node.left);
                    }
                    if(node.right != null){
                        nextLayer.add(node.right);
                    }
                }else {
                    if(node.right != null){
                        nextLayer.add(node.right);
                    }
                    if(node.left != null){
                        nextLayer.add(node.left);
                    }
                }

            }
            ans.add(currentLayerValue);
            currentLayer = nextLayer;
            layerIndex++;
        }
        return ans;
    }


    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){ // ??????: ???????????????????????????????????????0
            return ans;
        }
        List<TreeNode> currentLayer = new ArrayList<>(1); // ??????????????????
        currentLayer.add(root); // ???????????????root????????????
        int layerIndex = 0;
        while(!currentLayer.isEmpty()){ // ????????????????????????????????????
            // task1: ???????????????????????????val??????????????????List<Integer>???
            // task2: ???????????????????????????????????????????????????List<TreeNode>
            Collections.reverse(currentLayer);
            List<Integer> currentLayerValues = new ArrayList<>(currentLayer.size());
            List<TreeNode> nextLayer = new ArrayList<>(2*currentLayer.size());
            for(TreeNode node: currentLayer){
                currentLayerValues.add(node.val);
                if(layerIndex%2 == 0){
                    if(node.left != null){
                        nextLayer.add(node.left);
                    }
                    if(node.right != null){
                        nextLayer.add(node.right);
                    }
                }else{
                    if(node.right != null){
                        nextLayer.add(node.right);
                    }
                    if(node.left != null){
                        nextLayer.add(node.left);
                    }
                }
            }
            ans.add(currentLayerValues);
            currentLayer = nextLayer;
            layerIndex++;
        }
        return ans;
    }

}
