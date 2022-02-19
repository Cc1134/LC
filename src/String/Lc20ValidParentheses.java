package String;

import java.util.Stack;

/**
 * @ClassName: Lc20ValidParentheses
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/8/22 5:05 pm
 * @Version 1.0
 */
public class Lc20ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '('){
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == '['){
                stack.push(s.charAt(i));
            }
            if (s.charAt(i) == '{'){
                stack.push(s.charAt(i));
            }
            if(s.charAt(i) == ')') {
                if ((!stack.isEmpty()) && stack.peek() == '(') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if(s.charAt(i) == ']') {
                if ((!stack.isEmpty()) && stack.peek() == '[') {
                    stack.pop();
                } else {
                    return false;
                }
            }
            if(s.charAt(i) == '}') {
                if ((!stack.isEmpty()) && stack.peek() == '{') {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}

