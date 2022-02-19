package HashTable;

/**
 * @ClassName: Lc49GroupAnagrams
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/27/22 8:37 am
 * @Version 1.0
 */
public class Lc49GroupAnagrams {
    groupAnagrams(String[] strs) {
        //初始化结果数组
        List<List<String>> ans = ?;
        //建立hashmap，用于通过“异位词的某种恒等表示”把
        //相同的恒等表示(key)映射到同一个存放它们的数组(value)上
        HashMap<String,ArrayList<String>> map = ?;
        for(String s: strs){ // 遍历每个输入的字符串
            //通过下面的for循环，把字符串里的每个字符
            //逐个放到字符数组中，得到与字符串等价的字符数组
            char[] arr = new char[s.length()];
            for(int i = 0...s.length()-1){
                ?//使用s.charAt对arr完成赋值
            }
            //通过对arr字符数组排序，得到异位词的恒等表示
            //例如：eat --> aet
            //     tea --> aet
            Arrays.sort(arr);
            // 字符数组ch转换回字符串对象
            String key=String.valueOf(ch);
            //如果恒等表示key不在map里
            //说明这一类异位词还没出现
            if(key not in map){
                // 生成一个新的ArrayList来存放这一类异位词
                ArrayList<String> array = ?;
                // 使恒等表示(key)和array(value)放入map中
                put array to map[key]
                // 把新生成的数组放入结果数组中
                add array to ans
            }
            //根据恒等表示key，从map中取出对应的数组
            ArrayList<String> array = ?
            //在对应的数组中放入当前异位词字符串
            add s to array

        }
        return ans;
    }

}

