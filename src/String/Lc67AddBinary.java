package String;

/**
 * @ClassName: Lc67AddBinary
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/13/22 12:03 pm
 * @Version 1.0
 */
public class Lc67AddBinary {
    //一个二进制数x，它有n个二进制数位(e.g. n=4)
    //x最大等于？0b1111 aka 15 == power(2, 4)-1
    //x的共计n个二进制数位，每个数位上都应该是"1"(而不是"0")
    //x在10进制的取值是power(2, n)-1
    //根据题目，n <= 10000
    //a, b <= power(2, 10000)-1
    //max(a+b) == power(2, 10001)-2
    //power(2, 10000)-1 < max(a+b) < power(2, 10001)-1
    //设得数变量记为c=a+b, c可以用10001个二进制数位刚好放下
    public String addBinary(String _a, String _b) {
        char[] a = _a.toCharArray();
        char[] b = _b.toCharArray();
        char[] c = new char[?];
        //语义：i=1表示取数组的倒数第1个元素arr[len-i]
        int i = 1;
        int jinwei = ?;
        while(?){ // 存在未处理的进位, 未处理的a或b数位
            int numA = 0;
            int numB = 0;
            if(?){ // 越界检查
                numA = ?; // 提取a的倒数第i位
            }
            if(?){
                numB = ?;
            }
            int ans = ?+?+?;
            jinwei = ?;
            ans %= ?;
            c[?] = ?;
            ?++;
        }
        int countOfZeros = ?;
        while(? && c[countOfZeros] == 0){
            ?++;
        }
        if(?){ // 所有字符全都是0的情况下
            return ?;
        }
        return String.copyValueOf(?, ?, ?);
    }

}

