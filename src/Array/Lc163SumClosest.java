package Array;

import java.util.Arrays;

/**
 * @ClassName: Lc163SumClosest
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/18/22 10:17 am
 * @Version 1.0
 */
public class Lc163SumClosest {
    int ret1(){
        return 1;
    }
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0]+nums[1]+nums[2];
        int abs_ans = ans-target;
        abs_ans = abs_ans>=0?abs_ans:-abs_ans;
        Arrays.sort(nums);
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i-1] == nums[i]){
                continue;
            }
            int a = nums[i];
            int L = i+1;
            int R = nums.length-1;
            while(L < R){
                int b = nums[L];
                int c = nums[R];
                int diff = a+b+c-target;
                diff = diff>=0?diff:-diff;
                //2*n*(n/2)
                if(diff < abs_ans){
                    ans = a+b+c;
                    abs_ans = diff;
                }
                if(a+b+c < target){
                    L++;
                    continue;
                }
                if(a+b+c > target){
                    R--;
                    continue;
                }
                return target;
            }
        }
        return ans;
    }

}

