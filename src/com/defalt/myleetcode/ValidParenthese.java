package com.defalt.myleetcode;
/*
 *  author: Derrick
 *  Time: 2020/3/18 23:30
 */

import java.util.Stack;

class ValidParenthese {

    public boolean isValid(String s) {
        // (40 )41  [91 ]93  {123 }125

        Stack<String> stack = new Stack();
        String[] sArray = s.split("");
        for(String item : sArray){
            if(item.equals("(") || item.equals("[") || item.equals("{")){
                stack.push(item);
            }

            if(item.equals(")")){

                String top = stack.peek();
                if( top.equals("(")){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(item.equals("]")){

                String top = stack.peek();
                if( top.equals("[")){
                    stack.pop();
                }else{
                    return false;
                }
            }else if(item.equals("}")){

                String top = stack.peek();
                if( top.equals("{")){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        if (stack.empty()){
            return true;
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        ValidParenthese solution = new ValidParenthese();
        boolean result = solution.isValid("()");
        System.out.println(result);
    }

}
