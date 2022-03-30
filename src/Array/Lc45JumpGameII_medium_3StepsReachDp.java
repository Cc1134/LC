package Array;

import java.util.HashMap;
import java.util.Map;

public class Lc45JumpGameII_medium_3StepsReachDp {

//    //方法1：dfs思想，用递归实现
//    int[] nums;
//    Integer minJump(int index){
//        //从下标[index]跳到[len-1]所需要的最小步数
          //如果只有一个数，当前index就是最后一位的index，那么跳0步
//        if(index == nums.length-1){
//            return 0;
//        }
          //如果下标超过数组总长度，就是无效数组
//        if(index >= nums.length){
//            return null;
//        }
          //初始化最小的步数
//        Integer min = null;
          //从当前步往后跳至少跳一步，所以step从1开始，step能取到的值为比index小的值
//        for(int step = 1; step <= nums[index]; step++){
              //value是下一个index跳到len-1的最小步数
//            Integer value = minJump(index+step);
              //如果下标超过了数组的总长度
              //或者 如果情况A：nums[index+step]==0
              //情况B：从某个block出发，经过跳转，无论中间怎么走，最终都会走到nums[]==0的block上而不是最后一个block，
              // 那么这时候，出发的那个block上的value为null
//            if(value == null){
//                continue;
//            }
              //更新min
//            if(min == null || min > value){
//                min = value;
//            }
//        }
//        if(min == null){
//            return null;
//        }
//        return min+1;
//    }
//    public int jump(int[] nums) {
//        this.nums = nums;
//        return minJump(0);
//    }



//    //方法2：添加map，优化递归所需的时间和空间复杂度
//    int[] nums;
//    Map<Integer, Integer> map;
//    Integer minJump(int index){
//        //从下标[index]跳到[len-1]所需要的最小步数
//        if(index == nums.length-1){
//            return 0;
//        }
//        if(index >= nums.length){
//            return null;
//        }
//        if(map.containsKey(index)){
//            return map.get(index);
//        }
//        Integer min = null;
//        for(int step = 1; step <= nums[index]; step++){
//            Integer value = minJump(index+step);
//            if(value == null){
//                continue;
//            }
//            if(min == null || min > value){
//                min = value;
//            }
//        }
//        if(min == null){
//            map.put(index, null);
//            return null;
//        }
//        map.put(index, min+1);
//        return min+1;
//    }
//    public int jump(int[] nums) {
//        this.nums = nums;
          //map or this.map是一样的
//        map = new HashMap<>();
//        return minJump(0);
//    }


//    //方法2continue：继续优化map
//    int[] nums;
//    Map<Integer, Integer> map;
//    int minJump(int index){
//        //从下标[index]跳到[len-1]所需要的最小步数
//        if(index == nums.length-1){
//            return 0;
//        }
//        int min = -1;
//        for(int step = 1; step <= nums[index]; step++){
//            if(index+step >= nums.length){
//                break;
//            }
//            int value = map.get(index+step);
//            if(value == -1){
//                continue;
//            }
//            if(min == -1 || min > value){
//                min = value;
//            }
//        }
//        if(min == -1){
//            return -1;
//        }
//        return min+1;
//    }
//    public int jump(int[] nums) {
//        this.nums = nums;
//        map = new HashMap<>(nums.length);
          //为什么这里是倒着走: 基于对map里数据被记忆情况的观察
          //如果倒着走，那么实际上每次需要递归的时候，都能保证map里永远是cache的
          //那么在倒着走的前提下也就能消除所有事实上的递归，即使语义上看它完成了递归算法能完成的事情
          //这就是一个dp风格的观察，通过找到合适的遍历顺序或者说递推关系来消除所有递归层次上的开销
          //变成依次执行了N步递推，每一步递推都是一个O(1)的公式
//        for(int i = nums.length-1; i >= 0; i--){
//            map.put(i, minJump(i));
//        }
//        return map.get(0);
//    }


    //方法3：用数组代替map，进一步优化，实现dp思想
    public int jump(int[] nums) {
        int[] map = new int[nums.length];
        map[nums.length-1] = 0;
        for(int i = nums.length-2; i >= 0; i--){
            //从下标[index]跳到[len-1]所需要的最小步数
            int min = -1;
            for(int step = 1; i+step < nums.length && step <= nums[i]; step++){
                int value = map[i+step];
                if(value != -1 && (min == -1 || min > value)){
                    min = value;
                }
            }
            map[i] = min==-1?-1:(min+1); // return min+1
        }
        //polynomial a*b*c*d (1000 * 10^4)
        //exponential 2*2*2*...(n个2)...*2 (1000)^(10^4)
        return map[0];
    }


        //为什么这个和方法三一样，但是通过速度差那么多？？？？ 这个用1ms 方法三用108 ms
        public static int jumpdyq(int[] nums) {
            int start = 0;
            int end = 1; // 这个end 是开区间
            int count = 0;

            while (end < nums.length) {

                int curMax = 0;
                for (int i = start; i < end; i++) {
                    curMax = Math.max(curMax, i + nums[i]);
                }
                start = end;
                end = curMax + 1;
                count++;
            }
            return count;
        }



}
