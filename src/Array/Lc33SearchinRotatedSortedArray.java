package Array;

/**
 * @ClassName: Lc33SearchinRotatedSortedArray
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/18/22 11:17 am
 * @Version 1.0
 */
public class Lc33SearchinRotatedSortedArray {
    int len;
    int orig2rot(int index, int k){
        index-=k;
        if(index < 0){
            index += len;
        }
        return index;
    }
    public int search(int[] nums, int target) {
        int k = 0; // 假设数组是不曾旋转的
        if(如果数组的左端点比右端点更大，说明存在需要探测的旋转k值){
            //初始化左右端点，直到左右断点分别收缩到：
            //L: 原始数组的末尾(最大的数字)
            //R: 原始数组的开头(最小的数字)
            int L = 0;
            int R = nums.length-1;
            //当(L,R)中间还包括了其他下标取值时，继续二分收缩
            while(R-L>1){
                int mid = ?;
                //[mid]取值比左端点大说明mid是原始数组的后半段(靠近末尾而不是开头)
                if(nums[mid] > nums[?]){
                    ? = mid;
                }else{
                    ? = mid;
                }
            }
            //L: 指向原数组的尾
            //R: 指向原数组的头
            //k的长度，是右侧[R, len)的长度
            k = nums.length-R;
        }
        //orig: [num[0], ..., nums[k-1], nums[k], ..., nums[len-1], ____]
        //rot: [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
        //rot[i] = orig[i+k] = rot['i+k'-k]
        //orig[len > 'len-1'] -> i+k==len -> i = len-k
        //i=len-1? -> orig[len-1+k > 'len-1'] -> orig[k-1]
        //rot[i] = orig[(i+k)%len]
        //task:
        //orig[i] = rot[i-k]
        //orig[0] = rot[-k < 0]
        //orig[k] = rot[0]
        //orig[0...k-1] = rot[len-k...len-1]
        //orig[0...k-1] = rot[(-k...-1)+len]
        //orig[k+len] = rot[len%len]
        //int num, let int c equiv num%M
        //num++, num--, c

        //在原始数组上做二分查找(带有index offset proxy)
        int L = 0;
        int R = nums.length-1;
        len = nums.length;
        //offset proxy
        //检查左端点是否直接取到了target
        if(nums[orig2rot(L, k)] == target){
            return ?;
        }
        //检查右端点是否直接取到了target
        if(?){
            return ?;
        }
        //当(L,R)中还有未被探测的下标时
        while(R-L>1){
            int mid = ?;
            //根据nums[index offset proxy]与target的大小关系
            //判断收缩L指针还是R指针
            if(nums[?] < target){}

}

class Solution4 {
    int len;
    int orig2rot(int index, int k){
        index-=k;
        if(index < 0){
            index += len;
        }
        return index;
    }

//    int orig2rot(int index, int k){
//        return (index-k+len)%len;
//    }

    public int search(int[] nums, int target) {
        int k = 0; // 假设数组是不曾旋转的
        if(nums[0] > nums[nums.length-1]){
            int L = 0;
            int R = nums.length-1;
            while(R-L>1){
                int mid = L+(R-L)/2;
                if(nums[mid] > nums[L]){
                    L = mid;
                }else{
                    R = mid;
                }
            }
            //L: 指向原数组的尾
            //R: 指向原数组的头
            k = nums.length-R;
        }
        //orig: [num[0], ..., nums[k-1], nums[k], ..., nums[len-1], ____]
        //rot: [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]
        //rot[i] = orig[i+k] = rot['i+k'-k]
        //orig[len > 'len-1'] -> i+k==len -> i = len-k
        //i=len-1? -> orig[len-1+k > 'len-1'] -> orig[k-1]
        //rot[i] = orig[(i+k)%len]
        //task:
        //orig[i] = rot[i-k]
        //orig[0] = rot[-k < 0]
        //orig[k] = rot[0]
        //orig[0...k-1] = rot[len-k...len-1]
        //orig[0...k-1] = rot[(-k...-1)+len]
        //orig[k+len] = rot[len%len]
        //int num, let int c equiv num%M
        //num++, num--, c
        int L = 0;
        int R = nums.length-1;
        len = nums.length;
        if(nums[orig2rot(L, k)] == target){
            return orig2rot(L, k);
        }
        if(nums[orig2rot(R, k)] == target){
            return orig2rot(R, k);
        }
        while(R-L>1){
            int mid = L+(R-L)/2;
            if(nums[orig2rot(mid, k)] < target){
                L = mid;
                continue;
            }
            if(nums[orig2rot(mid, k)] > target){
                R = mid;
                continue;
            }
            return orig2rot(mid, k);
        }
        return -1;
    }
}