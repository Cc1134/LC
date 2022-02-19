package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: Lc3LongestSubstringWithoutRepeatingCharacters
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/26/22 7:00 pm
 * @Version 1.0
 */
public class Lc3LongestSubstringWithoutRepeatingCharacters {
    boolean hasRepeat(String sub){
        //对于每一个子串
        HashSet<Character> set = new HashSet<Character>();

        //用set来存储下标k遍历子串时所见过的字符
        //如果新的字符出现在set里(也就是已经见过)
        //那么这个字符串不符合“字符不相重复”
        //否则的话，子串就是一个不重复的串
        boolean hasRepeat = false;
        //在还没开始遍历的时候，默认其中没有重复的字符
        for(int k = 0; k < sub.length(); k++){ //遍历你的子串
            if(set.contains(sub.charAt(k))){
                //遇到重复的字符时，把repeat flag设置为T
                hasRepeat = true;
                break;
            }else{
                set.add(sub.charAt(k));
            }
        }
        return hasRepeat;
    }
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        int maxlen = 0;
        for(int begin = 0; begin <= s.length()-1; begin++){
            for(int end = begin+1; end <= s.length(); end++){
                if(!hasRepeat(s.substring(begin, end))){
                    int len = end-begin;
                    if(len > maxlen){
                        //求出最大的子串的长度
                        maxlen = len;
                    }
                }else{
                    break;
                }
            }
        }
        return maxlen;
    }
}

//class Solution {
//
//    int maxLengthOfNonRepeat(String s, int begin){
//        //对于每一个子串
//        HashSet<Character> set = new HashSet<Character>();
//        int maxlen = 0;
//        for(int i = begin; i < s.length(); i++){
//            if(set.contains(s.charAt(i))){
//                break;
//            }else{
//                set.add(s.charAt(i));
//                maxlen += 1;
//            }
//        }
//        return maxlen;
//    }
//    public int lengthOfLongestSubstring(String s) {
//        //前提假设：s.length()被称之为O(n)
//        if(s.length() <= 1){
//            return s.length();
//        }
//        int maxlen = 0;
//        //O(n) for
//        for(int begin = 0; begin <= s.length()-1; begin++){
//            int len = maxLengthOfNonRepeat(s, begin);
//            if(len > maxlen){
//                maxlen = len;
//            }
//        }
//        //O(n^2)
//        return maxlen;
//    }
//}

//最优版本
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0){
            return 0;
        }
        int start = 0;
        int end = 1;
        int maxlen = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(s.charAt(start));
        while(true){
            //尾指针指向的元素不在set内时
            while(end < s.length() && (!(set.contains(s.charAt(end))))){
                //先把指向的这个元素添加到set里
                set.add(s.charAt(end));
                end++;
            }
            if(maxlen < end){
                maxlen = end - start;
            }
            //end达到最大
            if(end >= s.length()){
                //不再需要走任何指针
                return maxlen;
            }
            //此处往下的代码运行的时候，必然有end未达到最大
            //s[end]一定指向有效的字符
            //并且这个字符与set内的字符相冲突
            while(true){ // 假定无限的无条件的向下移动头指针
                char character = s.charAt(start);
                //remove c from set
                set.remove(character);
                start++;
                //刚刚抛掉了的c是不是解决了s[end]的重复问题
                if(character == s.charAt(end)){
                    break;
                }
            }
        }
    }
}