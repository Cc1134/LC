package HashTable;

/**
 * @ClassName: Lc36ValidSudoku
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/27/22 8:41 am
 * @Version 1.0
 */
public class Lc36ValidSudoku {
    //36. 有效的数独
    public boolean isValidSudoku(char[][] board) {
        //遍历每个“第i行”
        for(int i = 0; i < 9; i++){
            //建立空的hashset来存储和检测“第i行”是否有重复的1~9
            HashSet<Character> set = new HashSet<>();
            //遍历这一行里的每个元素
            for(int j = 0; j < 9; j++){
                //得到即将被判断是否重复的字符
                char c = board[i][j];
                //如果这一格空着，那么跳过判断
                if(c == '.'){
                    continue;
                }
                //如果已经重复了，直接返回false表示“not valid sudoku”
                if(c in set){
                    return false;
                }
                //否则把见过的字符c放进set里，进入到下一个检测循环
                add c to set;
            }
        }

        //遍历每个“第j列”(参考遍历“第i行”)
        for(j){
            new set
            for(i){
                c = ?
                if(c==空白){
                    ?
                }
                if(?重复){
                    return false;
                }
                add ? to ?
            }
        }
        //遍历每个九宫格
        //按照3的步进，依次遍历到0,3,6，这是九宫格的行坐标的开头
        for(int i = 0; i < 9; i+=3){
            //按照3的步进遍历0,3,6作为列坐标的开头
            for(int j = 0; j < 9; j+=3){
                new set // 建立用于判断重复的集合
                //遍历九宫格坐标[m][n]
                for(int m = i; m < i+3; m++){
                    for(int n = j; n < j+3; n++){
                        char c = board[?][?];
                        if(c==空白){
                            ?
                        }
                        if(?重复){
                            return false;
                        }
                        add ? to ?
                    }
                }
            }
        }
        //前面所有return false都没发生，说明没有重复内容
        //返回true表示“valid”
        return true;
    }

}

