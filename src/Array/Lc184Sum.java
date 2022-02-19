package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Lc184Sum
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/18/22 10:19 am
 * @Version 1.0
 */
public class Lc184Sum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int a = nums[i];
            for(int j = i+1; j < nums.length; j++){
                if(j > i+1 && nums[j-1] == nums[j]){
                    continue;
                }
                int b = nums[j];
                int L = j+1;
                int R = nums.length-1;
                while(L < R){
                    int c = nums[L];
                    int d = nums[R];
                    if(a+b+c+d < target){
                        L++;
                        continue;
                    }
                    if(a+b+c+d > target){
                        R--;
                        continue;
                    }
                    List<Integer> list = new ArrayList<>(4);
                    list.add(a);
                    list.add(b);
                    list.add(c);
                    list.add(d);
                    ans.add(list);
                    while(L < R && nums[L] == c){
                        L++;
                    }
                }
            }
        }
        //M, n^M -> n^(M-1)
        return ans;
    }

}

