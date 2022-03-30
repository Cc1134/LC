package Array;

public class Lc63UniquePathsII {

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = obstacleGrid[0][0]==1?0:1; // 如果左上角第一个元素上有障碍物，那么左上角只有0个可行方案
        for(int j = 1; j < n; j++){
            dp[0][j] = dp[0][j-1]; // 第一行的每个格子，有路径可以到达它的前提是，有路径可以到达它左侧的格子
            if(obstacleGrid[0][j] == 1){ // 遇到障碍物，则当前方块的可行方案数归零
                dp[0][j] = 0;
            }
        }
        for(int i = 1; i < m; i++){
            dp[i][0] = dp[i-1][0]; // 第一列的每个格子，有路径可以到达它的前提是，有路径可以到达它上侧的格子
            if(obstacleGrid[i][0] == 1){ // 遇到障碍物，则当前方块的可行方案数归零
                dp[i][0] = 0;
            }
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
                if(obstacleGrid[i][j] == 1){ // 遇到障碍物，则当前方块的可行方案数归零
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m-1][n-1];
    }

}
