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
        String[] names = path.split("/");
        Deque<String> stack = new LinkedList<>();
        for(String name: names){
            if(name.equals("/")){ // 连续两个斜杠？
                continue;
            }
            if(name.equals(".")){ // current "."
                continue;
            }
            if(name.equals("..")){ // parent ".."
                if(!stack.isEmpty()){
                    stack.removeLast(); // pop
                }
                continue;
            }
            if(name.equals("")){
                continue;
            }
            stack.addLast(name);
        }
        if(stack.isEmpty()){
            return "/";
        }
        StringBuilder builder = new StringBuilder();
        for(String name: stack){
            builder.append('/');
            builder.append(name);
        }
        return builder.toString();
    }

}

