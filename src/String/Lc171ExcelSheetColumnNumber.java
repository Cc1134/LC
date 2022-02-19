package String;

/**
 * @ClassName: Lc171ExcelSheetColumnNumber
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/14/22 10:32 pm
 * @Version 1.0
 */
public class Lc171ExcelSheetColumnNumber {
    public int titleToNumber(String title) {
        //BBA
        //(BB)*26+A
        //(B*26+B)*26+A
        int ans = 0;
        for(char c: title.toCharArray()){
            ans = ans*26+(c-'A'+1);
        }
        return ans;
        //d = a*b+c
        //a = d/b
        //c = d%b
    }
}

