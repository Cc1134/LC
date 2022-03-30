package Array;

public class Lc62UniquePaths {
    public int uniquePaths(int m, int n) {
        //m = 2, n = 100 -> 200
        //空间复杂度：O(m*n) -> O(2n) -> O( 2*min{m, n} )
        if(n > m){//利用对称性来减少O(2n)的开销
            int temp = m;
            m = n;
            n = temp;
        }
        int[] lastRow = new int[n];
        for(int j = 0; j < n; j++){
            lastRow[j] = 1;
        }
        int[] currentRow = new int[n];
        //O(2 rows)
        for(int i = 1; i < m; i++){
            currentRow[0] = 1;
            //row-major(inner O(n), outer O(m))
            //not col-major(inner O(m), outer O(n))
            for(int j = 1; j < n; j++){ // O(n)
                currentRow[j] = lastRow[j]+currentRow[j-1];
            }
            // swap(currentRow, lastRow)
            int[] temp = currentRow;
            currentRow = lastRow;/* free row[1st] */ /* new row[3rd] */
            lastRow = temp;

            /*
            lastRow = currentRow;
            currentRow = new int[n];
            free row[1st]
            */
        }
        return lastRow[n-1];
    }






    public int uniquePaths1(int m, int n) {
        if(m > n){
            int temp = m;
            m = n;
            n = temp;
        }
        int[] lastCol = new int[m];
        for(int i = 0; i < m; i++){
            lastCol[i] = 1;
        }
        int[] currentCol = new int[m];
        for(int j = 1; j < n; j++){
            currentCol[0] = 1;
            for(int i = 1; i < m; i++){
                currentCol[i] = lastCol[i]+currentCol[i-1];
            }
            int[] temp = lastCol;
            lastCol = currentCol;
            currentCol = temp;
        }
        return lastCol[m-1];
    }





    public int uniquePaths2(int m, int n) {
        int[][] dp = new int[m][n];
        for(int j = 0; j < n; j++){
            dp[0][j] = 1;
        }
        for(int i = 1; i < m; i++){
            dp[i][0] = 1;
            for(int j = 1; j < n; j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }



}
