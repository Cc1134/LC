package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Lc91DecodeWays
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/13/22 11:57 am
 * @Version 1.0
 */
public class Lc91DecodeWays {




    //递归
    Map<String, Integer> map = new HashMap<>();
    public int numDecodings(String s) {
        if(s.length() == 0){
            return 1;
        }
        if(s.charAt(0) == '0'){
            return 0;
        }
        Integer cachedAns = map.get(s);
        if(cachedAns != null){
            return cachedAns;
        }
        int ans = 0;
        if(s.length() == 1 || s.charAt(1) != '0'){
            ans += numDecodings(s.substring(1, s.length()));
        }
        if(s.length() >= 2){
            int code = (s.charAt(0)-'0')*10+s.charAt(1)-'0';
            if(1 <= code && code <= 26){
                ans += numDecodings(s.substring(2, s.length()));
            }
        }
        map.put(s, ans);
        return ans;
    }

















    //map
    int[] map;
    int dfs(char[] s, int i){
        // 以s[i]为起点，以s[len-1]为终点的字符串，产生的解码总方案数
        if(i == s.length){
            return 1;
        }
        if(s[i] == '0'){
            return 0;
        }
        int ans = 0;
        if(s.length-i == 1 || s[i+1] != '0'){
            //认为i+1的情况必然出现在缓存里
            //ans += dfs(s, i+1);
            ans += map[i+1];
        }
        if(s.length-i >= 2){
            int code = (s[i]-'0')*10+(s[i+1]-'0');
            if(1 <= code && code <= 26){
                //认为i+2的情况必然出现在缓存里
                //ans += dfs(s, i+2);
                ans += map[i+2];
            }
        }
        return ans;
    }

    public int numDecodingsMap(String _s) {
        char[] s = _s.toCharArray();
        map = new int[s.length+1];
        map[s.length] = 1;
        for(int len = 1; len <= s.length; len++){
            int i = s.length-len;
            map[i] = dfs(s, i); //map.put
        }
        return map[0];
        /*
        "" -> 1
        s.substring(0,1) == "1"
        [0]"" -> 1 (pri)
        [1]"1" -> "/1" -> 1
        [2]"11" -> "/11", "1/1" -> 2
        [3]"111" -> "1/11", "11/1" -> 3
        [4]"1110" -> "11/10" -> 2
        [len]"11106" -> "1110/6" -> 2
        */
    }








    //dp
    public int numDecodingsdp(String _s) {
        char[] s = _s.toCharArray();
        int[] dp = new int[s.length+1];
        dp[0] = 1; // s.sub(0,0) -> 1
        for(int i = 1; i <= s.length; i++){
            //求dp[i] = numDecodings(s.substring(0,i))
            //String sub = s.substring(0,i)
            if(s[i-1] != '0'){
                //ans += numDecodings(s.substring(0,i-1))
                dp[i] += dp[i-1];
            }
            if(i >= 2){
                //s[i-2] == sub.charAt(sub.length()-2)
                //s[i-1] == sub.charAt(sub.length()-1)
                int code = (s[i-2]-'0')*10+(s[i-1]-'0');
                if(10 <= code && code <= 26){
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[s.length];
        /*
        "" -> 1
        s.substring(0,1) == "1"
        [0]"" -> 1 (pri)
        [1]"1" -> "/1" -> 1
        [2]"11" -> "/11", "1/1" -> 2
        [3]"111" -> "1/11", "11/1" -> 3
        [4]"1110" -> "11/10" -> 2
        [len]"11106" -> "1110/6" -> 2
        */
    }

}

