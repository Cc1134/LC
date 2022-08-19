package HashTable;

import java.util.HashMap;
import java.util.Locale;

/**
 * @ClassName: Lc12IntegertToRoman
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/26/22 5:00 pm
 * @Version 1.0
 */
public class Lc12IntegertToRoman {
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
String ans = "";
余数 = 1250
ans += "M" -> 找到一个比余数小的、最大的计数单位
余数 -= 1000
余数 == 250 -> 把计数单位追加到String ans之后，计算剩下需要被计数单位解析的余数
ans += "C"
余数 -= 100
余数 == 150
ans += "C"
余数 -= 100
余数 == 50
ans += "L"
余数 -= 50
余数 == 0
*/

    public static String intToRoman(int num) {
        //建立hash<key-value>
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
        String ans = "";

        while(num > 0){
            String mykey = null;
            int myvalue = 0;
            for (String key : map.keySet()){
                int randomNum = map.get(key);
                if (randomNum <= num && myvalue < randomNum){
                    myvalue = randomNum;
                    mykey = key;
                }
            }
            ans += mykey;
            num -= myvalue;
        }

        return ans;
    }


}


