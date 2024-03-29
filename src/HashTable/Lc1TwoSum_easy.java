package HashTable;

import java.util.HashMap;
import java.util.Map;

public class Lc1TwoSum_easy {
    public int[] twoSum(int[] nums, int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(map.containsKey(target-nums[i])){
                return new int[]{i,map.get(target-nums[i])};
            }
            map.put(nums[i],i);
        }
        return new int[]{};
    }




    public int[] twoSumP(int[] nums, int target){

        HashMap<Integer,Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i = 0; i < nums.length; i++){
            if (map.containsKey(target - nums[i])){
                ans[0] = i;
                ans[1] = map.get(target - nums[i]);
            }else {
                map.put(nums[i], i);
            }
        }
        return ans;
    }
}


