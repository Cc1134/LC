package Array;

public class Lc56MergeIntervals {
    boolean isInternal(int point, int[] range){
        //语义：当point in range[a,b]
        return range[0] <= point && point <= range[1];
    }
    int[] updateNewIntervalOnOverlap(
            int[] newInterval, int[] oldInterval
    ){
        //语义：当newInterval与oldInterval有重叠时，
        //将newInterval原地更新为Union[newInterval, oldInterval]
        //当newInterval被更新了时，返回true(null, eliminated)表示已更新
        //当newInterval未被更新(未发生重叠)时，返回false(non-null, not eliminated)

        if(!(
                isInternal(newInterval[0], oldInterval)
                        || isInternal(newInterval[1], oldInterval)
                        || isInternal(oldInterval[0], newInterval)
                        || isInternal(oldInterval[1], newInterval))){
            return oldInterval;
        }
        //原地更新
        newInterval[0] = newInterval[0]<=oldInterval[0]?newInterval[0]:oldInterval[0];
        newInterval[1] = newInterval[1]>=oldInterval[1]?newInterval[1]:oldInterval[1];
        return null;
    }
    public int[][] merge(int[][] intervals) {
        //interface Comparator: 当compareTo(A, B)中，
        //A被"规定为"比B小时，返回小于0的得数，否则返回大于0的得数
        Arrays.sort(intervals, (int[] rangeA, int[] rangeB) -> rangeA[0]-rangeB[0]);
        int count = 0;
        int[] currentInterval = null;
        for(int i = 0; i < intervals.length; i++){
            if(currentInterval != null){
                intervals[i] = updateNewIntervalOnOverlap(
                        currentInterval, intervals[i]);
            }
            if(intervals[i] != null){
                currentInterval = intervals[i];
                count++;
            }
        }
        int[][] ans = new int[count][];
        int index = 0;
        for(int i = 0; i < count; i++){
            while(intervals[index] == null){
                index++;
            }
            ans[i] = intervals[index];
            index++;
        }
        return ans;
    }












    boolean isInternal(int point, int[] range){
        //语义：当point in range[a,b]
        return range[0] <= point && point <= range[1];
    }
    int[] updateNewIntervalOnOverlap(
            int[] newInterval, int[] oldInterval
    ){
        //语义：当newInterval与oldInterval有重叠时，
        //将newInterval原地更新为Union[newInterval, oldInterval]
        //当newInterval被更新了时，返回true(null, eliminated)表示已更新
        //当newInterval未被更新(未发生重叠)时，返回false(non-null, not eliminated)

        if(!(
                isInternal(newInterval[0], oldInterval)
                        || isInternal(newInterval[1], oldInterval)
                        || isInternal(oldInterval[0], newInterval)
                        || isInternal(oldInterval[1], newInterval))){
            return oldInterval;
        }
        //原地更新
        newInterval[0] = newInterval[0]<=oldInterval[0]?newInterval[0]:oldInterval[0];
        newInterval[1] = newInterval[1]>=oldInterval[1]?newInterval[1]:oldInterval[1];
        return null;
    }
    public int[][] merge(int[][] intervals) {
        //interface Comparator: 当compareTo(A, B)中，
        //A被"规定为"比B小时，返回小于0的得数，否则返回大于0的得数
        Arrays.sort(intervals, (int[] rangeA, int[] rangeB) -> rangeA[0]-rangeB[0]);
        int count = 0;
        int[] currentInterval = null;
        for(int i = 0; i < intervals.length; i++){

            if(currentInterval == null){
                //current指针未指向任何可以expend to include intervals[i]
                //的区间时，放弃尝试用current区间吞下intervals[i]
            }else{
                //尝试expand currentInterval to include intervals[i]
                //如果成功，那么消去intervals[i](被赋值为null)
                //否则，intervals[i]保持原样不变
                intervals[i] = updateNewIntervalOnOverlap(currentInterval, intervals[i]);
            }
            //如果intervals[i]未被included/eliminated
            //那么对于排序在intervals[i]之后的区间们
            //应当使用intervals[i]来include随后的区间
            //将current指向intervals[i]以便next loops expand
            if(intervals[i] != null){
                currentInterval = intervals[i];
                count++;
            }
        }
        //初始化返回值数组
        //把non-null(not eliminated)的区间放进数组
        int[][] ans = new int[count][];
        int index = 0;
        for(int i = 0; i < count; i++){
            while(intervals[index] == null){
                index++;
            }
            ans[i] = intervals[index];
            index++;
        }
        return ans;
    }

}
