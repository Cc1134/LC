package Array.presum;

public class Lc53 {

        int max(int a, int b){
            return a>=b?a:b;
        }
        public int maxSubArray(int[] nums) {
            int[] pSum = new int[nums.length+1];
            pSum[0] = 0;
            for(int i = 1; i <= nums.length; i++){ // O(n)
                pSum[i] = pSum[i-1]+nums[i-1];
            }
            //maxPEnd[start]: max@[start<=end<nums.length]{pSum[end+1]}
            //-> maxPEnd[nums.length-1]: max@[(len-1)<=end<len]{pSum[end+1]}
            //-> maxPEnd[nums.length-1]: max@[end==len-1]{pSum[end+1]}
            //-> maxPEnd[nums.length-1] == pSum[nums.length]
            //另一个结论：
            //maxPEnd[len-2] = max{pSum[len-1], pSum[len]}
            //maxPEnd[len-3] = max{pSum[len-2], pSum[len-1], pSum[len]}
            //maxPEnd[len-4] = max{pSum[len-3], pSum[len-2], pSum[len-1], pSum[len]}
            //maxPEnd[len-4] = max{pSum[len-3], max{pSum[len-2], pSum[len-1], pSum[len]}}
            //maxPEnd[len-4] = max{pSum[len-3], maxPEnd[len-3]}
            //maxPEnd[start < (len-1)] = max{pSum[start+1], maxPEnd[start+1]}
            int[] maxPEnd = new int[nums.length];
            maxPEnd[nums.length-1] = pSum[nums.length];
            for(int start = nums.length-2; start >= 0; start--){ // O(n)
                maxPEnd[start] = max(pSum[start+1], maxPEnd[start+1]);
            }
            //A[i] = f(A[i-1])
            //A[i] = f(A[i+1])

            int max = nums[0];
            for(int start = 0; start < nums.length; start++){ // O(n)
                int pStart = pSum[start];
            /*
            //maxPEnd: max@[start<=end<nums.length]{pSum[end+1]} // O(n)
            int maxPEnd = pSum[start+1];
            for(int end = start; end < nums.length; end++){
                //'max' pattern: compare-update `record: maxPEnd`
                if(maxPEnd < pSum[end+1]){
                    maxPEnd = pSum[end+1];
                }
            }
            */
                int currentSum = maxPEnd-pStart;
                if(max < currentSum){
                    max = currentSum;
                }
            /*
            //max@[start<=end<nums.length]{expr: currentSum=pSum[end+1]-pStart}
            //~ max@[start<=end<nums.length]{pSum[end+1]}
            for(int end = start; end < nums.length; end++){
                int currentSum = pSum[end+1]-pStart;
                if(max < currentSum){
                    max = currentSum;
                }
            }
            */
            }
            return max;
        }

}



class Solution {
    public int maxSubArray(int[] nums) {
        //`前缀和prefixSum`
        //`pSum[i] = sum(nums[0...(i-1)])`
        //朴素算法：枚举出所有的前缀和
        [prefix: optional] + [others: optional]
        [] + nums => nums
                [nums[0]] + [nums[1...(n-1)]]
        sum([nums[0], nums[1]]) + [nums[2...(n-1)]]
        nums + [] => nums
        //for: O(n)
        for(int numOfPrefix = 0; numOfPrefix <= nums.length; numOfPrefix++){
            //sum[numOfPrefix] = (1st+last)*nTerms/2 = (0+n)*(n+1)/2
            //mean[...] = sum[...]/(n+1) = (0+n)/2 ~ O(n)
            {//inner-block: 枚举prefix里的前{numOfPrefix}个元素，累加
                int sum = 0;
                // inner loop: O(n)
                for(int i = 0; i < numOfPrefix; i++){
                    sum += nums[i];
                }
                // 就得到了sum@numOfPrefix的取值
            }
        }
        //O(n)*O(n) ~ O(n^2)
        Const*(10^10)
        pSum[0] = 0;
        pSum[1] = nums[0]; // pSum[0]+nums[0]
        pSum[2] = nums[0]+nums[1]; // pSum[1]+nums[1]
        pSum[3] = nums[0]+nums[1]+nums[2]; // pSum[2]+nums[2]


        pSum[0] = 0;
        for(int i = 1; i <= nums.length; i++){ // O(n)
            pSum[i] = pSum[i-1]+nums[i-1];
        }
    }
}


class Solution1 {
    int min(int a, int b){
        return a<=b?a:b;
    }
    public int maxSubArray(int[] nums) {
        //for{for{...}} O((10^5)^2) = O(10^10) > 1G(Hz)
        //prefix sum
        //max@{i,j}(sum(nums[i..j]))
        //sum(nums[i..j]) = sum(nums[0..j]) - sum(nums[0..(i-1)])
        //[左闭右闭nums[i,j]之和] = [前j+1个元素的前缀和] - [前i个元素的前缀和]
        //  max@{i,j}(sum(nums[i..j]))
        //= max@{i,j}(sum(nums[0..j])) - min@{i,j}(sum(nums[0..(i-1)]))
        //= max@{j}(sum(nums[0..j])) - min@{i}(sum(nums[0..(i-1)]))
        //= max@{j}(  cumsum[j+1] - min@{i <= j}(cumsum[i])  )
        //**错**= max@{j}(cumsum[j+1]) - min@{i <= j}(cumsum[i]))
        //0 <= i,j < length
        //sum([a,b,c,...]) - sum([])

        //cumsum[i] 表示 sum(nums[0..(i-1)])
        //[下标[i]对应了前i个元素的前缀和]
        //[下标[j+1]对应了前j+1个元素的前缀和]
        //sum(nums[0..-1]) = 0
        //sum(nums[0..i]) = sum(nums[0..(i-1)])+nums[i]
        //sum(nums[0..(i-1)]) = sum(nums[0..(i-2)])+nums[i-1]
        //cumsum[i+1] = cumsum[i]+nums[i]
        int[] cumsum = new int[nums.length+1];
        for(int i = 0; i < nums.length; i++){
            cumsum[i+1] = cumsum[i]+nums[i];
        }

        //构造如下数组：
        //minI[j]: min@{i <= j}(sum(nums[0..(i-1)]))
        //minI[j = 0] = cumsum[0] = 0
        //minI[j > 0] = min{cumsum[0], ..., cumsum[j-1], cumsum[j]}
        //minI[j > 0] = min{min{cumsum[0], ..., cumsum[j-1]}, cumsum[j]}
        //            = min{minI[j-1], cumsum[j]}
        //minI[0] = cumsum[0]
        //minI[1] = min{cumsum[0],cumsum[1]}
        //minI[2] = min{cumsum[0],cumsum[1],cumsum[2]}
        //minI[2] = min{minI[1],cumsum[2]}
        int[] minI = new int[nums.length];
        minI[0] = cumsum[0];
        /*
        for(int j = 1; j < nums.length; j++){
            minI[j] = min(minI[j-1], cumsum[j]);
        }
        */
        //max{a,b,c,d,e,f}
        //max = a;
        //max = max>=a?:max:a;
        //max = max>=b?:max:b;
        //max = max>=c?:max:c;
        // j = 0

        int ans = cumsum[0+1]-minI[0]; // (-2-0)
        for(int j = 1; j < nums.length; j++){
            minI[j] = min(minI[j-1], cumsum[j]);
            if(ans < cumsum[j+1]-minI[j]){//ans less -2 - (minI[j=1]: min{0, -2})
                ans = cumsum[j+1]-minI[j];
            }
        }
        return ans;
    }










    public int maxSubArraydyq(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int res = dp[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] += Math.max(0,dp[i-1]); // i = 2
            res = Math.max(dp[i],res);
        }
        return res;
    }






}