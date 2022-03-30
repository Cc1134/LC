package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Lc39CombinationSum_medium {

    List<List<Integer>> dfs(int[] candidates, int index, int target){
        //从candidates[index]到candidates[len-1]，使用这些元素拼成target的所有方案
        //dfs([2,3,6,7], 0, 7) -> [[2,2,3], [7]]
        //dfs([2,3,6,7], 0, 5) -> [[2,3]]
        //dfs([2,3,6,7], 0, 3) -> [[3]]
        //dfs([2,3,5], 0, 8) -> [[2,2,2,2],[2,3,3],[3,5],**empty**]
        //dfs([2,3,5], 0, 6) -> [[2,2,2],[3,3]]
        //dfs([2,3,5], 0, 4) -> [[2,2]]
        //dfs([2,3,5], 0, 2) -> [[2]]
        //dfs([2,3,5], 1, 3) -> [[3]]
        //dfs([2,3,5], 2, 1) -> []
        //dfs([2,3,5], 1, 5) -> [[5]]
        //dfs([2,3,5], 2, 3) -> []
        //dfs([2,3,5], 2, 0) -> [[]]
        //[] + [] -> []
        //[..]+[]->[..]
        List<List<Integer>> ans = new ArrayList<>();
        if(target == 0){
            ans.add(?);
            return ans;
        }
        for(i in 0...len(candi)-1){
            if(`extract candi[i] from target` is none-neg){
                solutionsList = dfs(candidates[i:], extract candi[i] from target);
                for(each solution in solutionsList)){
                    //solution: [...] -> [candi[i], ...]
                    ans.add(solution);
                }
            }
        }
        return ans;
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        return dfs(candidates, ?, target);
    }



        //answer
//    List<List<Integer>> dfs(int[] candidates, int index, int target){
//        //从candidates[index]到candidates[len-1]，使用这些元素拼成target的所有方案
//        //dfs([2,3,6,7], 0, 7) -> [[2,2,3], [7]]
//        //dfs([2,3,6,7], 0, 5) -> [[2,3]]
//        //dfs([2,3,6,7], 0, 3) -> [[3]]
//        //dfs([2,3,5], 0, 8) -> [[2,2,2,2],[2,3,3],[3,5],**empty**]
//        //dfs([2,3,5], 0, 6) -> [[2,2,2],[3,3]]
//        //dfs([2,3,5], 0, 4) -> [[2,2]]
//        //dfs([2,3,5], 0, 2) -> [[2]]
//        //dfs([2,3,5], 1, 3) -> [[3]]
//        //dfs([2,3,5], 2, 1) -> []
//        //dfs([2,3,5], 1, 5) -> [[5]]
//        //dfs([2,3,5], 2, 3) -> []
//        //dfs([2,3,5], 2, 0) -> [[]]
//        //[] + [] -> []
//        //[..]+[]->[..]
//        List<List<Integer>> ans = new ArrayList<>();
//        if(target == 0){
//            ans.add(new LinkedList<>());
//            return ans;
//        }
//        for(int i = index; i < candidates.length; i++){
//            if(candidates[i] <= target){
//                List<List<Integer>> solutionsList = dfs(candidates, i, target-candidates[i]);
//                for(List<Integer> solution: solutionsList){
//                    solution.add(0, candidates[i]);
//                    ans.add(solution);
//                }
//            }
//        }
//        return ans;
//    }
//    public List<List<Integer>> combinationSum(int[] candidates, int target) {
//        Arrays.sort(candidates);
//        return dfs(candidates, 0, target);
//    }

}
