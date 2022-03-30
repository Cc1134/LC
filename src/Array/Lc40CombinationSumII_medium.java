package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lc40CombinationSumII_medium {
    List<List<Integer>> dfs(int[] candidates, int index, int target){
        List<List<Integer>> ans = new ArrayList<>();
        if(target == 0){
            ans.add(new LinkedList<>());
            return ans;
        }
        for(int i = index; i < candidates.length; i++){
            if(i-1 >= index && candidates[i-1]==candidates[i]){
                continue;
            }
            if(candidates[i] <= target){
                List<List<Integer>> result = dfs(candidates, i+1, target-candidates[i]);
                for(List<Integer> list: result){
                    list.add(0, candidates[i]);
                    ans.add(list);
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, 0, target);
    }

}
