package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: Lc153Sum
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/18/22 10:13 am
 * @Version 1.0
 */
public class Lc153Sum {

    public List<List<Integer>> threeSum(int[] nums) {
        if(len?){ // 当输入的数字少于3个时
            return ?;//肯定不构成有效的“三数之和”
        }
        // 保持数组有序(时间复杂度nlogn < n*n)
        // - a<=b<=c, 三个元素有序排列，去重心智负担低
        // - 左右指针移动策略清晰
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();

        for(i in index of nums){
            int a = nums[i];
            //先检查当前的a是否重复于上一个数字
            if(i > 0 && nums[i-1]==nums[i]){
                continue;
            }
            //nums[L]+nums[R] == -a
            //b+c == a
            //已知d != b, 且d+e == a
            //推论e != c
            int L = i+1; // 左右指针初始化
            int R = nums.length-1;
            while(L < R){
                int b = nums[L];
                int c = nums[R];
                if(less){
                    ?; // 指针移动
                    continue;
                }
                if(greater){
                    ?; // 指针移动
                    continue;
                }
                List<Integer> list = new ArrayList<>(3){
                    a,b,c
                };
                ans.add(list);
                //当L指针指向了重复于此次成功了的b取值时
                //L指针步进
                while(L < R && b == nums[L]){
                    L++;
                }
            }
        }
        return ans;
    }


    public List<List<Integer>> threeSum1(int[] nums) {
        if(nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        int lastA = nums[0]+1;
        for(int i = 0; i < nums.length; i++){
            int a = nums[i];
            if(a == lastA){
                continue;
            }
            lastA = a;
            //nums[L]+nums[R] == -a
            //b+c == a
            //已知d != b, 且d+e == a
            //推论e != c
            int L = i+1;
            int R = nums.length-1;
            while(L < R){
                int b = nums[L];
                int c = nums[R];
                if(a+b+c < 0){
                    L++;
                    continue;
                }
                if(a+b+c > 0){
                    R--;
                    continue;
                }
                List<Integer> list = new ArrayList<>(3);
                list.add(a);
                list.add(b);
                list.add(c);
                ans.add(list);
                while(L < R && b == nums[L]){
                    L++;
                }
            }
        }
        return ans;
    }

}

