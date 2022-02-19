package Lc22;

/**
 * @ClassName: Lc35SearchInsertPosition
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/8/22 10:47 pm
 * @Version 1.0
 */
public class Lc35SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return right + 1;
    }
}

