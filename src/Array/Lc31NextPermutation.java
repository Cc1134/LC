package Array;

import java.util.Arrays;

/**
 * @ClassName: Lc31NextPermutation
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/18/22 10:25 am
 * @Version 1.0
 */
public class Lc31NextPermutation {
    public void nextPermutation(int[] nums) {
        //预计下标i不存在(也就是全逆序排列，例如321)
        int i = -1;
        //以右侧第一个数字初始化max(nums[i+1:])
        int maxOfRight = nums[len-1];
        //从右向左查找第一个有效的下标i，使得满足
        //nums[i] < max(nums[i+1:])
        //i≠len-1，因为必须有i<j<len
        for(int j = len-2; ?; j--){
            if(参考第8行?){
                i = j;// 查找到第一个有效的i，退出查i循环
                break;
            }
            //更新max(nums[i+1:])
            maxOfRight = maxOfRight>=()?maxOfRight:();
        }
        //如果是全逆序排列，直接返回全排序后的最小字典序
        if(i == -1){
            Arrays.sort(?);
            return;
        }
        //不是全逆序排列时，交换nums[i], nums[j]
        //将下标j初始化为"invalid"
        int minIndex = -1;
        //查找j的范围是j in range(i+1, len)
        for(int j = i+1; j < nums.length; j++){
            if(
                ? // nums[j]比nums[i]大
                && (? // minIndex is "invalid"
                    || ? // nums[j]小于曾经找到的min
                    )){
                minIndex = ?;
            }
        }
        //交换nums[i], nums[i] <swap pattern>
        ?temp = ?
        ? = ?
        ? = ?temp
        //将nums[i+1:]降到字典序最小的case
        Arrays.sort(?, ?, ?);
    }

}

class Solution {
    public void nextPermutation(int[] nums) {
        int i = -1;
        int maxOfRight = nums[nums.length-1];
        for(int j = nums.length-2; j >= 0; j--){
            if(nums[j] < maxOfRight){
                i = j;
                break;
            }
            maxOfRight = maxOfRight>=nums[j]?maxOfRight:nums[j];
        }
        if(i == -1){
            Arrays.sort(nums);
            return;
        }
        int minIndex = -1;
        for(int j = i+1; j < nums.length; j++){
            if(nums[i] < nums[j] && (minIndex == -1 || nums[minIndex]>nums[j])){
                minIndex = j;
            }
        }
        int temp = nums[i];
        nums[i] = nums[minIndex];
        nums[minIndex] = temp;
        Arrays.sort(nums, i+1, nums.length);
    }
}
