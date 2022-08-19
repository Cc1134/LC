package String;

/**
 * @ClassName: Lc6ZigzagConversion
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/7/22 6:33 pm
 * @Version 1.0
 */
public class Lc6ZigzagConversion {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        //对每一行都初始化一个StringBuilder用于填充、记录Z字形走位的字符
        StringBuilder[] builders = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            builders[i] = new StringBuilder();
        }
        int row = 0; // 从第0行开始走
        int step = 1; // 先从上向下走
        for(char c: s.toCharArray()){
            builders[row].append(c); // 找到特定的行，把被遍历到的字符c填充到行尾
            row += step; // 行走一步
            if(row == numRows){ // 当向下行走到越界的“第n+1行”时
                row = numRows - 2; // 折返回到倒数第2行
                step = -1; // 行走方向标记为“从下向上”
            }
            if(row < 0){ // 当向上行走到越界的“第-1行”时
                row = 1; // 折返回到第2行
                step = 1; // 行走方向标记为“从上向下”
            }
        }
        for(int i = 1; i < numRows; i++){ // 依次把builders[1, ..., n-1]行追加到第[0]行的末尾去
            builders[0].append(builders[i]);
        }
        return builders[0].toString(); // 返回第0行的字符串
    }

}


