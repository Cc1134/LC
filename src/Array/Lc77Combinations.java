package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc77Combinations {
    // 77. 组合
    // dfs，依次确定第[0]...[k-1]个数字的取值
    // 为了让组合的顺序保持唯一性，
    // 规定每个“组合”必须以“已排序”也就是小数在前大数在后的形式表示
    List<List<Integer>> dfs(int i, int n, int k){
        // i: 当前这一层dfs从`i`这个数开始考虑
        //    (前面已经出现了i-1，根据“已排序”规则，新的数字不能小于i)
        // n: 原题所定义的n
        // k: 将从[i, n]范围内再选取k个数字

        // 初始化返回数组
        List<List<Integer>> ans = new ArrayList<>();
        if(k == 0){ // 不再需要选取数字时，solution是唯一的：一个empty list
            ans.add(new LinkedList<>());
            return ans;
        }
        for(; i <= n; i++){ // 遍历选取[i, n]区间
            // 递归从[i+1, n]的区间里取k-1个数字
            List<List<Integer>> result = dfs(i+1, n, k-1);
            for(List<Integer> list: result){
                // 对每个solution的开头添加上当前被选取的数字i
                list.add(0, i);
                // 把solution追加到ans列表里
                ans.add(list);
            }
        }
        return ans;
    }
    public List<List<Integer>> combine(int n, int k) {
        return dfs(1, n, k); // “从[1, n]区间里取k个数字”
    }

}
