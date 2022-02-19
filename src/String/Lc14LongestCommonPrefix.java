package String;

/**
 * @ClassName: Lc14LongestCommonPrefix
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/7/22 7:07 pm
 * @Version 1.0
 */
public class Lc14LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null){
            return null;
        }
        int prefix = 0;
        boolean flag = false;
        while (true){
            if (strs[0].length() <= prefix){
                break;
            }
            char c = strs[0].charAt(prefix);
            for(String s: strs){
                if(s.length() <= prefix || s.charAt(prefix) != c){
                    flag = true;
                    break;
                }
            }
            if(flag){
                break;
            }
            prefix++;
        }
        return strs[0].substring(0,prefix);
    }
}

