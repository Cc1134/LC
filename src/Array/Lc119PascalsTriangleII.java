package Array;

import java.util.ArrayList;
import java.util.List;

public class Lc119PascalsTriangleII {
    public List<Integer> getRow(int rowIndexFromInput) {
        int numRows = rowIndexFromInput+1;
        List<Integer> lastRow = new ArrayList<>(numRows); //empty(capacity)
        List<Integer> row = new ArrayList<>(numRows); //empty(capacity)
        for(int i = 0; i < numRows; i++){ // 填满了预留的capacity
            lastRow.add(0); // lastRow被初始化进去了{numRows}个元素，每个元素的取值是0
            row.add(0); // row被初始化进去了{numRows}个元素，每个元素的取值是0
        }
        row.set(0, 1);

        for(int rowIndex = 1; rowIndex < numRows; rowIndex++){
            {//swap(lastRow, row) [?第一行的上一行?, 第一行] -> [第一行, 即将被赋值的第二行]
                List<Integer> temp = row;
                row = lastRow;
                lastRow = temp;
            }
            row.set(0, 1);
            for(int i = 1; i < rowIndex; i++){
                row.set(i, lastRow.get(i-1)+lastRow.get(i));
            }
            row.set(rowIndex, 1);
        }
        return row;
        /*
        row.add(1);
        ans.add(row);
        //loop: rowIndex=1...numRows
        //new size: 1+2+3+...+numRows == (1+numRows)*numRows/2 ~ O(numRows^2)
        //O(rowIndex) ~ constant * rowIndex
        //    1 * rowIndex
        //    2 * rowIndex
        //   10 * rowIndex
        // err: rowIndex * rowIndex
        // 用有限(常数, 固定次数)的new list(rowIndex+constant(+1,+2,...))
        for(int rowIndex = 1; rowIndex < numRows; rowIndex++){//rowIndex==numRows-1
            List<Integer> lastRow = ans.get(rowIndex-1);
            row = new ArrayList<>(rowIndex+1); // size==O(rowIndex)
            row.add(1);
            for(int i = 1; i < rowIndex; i++){
                row.add(lastRow.get(i-1)+lastRow.get(i));
            }
            row.add(1);
            ans.add(row);
        }
        return ans.get(rowIndexFromInput);
        */
    }




    //用数组代替ArrayLis， 更加节省空间
    public List<Integer> getRow1(int rowIndexFromInput) {
        int numRows = rowIndexFromInput+1;
        int[] lastRow = new int[numRows];
        int[] row = new int[numRows];
        row[0] = 1;
        for(int rowIndex = 1; rowIndex < numRows; rowIndex++){
            {//swap(lastRow, row) [?第一行的上一行?, 第一行] -> [第一行, 即将被赋值的第二行]
                int[] temp = row;
                row = lastRow;
                lastRow = temp;
            }
            row[0] = 1;
            for(int i = 1; i < rowIndex; i++){
                row[i] = lastRow[i-1]+lastRow[i];
            }
            row[rowIndex] = 1;
        }
        List<Integer> ans = new ArrayList<>(numRows);
        for(int num: row){
            ans.add(num);
        }
        return ans;
        /*
        row.add(1);
        ans.add(row);
        //loop: rowIndex=1...numRows
        //new size: 1+2+3+...+numRows == (1+numRows)*numRows/2 ~ O(numRows^2)
        //O(rowIndex) ~ constant * rowIndex
        //    1 * rowIndex
        //    2 * rowIndex
        //   10 * rowIndex
        // err: rowIndex * rowIndex
        // 用有限(常数, 固定次数)的new list(rowIndex+constant(+1,+2,...))
        for(int rowIndex = 1; rowIndex < numRows; rowIndex++){//rowIndex==numRows-1
            List<Integer> lastRow = ans.get(rowIndex-1);
            row = new ArrayList<>(rowIndex+1); // size==O(rowIndex)
            row.add(1);
            for(int i = 1; i < rowIndex; i++){
                row.add(lastRow.get(i-1)+lastRow.get(i));
            }
            row.add(1);
            ans.add(row);
        }
        return ans.get(rowIndexFromInput);
        */
    }


}
