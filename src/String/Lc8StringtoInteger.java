package String;

/**
 * @ClassName: Lc8StringtoInteger
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/9/22 5:32 pm
 * @Version 1.0
 */
public class Lc8StringtoInteger {
    public int myAtoi(String _s) {
        char[] s = _s.toCharArray();
        int i = 0;
        while(i < s.length && s[i] == ' '){ // 前导空格
            i++;
        }
        int sign = 1;
        if(s[i] == '+' || s[i] == '-'){ // 存在符号位
            if(s[i] == '-'){ // 符号位是“负号”
                sign = -1;
            }
            i++;
        }
        long ans = 0;
        while(s[i] >= '0' && s[i] <= '9'){ // 存在连续出现的0~9的数位(有效的数字符号)
            ans = ans*10 + s[i];
            i++;
            if(ans > 2147483647){ // 判断溢出
                if(sign == 1){
                    return 2147483647;
                }else{
                    return -2147483648;
                }
            }
        }
        return sign*(int)ans;
    }


    //分析
    public int myAtoii(String _s) {
        char[] s = _s.toCharArray();
        int i = 0;
        while(i < s.length && s[i] == ' '){
            i++;
        }
        int sign = 1;
        if(i < s.length && (s[i] == '+' || s[i] == '-')){
            if(s[i] == '-'){
                sign = -1;
            }
            i++;
        }
        int ans = 0;
        while(i < s.length && ('0' <= s[i] && s[i] <= '9')){
            if(
                    (ans*10)/10 != ans // 判断乘法是否导致溢出
                            || ans*10+(s[i]-'0') < 0// 判断加法是否导致溢出
            ){
                if(sign == 1){
                    return 2147483647;
                    /*
                    (x < 2147483648)
                    10*2147483647 > 2147483648
                    2147483647+2147483660
                    ans = 2147483647
                    ans++
                    ans < 0
                    ans--
                    如果ans+x得到溢出，
                    (ans+x)-x == ans

                    [-2147483648, 2147483647] / 10
                    (x*10) = y == math{(10x)%(2^32)}
                    y in [-2147483648, 2147483647]
                    y/10 = z (一定不会溢出)
                    z*10 <= y (一定不会溢出)
                    y=11, z = 1 == math{floor(y/10)}
                    |z*10| <= |y| (一定不会溢出)
                    矛盾于：(x*10)时，x可能导致溢出
                    => 当溢出时，x!=z
                    => 判断溢出：(x*10)/10 ?= x // z ?= x
                    */
                }else{
                    return -2147483648;
                }
            }
            ans = ans*10+(s[i]-'0');
            i++;
        }
        return sign*ans;
    }

}

