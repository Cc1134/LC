package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc78Subsets {
    // 78. 子集
    // 为了保证每个子集都只出现一遍，首先规定集合里元素的排列顺序
    // 如果nums[i], nums[j]是两个不同的nums中的数字，并且下标i<j，
    // 那么含有这两个数字的集合一定要表示为[..., nums[i], ..., nums[j], ...]
    // 而不能表示为[..., nums[j], ..., nums[i], ...]
    // 也就是说，在子集的唯一表示(representation)规定下，
    // 在nums中数字出现的先后顺序应当与子集中数字出现的顺序一样
    // 也就是说，每个子集都相当于基于nums数组，去除其中一部分元素，
    // 保持元素之间的相对先后顺序不变，得到的子数组
    // 这样的子数组表示法，可以刚好不重复地表示出每个子集
    //
    // 分析示例1：
    // 不含任何元素的子集：[]
    // 最先出现数字1的子集：[1], [1,2], [1,3], [1,2,3]
    // 最先出现数字2的子集: [2], [2,3]
    // 最先出现数字3的子集: [3]
    //
    // 分析`最先出现数字1的子集`：
    // 没有第二个元素的：[1]                  (aka `[1]+[empty]`)
    // 第二个元素先出现数字2的：[1,2], [1,2,3] (aka `[1]+[2], [1]+[2,3]`)
    // 第二个元素先出现数字3的：[1,3]          (aka `[1]+[3]`)
    //
    // 分析`最先出现数字2的子集`：
    // 没有第二个元素的：[2]                  (aka `[2]+[empty]`)
    // 第二个元素先出现数字1的：这不可能，这样的顺序违反子数组表示法
    // 第二个元素先出现数字2的：不可能，原因同上
    // 第二个元素先出现数字3的：[2,3]          (aka `[2]+[3]`)
    //
    // 分析`最先出现数字3的子集`：
    // 没有第二个元素的：[3]                  (aka `[3]+[empty]`)
    // 第二个元素是blahblah的：不存在，因为都违反子数组表示法
    //
    // 分析“出现在数组[1,2,3]里、在数字1之后的数字”aka[2,3]构成的子集：
    // []
    // [2], [2,3]
    // [3]
    // **注意到这恰好是19行去掉“开头的1”剩下的子集
    //
    // 分析“出现在数组[1,2,3]里、数字2之后的数字”aka[3]构成的子集：
    // []
    // [3]
    // **注意到这恰好是24行去掉“开头的2”剩下的子集
    //
    // 分析“出现在数组[1,2,3]里、数字3之后的数字”aka[empty]构成的子集：
    // []
    // **注意到这恰好是30行去掉“开头的3”剩下的子集
    //
    // 根据以上观察，写出dfs：
    // List<SubSet.aka.ListOfIntegers> dfs(nums, index)
    // 输入题目提供的完整nums数组，以及一个下标index，代表nums[index]这个数字
    // 返回由nums[index...(len-1)]这部分“去掉开头违反子数组表示顺序的元素之后”剩下内容构成的子集
    List<List<Integer>> dfs(int[] nums, int index){
        List<List<Integer>> ans = new ArrayList<>(); // 建立返回的List<SubSets>数组
        ans.add(new LinkedList<>()); // 任何一个集合里，都有一个空集，是原集合的子集(使用LinkedList而不是ArrayList提速)
        if(index == nums.length){ // 如果nums[index]越界，说明已经没有“剩余的组成子集的可用元素”
            return ans; // 输入空集，返回全体子集：只有“一个空集”是空集的子集
        }
        for(;index < nums.length; index++){ // 遍历所有可以放入子集的数字nums[index]
            List<List<Integer>> result = dfs(nums, index+1); // 递归获取每个nums[index]后面元素们的全体子集
            for(List<Integer> list: result){ // 遍历每个“后面元素的子集”
                list.add(0, nums[index]); // 在子集开头加入nums[index]，使它成为当前dfs时间线上的“符合本级语义的子集”(而不是下一级递归里面返回出来的那个“下级语义”)
                ans.add(list); // 把modified子集加入全体结果集合中
            }
        }
        return ans;
    }
    public List<List<Integer>> subsets(int[] nums) {
        return dfs(nums, 0); // 从nums[index=0]开始遍历子集
    }

}
