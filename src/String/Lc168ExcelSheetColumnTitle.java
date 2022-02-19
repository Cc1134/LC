package String;

/**
 * @ClassName: Lc168ExcelSheetColumnTitle
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/14/22 10:30 pm
 * @Version 1.0
 */
public class Lc168ExcelSheetColumnTitle {
    public String convertToTitle(int columnNumber) {
        StringBuilder builder = new StringBuilder(7);
        while(? != 0){
            ?--;
            builder.append((char)(?%26+'?'));
            ? /= 26;
        }
        return builder.reverse().toString();
    }


}

//    public String convertToTitle(int columnNumber) {
//        char[] buf = new char[7];
//        int bit = 0;
//        while(columnNumber != 0){
//            bit++;
//            columnNumber--;
//            buf[buf.length-bit] = (char)(columnNumber%26+'A');
//            columnNumber /= 26;
//        }
//        return String.copyValueOf(buf, buf.length-bit, bit);
//    }