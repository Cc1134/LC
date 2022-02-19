package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Lc13RomanToInteger
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/26/22 5:57 pm
 * @Version 1.0
 */
public class Lc13RomanToInteger {
    /*
I             1
IV            4
V             5
IX            9
X             10
XL            40
L             50
XC            90
C             100
CD            400
D             500
CM            900
M             1000
*/
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int ans = 0;

        while (s.length() > 0) {
            if (s.length() > 1 && map.containsKey(s.substring(0, 2))) {
                ans += map.get(s.substring(0, 2));
                s = s.substring(2, s.length());
            } else {
                ans += map.get(s.substring(0, 1));
                s = s.substring(1, s.length());
            }
        }
        return ans;
    }
}

