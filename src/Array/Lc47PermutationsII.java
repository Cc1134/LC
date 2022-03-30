package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lc47PermutationsII {
    List<List<Integer>> dfs(int[] nums, boolean[] used){
        List<List<Integer>> ans = new ArrayList<>();
        boolean allUsed = true;
        for(int i = 0; i < nums.length; i++){
            if(used[i] || (i-1>=0 && nums[i-1]==nums[i] && !used[i-1])){
                continue;
            }
//            if(
//                    used[i] // 如果[i]已经被使用，那么不可以重复使用
//                            || (i-1>=0 //概念[上一个数字]必须是存在的
//                            && nums[i-1]==nums[i] // 只观察上一个数字与当前数字一样的情况
//                            && !used[i-1])){ // 上一个数字在上一层dfs时间线未被使用(aka在当前层已被使用)
//                continue;
//            }

            allUsed = false;
            used[i] = true;
            List<List<Integer>> result = dfs(nums, used);
            used[i] = false;
            for(List<Integer> list: result){
                list.add(0, nums[i]);
                ans.add(list);
            }
        }
        if(allUsed){
            ans.add(new LinkedList<>());
        }
        return ans;
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        //nums = [1,2,1]
        //sort(nums) -> [1,1,2]
        //`num[index]`: 1[0], 1[1], 2[0]
        //[1,1,2]: [1[0], 1[1], 2[0]] or [1[1], 1[0], 2[0]]
        //[1,2,1]: [1[0], 2[0], 1[1]] or [1[1], 2[0], 1[0]]
        //[2,1,1]: [2[0], 1[0], 1[1]] or [2[0], 1[1], 1[0]]
        //[num1[0], num1[1], num1[2], u[0]]
        //{num1, ..., u, ..., num1}
        Arrays.sort(nums);
        return dfs(nums, new boolean[nums.length]);
    }
}
