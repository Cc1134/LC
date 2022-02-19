package String;

/**
 * @ClassName: Lc43MultiplyStrings
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/13/22 12:04 pm
 * @Version 1.0
 */
public class Lc43MultiplyStrings {
    public String multiply(String _num1, String _num2) {
        char[] num1 = _num1.toCharArray();
        char[] num2 = _num2.toCharArray();
        char[] ans = new char[400];
        for(?){
            ?//把ans里的数位先全初始化成0
        }
        //语义：i取"倒数第x"，例如 i = 1，表示数组的倒数第一个元素[len-1]
        for(int i = 1; i <= num2.length; i++){
            int factor = num2[?] - '0'; // 从num2里倒着提取数位作为乘数因子
            int jinwei = 0; // 用于记录(+1)(+2)etc
            int j = 1; // num1[-j]反向下标
            while(
                    jinwei != 0 // 有待进位的(+x)未处理
                            || j <= num1.length // num1未走完一圈
            ){
                int x = ?; // 提取num1[-j]的数位
                if(?){ // (例如4*6, 进(+2)时越界怎么办？)
                    x = num1[?] - '0'; // 从num1里倒着提取数位作为被乘数
                }
                int res = ans[?]+?*?+?;
                jinwei = ?; // 提取进位数(+x)
                res = ?; // 把res只留下个位数
                ans[?] = (char)(?+'0'); // 写入ans数组
                ?++; // num1下标步进
            }
        }
        int countOfZeros = 0;
        while(?){ // 从开头向后数'0'的个数
            countOfZeros++;
        }
        if(countOfZeros == ?){ // 全是0，特判
            return ?;
        }
        //返回截去开头0之后，剩下的数位
        return String.copyValueOf(?, ?, ?);
    }

}

