package Array;

public class Lc73SetMatrixZeroes {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        //找到第一个出现的`0`
        int rowIndex = -1; // 设置为invalid取值，表示`0 not found`
        int colIndex = -1;
        for(int i = 0; i < m && rowIndex==-1; i++){
            for(int j = 0; j < n && colIndex==-1; j++){
                if(matrix[i][j] == 0){
                    rowIndex = i;
                    colIndex = j;
                }
            }
        }
        if(rowIndex == -1){ // 找不到0，那么不需要做修改，直接返回
            return;
        }
        //已知：要把row[rowIndex]和col[colIndex]设置为0
        //row[rowIndex]: 具有n个元素的、取值可以乱改(最终将设置为0)的数组空间
        //col[colIndex]: 具有m个元素的、取值可以乱改(最终将设置为0)的数组空间
        for(int i = 0; i < m; i++){
            if(i == rowIndex){
                continue;
            }
            for(int j = 0; j < n; j++){
                if(j == colIndex){
                    continue;
                }
                if(matrix[i][j] == 0){
                    matrix[rowIndex][j] = 0; // 把当前这一列[j]标记为`被设置0`
                    matrix[i][colIndex] = 0; // 把当前这一行[i]标记为`被设置0`
                }
            }
        }
        //查row[rowIndex]和col[colIndex]，把被标记为`设置0`的格子，实际设置为0
        for(int i = 0; i < m; i++){
            if(i == rowIndex){
                continue;
            }
            for(int j = 0; j < n; j++){
                if(j == colIndex){
                    continue;
                }
                if(matrix[rowIndex][j]==0 || matrix[i][colIndex]==0){
                    matrix[i][j] = 0;
                }
            }
        }
        //恢复col[colIndex]设置为0
        for(int i = 0; i < m; i++){
            matrix[i][colIndex] = 0;
        }
        //恢复row[rowIndex]设置为0
        for(int j = 0; j < n; j++){
            matrix[rowIndex][j] = 0;
        }
    }


}
