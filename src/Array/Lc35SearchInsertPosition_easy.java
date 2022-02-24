package Array;

/**
 * @ClassName: Lc35SearchInsertPosition_easy
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/25/22 10:03 am
 * @Version 1.0
 */
public class Lc35SearchInsertPosition_easy {
    public int searchInsert(int[] nums, int target) {
        if(nums[nums.length-1] < target){
            return nums.length;
        }
        //当插入一个target的时候
        //case 0: target比所有数都大 -> return len
        //case 1: 数组中已经含有target
        //     -> 之前已有的target元素都放在已排序的位置上
        //     -> 找到这个元素出现的位置即可
        //     -> aka找到这个元素出现的第一个位置
        //case 2: 数组中不含有target
        //     -> 插入的位置应当在'下标i之前的数字都比target小，下标i之后(含)的数字都比target大'
        //     -> 不断二分，拒绝掉那些"最大的元素仍然比target小"的左区间
        //     -> firstOfTarget criteria

        //找firstOfTarget(WHY)
        //尝试查找第一个target元素
        //查找范围是整个数组的区间，从0到n-1
        int L = 0;
        int R = nums.length-1;
        //一直二分查找，直到左右端点收缩到指向某一个下标`i`==L==R为止
        //直到len(nums[L:R+1])==1为止 (左闭右开slice)
        //从L到R的数组下标区间，中间仅含一个数字为止
        //这个数字要么是第一个target
        //不然这个数字是"从左到右第一个比target大的元素"(当target并未在数组出现时)
        while(L < R){
            int numOfRange = R-L+1; // 计算当前二分区间的长度
            int numOfLeft = numOfRange/2; // 计算左区间的长度(奇数时，左区间更短，但取为左区间更长也无妨)
            int leftTail = L+numOfLeft-1; // offset计算
            int rightHead = leftTail+1; // offset计算
            //criteria: 判断的依据
            //当排好序了的数组的左半边结尾比target更小时
            //左半边一定不含有target
            if(nums[leftTail] < target){
                L = rightHead; // 左指针向内移动，走向右区间
            }else{
                R = leftTail;
            }
        }
        return L;//第一个target出现在[L]aka[R]aka[firstIndex]
    }

}

