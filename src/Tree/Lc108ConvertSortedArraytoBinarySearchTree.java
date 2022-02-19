package Tree;

import java.util.Arrays;

/**
 * @ClassName: Lc108ConvertSortedArraytoBinarySearchTree
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/4/22 10:17 am
 * @Version 1.0
 */
public class Lc108ConvertSortedArraytoBinarySearchTree {
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

    public TreeNode sortedArrayToBST(int[] nums) {
        //[-10,-3,0,5,9] [-10,0,5,9]
        //odd: left = (length - 1) /2
        //even: left = (length/2)
        //odd and even could be the same, we can use left = (length - 1) /2
        //right = length - right
        int count = nums.length;
        int left = count / 2;
        int right = count - left - 1;

        TreeNode root = new TreeNode(nums[left]);
        if (count == 1) {
            return new TreeNode(nums[0]);
        }

        if (left > 0) {
            root.left = sortedArrayToBST(Arrays.copyOfRange(nums, 0, left));
        }
        if (right > 0) {
            root.right = sortedArrayToBST(Arrays.copyOfRange(nums, left + 1, count));
        }
        return root;
    }
}

