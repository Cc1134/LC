package String;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @ClassName: Lc71SimplifyPath
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/13/22 12:01 pm
 * @Version 1.0
 */
public class Lc71SimplifyPath {
    public String simplifyPath(String path) {
        String[] names = path.split(?);
        Deque<String> stack = new LinkedList<>();
        for(String name: names){
            if(?){ // 连续两个斜杠？
                continue;
            }
            if(?){ // current "."
                continue;
            }
            if(?){ // parent ".."
                if(?){
                    stack.removeLast(); // pop
                }
                continue;
            }
            stack.addLast(?);
        }
        if(stack.isEmpty()){
            return ?;
        }
        StringBuilder builder = ?;
        for(String name: stack){
            builder.append('?splitter');
            builder.append(?);
        }
        return ?;
    }

}

