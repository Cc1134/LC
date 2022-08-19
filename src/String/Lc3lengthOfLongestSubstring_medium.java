package String;

import java.util.HashSet;

public class Lc3lengthOfLongestSubstring_medium {
    public int lengthOfLongestSubstring(String s){
        if(s.length() == 0){
            return 0;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = 1;
        int maxlen = 1;
        HashSet<Character> set = new HashSet<>();
        set.add(chars[start]);
        while(true){
            while(end < s.length() && (!set.contains(chars[end]))){
                set.add(chars[end]);
                end++;
            }
            if(maxlen < (end-start)){
                maxlen = end-start;
            }
            if(end >= s.length()){
                return maxlen;
            }
            while(set.contains(chars[end])){
                set.remove(chars[start]);
                start++;
            }
        }
    }
}
