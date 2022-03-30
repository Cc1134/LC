package Array;

public class Lc48RotateImage_medium {
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for(int cir = 1; cir <= n/2; cir++){
            int widthOfCircle = n-2*(cir-1);
            int start = cir-1;
            int end = n-cir;
            //relative index(offset)
            for(int s = 0; s < widthOfCircle-1; s++){
                int temp = matrix[start][start+s];
                matrix[start][start+s] = matrix[end-s][start];
                matrix[end-s][start] = matrix[end][end-s];
                matrix[end][end-s] = matrix[start+s][end];
                matrix[start+s][end] = temp;
            }
        }
    }







    public void rotate1(int[][] matrix) {
        int n = matrix.length;
        for(int cir = 1; cir <= n/2; cir++){
            int widthOfCircle = n-2*(cir-1);
            int firstIndex = cir-1;
            int lastIndex = n-cir;
            //relative index(offset)
            for(int s = 0; s < widthOfCircle-1; s++){
                int direct = firstIndex+s;
                int inverse = lastIndex-s;
                int temp = matrix[firstIndex][direct];
                matrix[firstIndex][direct] = matrix[inverse][firstIndex];
                matrix[inverse][firstIndex] = matrix[lastIndex][inverse];
                matrix[lastIndex][inverse] = matrix[direct][lastIndex];
                matrix[direct][lastIndex] = temp;
            }
        }
    }








    int[] swap4(int[] fourNums){
        int temp = fourNums[0];
        fourNums[0] = fourNums[1];
        fourNums[1] = fourNums[2];
        fourNums[2] = fourNums[3];
        fourNums[3] = temp;
        return fourNums;
    }
    public void rotate2(int[][] matrix) {
        int n = matrix.length;
        for(int cir = 1; cir <= n/2; cir++){
            int widthOfCircle = n-2*(cir-1);
            int firstIndex = cir-1;
            int lastIndex = n-cir;
            //relative index(offset)
            for(int s = 0; s < widthOfCircle-1; s++){
                int direct = firstIndex+s;
                int inverse = lastIndex-s;
                int[] fourNums = new int[]{
                        matrix[firstIndex][direct],
                        matrix[inverse][firstIndex],
                        matrix[lastIndex][inverse],
                        matrix[direct][lastIndex]
                };
                swap4(fourNums);
                matrix[firstIndex][direct] = fourNums[0];
                matrix[inverse][firstIndex] = fourNums[1];
                matrix[lastIndex][inverse] = fourNums[2];
                matrix[direct][lastIndex] = fourNums[3];
            }
        }
    }



}
