package String;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @ClassName: Lc179LargestNumber
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/14/22 10:33 pm
 * @Version 1.0
 */
public class Lc179LargestNumber {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int totalCount = 0;
        int numOfZeros = 0;
        for(int i = 0; i < nums.length; i++){
            strs[i] = ?; // 每一个nums中的数字转换为相应的字符串
            totalCount += ?; // 累加所有字符串的总字符数(不记录也可以,慢)
            if(? == 0){
                ?++; // 记录nums数组中'0'的个数
            }
        }
        if(?){ // 如果数组中全部都是'0'，那么直接返回'0'
            return "0";
        }
        // 字典序排序
        Arrays.sort(strs, (String a, String b) ->
                -(a+b).compareTo(b+a) // 需要仔细对比考虑前加“负号”对“大与小”的语义定义
        );
        // 拼接字符串
        StringBuilder builder = new StringBuilder(totalCount);
        for(?){
            builder.append(?);
        }
        return ?;
    }

}

class Solution1 {
    public String largestNumber(int[] nums) {
        String[] strs = new String[nums.length];
        int totalCount = 0;
        int numOfZeros = 0;
        for(int i = 0; i < nums.length; i++){
            strs[i] = String.valueOf(nums[i]);
            totalCount += strs[i].length();
            if(nums[i] == 0){
                numOfZeros++;
            }
        }
        if(nums.length == numOfZeros){
            return "0";
        }
//        Arrays.sort(strs, (String a, String b) -> -(a+b).compareTo(b+a));
        Arrays.sort(strs, new Comparator<String>(){
            public int compare(String a, String b) {
                return -(a+b).compareTo(b+a);
            }
        });
        StringBuilder builder = new StringBuilder(totalCount);
        for(String s: strs){
            builder.append(s);
        }
        return builder.toString();
    }
}