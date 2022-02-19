package Lc22;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: Lc22GenerateParentheses
 * @Description: todo
 * @Author Cassie Chen
 * @Date 1/24/22 8:57 am
 * @Version 1.0
 */
public class Lc22GenerateParentheses {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        decision(0,0,"",ans,n);
        return ans;

    }

    public void decision(int numOfLeft, int numOfRight, String current, List<String> ans, int n){
        if(numOfLeft < n){
            decision(numOfLeft + 1, numOfRight, current + "(", ans, n);
        }

        if(numOfRight < numOfLeft){
            decision(numOfLeft, numOfRight + 1, current + ")", ans, n);
        }

        if(numOfLeft == n && numOfRight == n){
            ans.add(current);
        }
    }
}

