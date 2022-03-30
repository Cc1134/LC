package Array;

public class Lc80RemoveDuplicatesfromSortedArrayII {
    //80. 删除有序数组中的重复项
    public int removeDuplicates(int[] nums) {
        int index = 0; // 初始化“整理了的数组部分”的长度为0
        for (int num : nums) { // 遍历数组中的每个元素
            if (
                // 情况A：已整理了的数组部分少于两个元素，那么num必然不是第三次出现
                    index - 2 < 0
                            // 情况B：连续往前看两个元素，两个元素并不都等同于num，也就是说num并非是第三次出现
                            || !(nums[index - 1] == num && nums[index - 2] == num)) {
                nums[index] = num; // 把num元素写入nums数组
                index++; // 增加“整理了的数组部分”的长度计数
            }
        }
        return index;
    }
}
