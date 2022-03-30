package Array;

public class Lc57InsertInterval {
    boolean isInternal(int point, int[] interval){
        return interval[0] <= point && point <= interval[1];
    }
    boolean updateNewIntervalOnOverlap(
            int[] newInterval, int[] oldInterval
    ){
        //语义：当newInterval与oldInterval有重叠时，
        //将newInterval原地更新为Union[newInterval, oldInterval]
        //当newInterval被更新了时，返回true表示已更新
        //当newInterval未被更新(未发生重叠)时，返回false

        if(!(
                isInternal(newInterval[0], oldInterval)
                        || isInternal(newInterval[1], oldInterval)
                        || isInternal(oldInterval[0], newInterval)
                        || isInternal(oldInterval[1], newInterval))){
            return false;
        }
        //原地更新
        newInterval[0] = newInterval[0]<=oldInterval[0]?newInterval[0]:oldInterval[0];
        newInterval[1] = newInterval[1]>=oldInterval[1]?newInterval[1]:oldInterval[1];
        return true;
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        //eliminate与intervals数组一一对应
        //表示在合并了的列表中是否应当消去(重叠区间的合并)某一个旧的区间
        boolean[] eliminate = new boolean[intervals.length];
        int numOfElim = 0;
        for(int i = 0; i < intervals.length; i++){
            int[] oldInterval = intervals[i];
            eliminate[i] = updateNewIntervalOnOverlap(newInterval, oldInterval);
            numOfElim += eliminate[i]?1:0;
        }
        int numOfTotalIntervals = intervals.length+1-numOfElim;
        int[][] ans = new int[numOfTotalIntervals][];
        int index = 0; // 指向将被插入的下一个老区间intervals[index]
        boolean newIntervalInserted = false;
        //下标i指向当前这一圈循环将要插入到ans里的区间下标ans[i]
        for(int i = 0; i < numOfTotalIntervals; i++){
            while(index < intervals.length && eliminate[index]){
                index++;
            }
            //判断当前应该插入新区间还是老区间
            //根据[要求返回的结果依然有序]
            //判断新区间是否出现在即将插入的老区间的前面
            if(!newIntervalInserted // 新区间只能被插入一次
                    && ( // 新区间应当比老区间`小`
                    index == intervals.length // 新区间后面已经没有候选的老区间了
                            || newInterval[0] < intervals[index][0])){ // 新区间比候选老区间更小
                ans[i] = newInterval;
                newIntervalInserted = true;
            }else{
                ans[i] = intervals[index];
                index++;
            }
        }
        return ans;
    }















    boolean isInternal(int point, int[] range){
        //语义：当point in range[a,b]，返回true
        //否则返回false
        return ?;
    }
    int[] updateNewIntervalOnOverlap(
            int[] newInterval, int[] oldInterval
    ){
        //语义：当newInterval与oldInterval有重叠时，
        //将newInterval原地更新为Union[newInterval, oldInterval]
        //当newInterval被更新了时，返回true(null, eliminated)表示已更新
        //当newInterval未被更新(未发生重叠)时，返回false(non-null, not eliminated)

        if(#not( (newInterval.start in oldInterval)
        or (newInterval.end in oldInterval)
        or (oldInterval.start in newInterval)
        or (oldInterval.end in newInterval) )){
            return oldInterval; // non-null, 未发生重叠的情况下，不消除oldInterval
        }
        //原地更新
        newInterval.start = min(newInterval.start, oldInterval.start);
        newInterval.end = max(newInterval.end, oldInterval.end);
        return null; // 发生了重叠，返回null表示eliminated
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {旧的区间
        int numOfElim = 0; // Counter(num of eliminated)
        for(int i = 0; i < intervals.length; i++){
            int[] oldInterval = intervals[i];
            intervals[i] = updateNewIntervalOnOverlap(newInterval, oldInterval);
            numOfElim += intervals[i]==null?1:0;
        }

        int numOfTotalIntervals = intervals.length+1-numOfElim;
        int[][] ans = new int[numOfTotalIntervals][];
        int index = 0; // 指向将被插入的下一个老区间intervals[index]
        boolean newIntervalInserted = false;
        //下标i指向当前这一圈循环将要插入到ans里的区间下标ans[i]
        for(int i = 0; i < numOfTotalIntervals; i++){
            //跳过所有被消除了的老区间
            while(index < intervals.length && intervals[index] == null){
                index++;
            }
            //判断当前应该插入新区间还是老区间
            //根据[要求返回的结果依然有序]
            //判断新区间是否出现在即将插入的老区间的前面
            if(!newIntervalInserted // 新区间只能被插入一次
                    && ( // 新区间应当比老区间`小`
                    index == intervals.length // 新区间后面已经没有候选的老区间了
                            || newInterval[0] < intervals[index][0])){ // 新区间比候选老区间更小
                ans[i] = newInterval;
                newIntervalInserted = true;
            }else{
                ans[i] = intervals[index];
                index++;
            }
        }
        return ans;
    }

}
