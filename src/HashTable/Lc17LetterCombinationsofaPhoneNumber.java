package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: Lc17LetterCombinationsofaPhoneNumber
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/27/22 8:40 am
 * @Version 1.0
 */
public class Lc17LetterCombinationsofaPhoneNumber {
    //17. 电话号码的数字组合
    //recurr: 递归函数
    //i: 当前正在处理的第i个按键的下标(从0开始计数)
    //digits: 题目输入的所有按键
    //ans: 来自主函数传递的结果数组
    //current: 当前正在被枚举出的可能的字母组合
    //map: 来自主函数传递的“数字到字母的映射关系”
    void recurr(
            int i, String digits, ArrayList<String> ans,
            String current, HashMap<Character, String> map){
        //当i取值等同于digits长度相同时，也就是说没有需要处理的第i个按键了
        if(i == digits.length()){
            ans.add(current); // 把枚举出来的字母组合添加到结果数组中
            return; // 终止递归
        }
        //从map中得到将要处理的digits[i]所对应的所有可能的字母

        String str = map.get(digits.charAt(i));
        //遍历所有可能的字母
        for(int j = 0; j <= str.length()-1; j++){
            //拼合current和每个可能的字母
            char currentChar = str.charAt(j);
            //然后对每个拼合结果都向下递归处理digits[i+1]
            recurr(i+1, digits, ans, current+currentChar, map);
        }
    }

    public List<String> letterCombinations(String digits) {
        //建立hashmap, 把数字按键映射到所有可能的字母列表上
        HashMap<Character, String> map = new HashMap<Character, String>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");
        //初始化结果数组
        ArrayList<String> ans = new ArrayList<String>();
        //特判, digits如果是空，直接返回空结果
        if(digits == null){
            return ans; // 参见示例2
        }
        //递归
        recurr(0, digits, ans, "", map);
        return ans;
    }

}

