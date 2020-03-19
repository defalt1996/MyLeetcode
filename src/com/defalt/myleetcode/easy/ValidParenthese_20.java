package com.defalt.myleetcode.easy;
/*
 *  author: Derrick
 *  Time: 2020/3/18 23:30
 */

import java.util.Stack;

public class ValidParenthese_20 {

    public boolean isValid(String s) {
        // use stack

        Stack<String> stack = new Stack();
        String[] sArray = s.split("");
        for (String item : sArray) {
            if (item.equals("(") || item.equals("[") || item.equals("{")) {
                stack.push(item);
            }

            if (item.equals(")")) {

                String top = stack.peek();
                if (top.equals("(")) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (item.equals("]")) {

                String top = stack.peek();
                if (top.equals("[")) {
                    stack.pop();
                } else {
                    return false;
                }
            } else if (item.equals("}")) {

                String top = stack.peek();
                if (top.equals("{")) {
                    stack.pop();
                } else {
                    return false;
                }
            }
        }
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }



}
