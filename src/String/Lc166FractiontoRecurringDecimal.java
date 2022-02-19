package String;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: Lc166FractiontoRecurringDecimal
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/14/22 10:21 pm
 * @Version 1.0
 */
public class Lc166FractiontoRecurringDecimal {

    public String fractionToDecimal(long num, long denom) {
        if (num == 0) {
            return "0";
        }
        StringBuilder builder = new StringBuilder();
        if (num * denom < 0) {
            builder.append('-');
            num = num < 0 ? num : -num;
            denom = denom < 0 ? denom : -denom;
        }
        long Int = num / denom;
        long remain = num % denom;
        builder.append(Int);
        if (remain == 0) {
            return builder.toString();
        }
        builder.append('.');
        Map<Long, Integer> map = new HashMap<>();
        while (remain != 0) {
            if (map.containsKey(remain)) {
                break;
            }
            long oldRemainAsKey = remain;
            remain *= 10;
            Int = remain / denom;
            remain = remain % denom;
            builder.append(Int);
            map.put(oldRemainAsKey, builder.length() - 1);
        }
        if (remain == 0) {
            return builder.toString();
        }
        return builder.insert(map.get(remain).intValue(), '(').append(')').toString();
    }

}

