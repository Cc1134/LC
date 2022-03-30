package Array;

public class Lc79WordSearch {
    // 79. 单词搜索
    // boolean dfs(board, i, j, word, index)
    // 返回“是否能从board[i][j]出发找到word[index...(len-1)]的字符串”
    boolean dfs(char[][] board, int i, int j, char[] word, int index){
        if(index == word.length){ // 如果index下标越界，不再需要匹配新的字符
            return true; // 字符全部匹配完毕，返回“匹配成功”
        }
        int m = board.length;
        int n = board[0].length;
        if(i < 0 || i >= m || j < 0 || j >= n){ // 走到了超出网格下标范围的地方
            return false; // 执行不到有意义的匹配，返回“匹配失败”
        }
        if(board[i][j] != word[index]){ // 当前格子上的字符不匹配当前字符串index下标
            return false; // 返回“匹配失败”
        }
        board[i][j] = 0; // 把当前格子上匹配成功的字符清除掉，防止在向下递归的过程中重复匹配同一字符
        boolean ans = // 上下左右四个方向四选一，匹配接下来的剩余字符串word[(index+1)...(len-1)]
                dfs(board, i-1, j, word, index+1) // 上
                        || dfs(board, i+1, j, word, index+1) // 下
                        || dfs(board, i, j-1, word, index+1) // 左
                        || dfs(board, i, j+1, word, index+1); // 右
        board[i][j] = word[index]; // 完成当前dfs时间线的匹配后，还原17行临时清除掉的字符
        return ans;
    }
    public boolean exist(char[][] board, String _word) {
        char[] word = _word.toCharArray();
        int m = board.length;
        int n = board[0].length;
        // 穷举所有单词可能开始的[i][j]位置
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(dfs(board, i, j, word, 0)){
                    return true; // 遇到dfs匹配成功的就直接放回true
                }
            }
        }
        return false; // 所有下标上dfs匹配都失败，返回false
    }

}
