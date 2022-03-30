package Array;

public class Lc74Searcha2DMatrix {
    // 74. 搜索二维矩阵
    // 观察到以下数学结论：
    // 每行的整数从左到右越来越大
    // 下一行的第一个整数比上一行的最后一个整数更大
    // 按照Z字形(row-major)遍历矩阵，将得到升序的序列
    // 需要解决的问题A：实现Z字形(row-major)的遍历
    // 需要解决的问题B：在升序的遍历序列上执行二分查找
    int get(int[][] matrix, int index, int n){
        // 升序遍历映射，输入下标index，返回升序遍历的情况下，
        // matrix的下标[index]处的数字（也就是升序遍历下的第{index+1}个数字）
        int i = index/n; // 向下取整地除，从index变换出行号
        int j = index%n; // 取余，从index变换出列号
        return matrix[i][j]; // 取出matrix[i][j]的数值作为返回值
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        // 基于get函数提供的升序遍历映射，
        // 在左闭右开[0, m*n)上做二分查找
        int m = matrix.length;
        int n = matrix[0].length;
        int L = 0;
        int R = m*n-1;
        if(get(matrix,L,n) == target || get(matrix,R,n) == target){
            return true;
        }
        while(L < R-1){
            int mid = L+(R-L)/2;
            int a = get(matrix, mid, n);
            if(a == target){
                return true;
            }
            if(a < target){
                L = mid;
            }else{
                R = mid;
            }
        }
        return false;
    }

}
