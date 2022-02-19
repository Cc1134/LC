package DFS;

/**
 * @ClassName: Lc200NumberofIslands
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/2/22 4:57 pm
 * @Version 1.0
 */
public class Lc200NumberofIslands {
    void dfs(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length || j < 0 || j >= grid[i].length){
            return;
        }
        if(grid[i][j]!='1'){
            return;
        }
        //经过以上两个if...return，当前节点一定是可以走的
        //先对当前节点重新染色，防止出现回头路(死循环)
        grid[i][j] = '2';
        //上下左右尝试做出行动
        dfs(grid, i+1, j);
        dfs(grid, i-1, j);
        dfs(grid, i, j-1);
        dfs(grid, i, j+1);
    }
    public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[i].length; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

}

