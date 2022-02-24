package Array;

/**
 * @ClassName: Lc34FindFirstandLastPositionofElementinSortedArray
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/25/22 10:01 am
 * @Version 1.0
 */
public class Lc34FindFirstandLastPositionofElementinSortedArray {
    public int[] searchRange(int[] nums, int target) {
        //特判：区间中不含有元素时，一定找不到target
        if(nums.length == 0){
            return new int[]{-1,-1};
        }
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
        //判断能否找到一个等于target的区间
        //如果找不到，说明数组里不含有target
        if(nums[L] != target){
            return new int[]{-1,-1};
        }
        //记录所找到的第一个target的下标
        int firstIndex = L;
        //第一个target出现在[L]aka[R]aka[firstIndex], 找最后一个target值
        //后一个target的下标，一定大于等于[firstIndex]
        //因此，在[first: n]（左闭右开区间）做二分查找，找最后一个下标
        R = nums.length-1; // 重新初始化右端点下标
        while(L < R){
            int numOfRange = R-L+1;
            int numOfLeft = numOfRange/2;
            int leftTail = L+numOfLeft-1;
            int rightHead = leftTail+1;
            //criteria: 判断的依据
            //当右区间以target开头时，左区间一定全都是target
            //至少已知"右区间的开头target"比"左区间里的任一target"更"laster"
            //尽量走向右区间来找last，排除掉左区间里的"not last"
            if(nums[rightHead] == target){
                L = rightHead; // 通过向内移动左指针，走向右区间
            }else{
                R = leftTail; // 通过向内移动右指针，走向左区间
            }
        }
        return new int[]{firstIndex,L}; // [L]aka[R]aka[LASTIndex]
    }

}

