package com.homework;


import java.util.Stack;

/**
 * 20 有效的括号
 * https://leetcode-cn.com/problems/valid-parentheses/
 */
public class ValidParentheses {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char aChar = chars[i];
            if(aChar=='('){
                stack.push(')');
            }else if(aChar=='{'){
                stack.push('}');
            }else if(aChar=='['){
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop()!=aChar){
                return false;
            }
        }

        return stack.isEmpty();
    }

}
