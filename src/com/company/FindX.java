package com.company;

/**
 * @ClassName: FindX
 * @Description: todo
 * @Author Cassie Chen
 * @Date 2/5/22 8:25 pm
 * @Version 1.0
 */
public class FindX {

    boolean validate(String eqn) {
        int op = -1;
        int eq = -1;
        for (int i = 0; i < eqn.length(); i++) {
            char c = eqn.charAt(i);
            if (c == '=') {
                eq = i;
            } else if (!('0' <= c && c <= '9')) {
                op = i;
            }
        }
        String[] nums = new String[]{eqn.substring(0, op), eqn.substring(op + 1, eq), eqn.substring(eq + 1, eqn.length())};
        switch (eqn.charAt(op)) {
            case '+':
                return Integer.valueOf(nums[0]) + Integer.valueOf(nums[1]) == Integer.valueOf(nums[2]);
            case '-':
                return Integer.valueOf(nums[0]) - Integer.valueOf(nums[1]) == Integer.valueOf(nums[2]);
            case '*':
                return Integer.valueOf(nums[0]) * Integer.valueOf(nums[1]) == Integer.valueOf(nums[2]);
            case '/':
                return Integer.valueOf(nums[0]) / Integer.valueOf(nums[1]) == Integer.valueOf(nums[2]);
        }
        return false;
    }

    int getX(String s) {
        for (char i = '0'; i <= '9'; i++) {
            if (validate(s.replace('X', i))) {
                return i;
            }
        }
        return -1;
    }
}

