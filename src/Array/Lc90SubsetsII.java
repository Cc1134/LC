package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lc90SubsetsII {
    // 90. 子集2
    // 思路跟78题一样，只需要对“每个集合的唯一表示法”打补丁
    List<List<Integer>> dfs(int[] nums, int index){
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new LinkedList<>());
        if(index == nums.length){
            return ans;
        }
        for(int i = index; i < nums.length; i++){ // 改用下标变量i在[index, len)左闭右开区间上遍历，而不是直接遍历index++
            if(i-1 >= index && nums[i]==nums[i-1]){ // 如果nums[i-1]没有超出当前dfs时间线上遍历的范围[index,...)，并且nums[i-1]与nums[i]的数字取值一样，那么跳过此步，不重复生成以nums[i]aka.nums[i-1]开头的子集
                continue;
            }
            List<List<Integer>> result = dfs(nums, i+1);
            for(List<Integer> list: result){
                list.add(0, nums[i]);
                ans.add(list);
            }
        }
        return ans;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // 补丁：在求子集前，通过排序把相同的数字归拢在nums数字相邻的下标上
        return dfs(nums, 0);
    }

}
