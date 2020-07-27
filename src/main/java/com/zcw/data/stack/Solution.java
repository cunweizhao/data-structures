package com.zcw.data.stack;
import java.util.Stack;
/**
 * @ClassName : Solution
 * @Description :
 * @Author : Zhaocunwei
 * @Date: 2020-07-27 11:59
 */
public class Solution {

    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c == '(' || c== '[' || c== '{'){
                stack.push(c);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char topChar = stack.pop();
                if(c ==')' && topChar !='('){
                    return false;
                }
                if( c == ']' && topChar !='['){
                    return false;
                }
                if( c == '}' && topChar !='{'){
                    return  false;
                }
            }
        }
        return  stack.isEmpty();
    }
}
