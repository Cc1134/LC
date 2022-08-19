package String;

/**
 * @ClassName: Lc5LongestPalindromicSubstring
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/7/22 5:14 pm
 * @Version 1.0
 */
public class Lc5LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        char[] chars = s.toCharArray();
        // 标记最大长度的子串起点和终点
        int maxlen = 1; // 至少可以找到单字符的字符串作为长度1的回文子串
        int begin = 0; // 子串的第一个字符是s[0]
        int end = 0; // 子串的最后一个字符是s[0]
        //穷举所有回文子串中心点的下标
        for(int i = 0; i < chars.length; i++){
            //先检验单数字符回文串的最长情况
            int L = i;
            int R = i;
            while(L-1 >= 0 // 左端点的外面仍然取得到值(没有下标越界)
                    && R+1 < chars.length // 右端点的外面仍然取得到值
                    && chars[L-1] == chars[R+1] // 左端点外面和右端点外面字符一致
            ){
                //断点外扩
                L--;
                R++;
            }
            /*
            s[L], s[R], R-L+1
            maxlen <- max(expr{info1,...})
            begin <- info1,... where expr{info1,...} == max(expr{info1,...})
            expr: 'R-L+1'(length of substring)
            info: R, L (variables in expr)
            declare record
            if(rule(record is out of date)){
                record <- expr // update record
            }
            */
            if(maxlen < (R - L + 1)){
                maxlen = R - L + 1;
                begin = L;
                end = R;
            }

            if( // 开始探测偶数回文串的条件
                    i+1 < chars.length // s[i+1]存在，不是越界的
                            && chars[i] == chars[i+1] // 紧邻着s[i]的右边字符需要与s[i]一致
            ){
                L = i;
                R = i+1;
                while(L-1 >= 0 && R+1 < chars.length && chars[L-1] == chars[R+1]){
                    L--;
                    R++;
                }
                if(maxlen < (R - L + 1)){ // update record
                    maxlen = (R - L + 1);
                    begin = L;
                    end = R;
                }
            }
        }
        return s.substring(begin, end+1);
    }

    public String longestPalindromeP(String s) {
        int start = 0;
        int end = 1;
        int maxlen = 1;
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int L = i;
            int R = i+1;
            while(0 <= L && R <= chars.length && chars[L] == chars[R-1]){
                if(maxlen < (R-L)){
                    maxlen = R - L;
                    start = L;
                    end = R;
                }
                L--;
                R++;
            }

            if(i < chars.length-1 && chars[i] == chars[i+1]){
                L = i;
                R = i+2;
                while(0 <= L && R <= chars.length && chars[L] == chars[R-1]){
                    if (maxlen < (R - L)){
                        maxlen = R - L;
                        start = L;
                        end = R;
                    }
                    L--;
                    R++;
                }
            }
        }
        return s.substring(start,end);
    }
}

