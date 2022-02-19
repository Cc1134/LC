package String;

/**
 * @ClassName: Lc125ValidPalindrome
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/13/22 11:45 am
 * @Version 1.0
 */
public class Lc125ValidPalindrome {
    boolean AZaz09(char c){
        //当输入的字符c处在：
        // -大写字母
        // -小写字母
        // -阿拉伯数字
        // 此时返回true
        // 否则返回false
        return ?;
    }
    char toLower(char c){
        //当输入的字符c是大写字母时
        //将其转换为小写字母
        //否则保持其不变
        ??
        return c;
    }
    public boolean isPalindrome(String _s) {
        char[] s = _s.toCharArray();
        int L = ?; // 初始化左右指针
        int R = ?;
        while(true){
            while(L < R && !?(s[L])){ // 当遇到不被考虑的字符类型时，跳过
                L++;
            }
            while(L < R && !?(s[R])){
                R--;
            }
            if(){ // 当L和R指针已经相遇（或者延反方向相互跨越）时，
                // 判断完成，确定是回文串
                return ?;
            }
            if(?(?[L]) != ?(?[R])){ // 比较回文串两端的字母，注意要考虑跨越大小写
                return ?;
            }
            L++; // 左指针步进
            R--; // 右指针步进
        }
    }

}

