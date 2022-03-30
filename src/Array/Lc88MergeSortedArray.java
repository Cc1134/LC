package Array;

public class Lc88MergeSortedArray {
    // 88. 合并两个有序数组
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 从后向前，依次填充未被合并的区间中，更大的那个数字即可
        int index1 = m-1; // 未被合并的数组1中，最后一个元素的下标是m-1
        int index2 = n-1; // 未被合并的数组2中，最后一个元素的下标是n-1
        for(int i = m+n-1; i >= 0; i--){ // 倒序填充nums1数组
            if(
                    index2 < 0 // 数组2中不含有未被合并的元素
                            || (index1 >= 0 && nums1[index1] >= nums2[index2]) // 数组1中含有未被合并的元素，并且这尾元素比nums2的未合并尾元素取值更大
            ){
                nums1[i] = nums1[index1]; // nums1的元素在倒序填充中更先被使用掉
                index1--; // 未被合并的nums1中元素指针前移一位
            }else{
                nums1[i] = nums2[index2]; // nums2的元素在倒序填充中更先被使用掉
                index2--; // 未被合并的nums2中元素指针前移一位
            }
        }
    }

}
