package String;

/**
 * @ClassName: Lc38CountandSay
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/8/22 7:13 pm
 * @Version 1.0
 */
public class Lc38CountandSay {
    String count(String input){
        char lastSeen = input.charAt(0);
        int lastCumulate = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(char c : input.toCharArray()){
            if(c != lastSeen){
                stringBuilder.append(lastCumulate);
                stringBuilder.append(lastSeen);
                lastSeen = c;
                lastCumulate = 0;
            }
            lastCumulate++;
        }
        stringBuilder.append(lastCumulate);
        stringBuilder.append(lastSeen);
        return stringBuilder.toString();
    }
    public String countAndSay(int n) {
        String str = "1";
        for(int i = 1; i < n; i++){
            str = count(str);
        }
        return str;
    }
}


