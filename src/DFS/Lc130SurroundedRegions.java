package DFS;

/**
 * @ClassName: Lc130SurroundedRegions
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/2/22 5:25 pm
 * @Version 1.0
 */
public class Lc130SurroundedRegions {
    void dfs(char[][] board, int i, int j) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length) {
            return;
        }
        if (board[i][j] != 'O') {
            return;
        }

        //经过以上两个if...return，当前节点一定是可以走的
        //先对当前节点重新染色，防止出现回头路(死循环)
        board[i][j] = 'A';
        //上下左右尝试做出行动
        dfs(board, i + 1, j);
        dfs(board, i - 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public void solve(char[][] board) {
        //横向长度
        int m = board.length;
        //竖向长度
        int n = board[0].length;

        for (int i = 0; i < m; i++) {

            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int j = 0; j < n; j++) {
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            if (board[m - 1][j] == 'O') {
                dfs(board, m - 1, j);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
                if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
        }
    }
}

