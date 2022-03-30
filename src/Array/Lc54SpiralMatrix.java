package Array;

import java.util.ArrayList;
import java.util.List;

public class Lc54SpiralMatrix {
    void traverse(int[][] matrix, int height, int width, int m, int n,
                  List<Integer> ans){
        int rowIndexStart = (m-height)/2; // 1
        int rowIndexEnd = m-1-rowIndexStart; // 1
        int colIndexStart = (n-width)/2;  // 1
        int colIndexEnd = n-1-colIndexStart; // 1
        for(int j = colIndexStart; j < colIndexEnd; j++){
            ans.add(matrix[rowIndexStart][j]);
        }
        for(int i = rowIndexStart; i < rowIndexEnd; i++){
            ans.add(matrix[i][colIndexEnd]);
        }
        if(rowIndexStart == rowIndexEnd || colIndexStart == colIndexEnd){
            ans.add(matrix[rowIndexEnd][colIndexEnd]);
            return;
        }
        for(int j = colIndexEnd; j > colIndexStart; j--){
            ans.add(matrix[rowIndexEnd][j]);
        }
        for(int i = rowIndexEnd; i > rowIndexStart; i--){
            ans.add(matrix[i][colIndexStart]);
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> ans = new ArrayList<>(m*n);
        int heightOfCircle = m;
        int widthOfCircle = n;
        while(heightOfCircle > 0 && widthOfCircle > 0){
            //遍历当前这一圈
            traverse(matrix, heightOfCircle, widthOfCircle, m, n, ans);
            heightOfCircle-=2;
            widthOfCircle-=2;
        }
        return ans;
    }







    void traverse(int[][] matrix, int height, int width, int m, int n,
                  List<Integer> ans){
        int rowIndexStart = (m-height)/2; // 1
        int rowIndexEnd = m-1-rowIndexStart; // 1
        int colIndexStart = (n-width)/2;  // 1
        int colIndexEnd = n-1-colIndexStart; // 1
        for(j: col[start -> end-1]){
            ans.add(matrix[rowIndexStart][j]);
        }
        for(i: row[start -> end-1]){
            ans.add(matrix[i][colIndexEnd]);
        }
        if(rowIndexStart == rowIndexEnd || colIndexStart == colIndexEnd){
            ans.add(matrix[rowIndexEnd][colIndexEnd]);
            return;
        }
        for(j: col[end -> start+1]){
            ans.add(matrix[rowIndexEnd][j]);
        }
        for(i: row[end -> start+1]){
            ans.add(matrix[i][colIndexStart]);
        }
    }
    public List<Integer> spiralOrder(int[][] matrix) {
        [m,n] = height(mat), width(mat)
        List<Integer> ans = new ArrayList<>(m*n);
        int heightOfCircle = m;
        int widthOfCircle = n;
        while(heightOfCircle > 0 && widthOfCircle > 0){
            //遍历当前这一圈
            traverse(matrix, heightOfCircle, widthOfCircle, m, n, ans);
            heightOfCircle-=2;
            widthOfCircle-=2;
        }
        return ans;
    }


}
