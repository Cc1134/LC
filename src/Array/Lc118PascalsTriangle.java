package Array;

import java.util.ArrayList;
import java.util.List;

public class Lc118PascalsTriangle {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> row = new ArrayList<>(1);
        row.add(1);
        ans.add(row);
        for(int rowIndex = 1; rowIndex < numRows; rowIndex++){
            List<Integer> lastRow = ans.get(rowIndex-1);
            row = new ArrayList<>(rowIndex+1);
            row.add(1);
            for(int i = 1; i < rowIndex; i++){
                row.add(lastRow.get(i-1)+lastRow.get(i));
            }
            row.add(1);
            ans.add(row);
        }
        return ans;
    }

}
