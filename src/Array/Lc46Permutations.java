package Array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Lc46Permutations {
    List<List<Integer>> dfs(int[] nums, boolean[] used){
        List<List<Integer>> ans = new ArrayList<>();
        boolean allUsed = true;
        //init true, overwrite(false) when any(not used)
        //init false, overwrite(true) when all(used)
        for(int i = 0; i < nums.length; i++){
            if(used[i]){
                continue;
            }
            //not used
            allUsed = false;
            //declare using of nums[i]
            used[i] = true;
            List<List<Integer>> result = dfs(nums, used);
            used[i] = false;
            for(List<Integer> list: result){
                list.add(0, nums[i]);
                ans.add(list);
            }
        }
        if(allUsed){
            //return [[]]
            ans.add(new LinkedList<>());
        }
        return ans;
    }
    public List<List<Integer>> permute(int[] nums) {
        return dfs(nums, new boolean[nums.length]);
    }


    //伪代码
    List<List<Integer>> dfs(int[] nums, boolean[] used){
        ? ans = new ?;
        boolean allUsed = ?;
        //init true, overwrite(false) when any(not used)
        //init false, overwrite(true) when all(used)
        for(i = 1...(len-1)){
            if(used[i]){
                continue;
            }
            //not used
            allUsed = ?;
            //declare using of nums[i]
            used[i] = ?;
            List<List<Integer>> result = dfs(nums, used);
            used[i] = ?;
            for(List<Integer> list: result){
                list.add(0, nums[i]);
                ans.add(list);
            }
        }
        if(allUsed){
            //return [[]]
            ans.add(new LinkedList<>());
        }
        return ans;
    }
    public List<List<Integer>> permute(int[] nums) {
        return dfs(nums, new boolean[nums.length]);
    }



}
