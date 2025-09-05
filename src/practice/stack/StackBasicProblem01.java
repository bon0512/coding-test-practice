package practice.stack;

import java.util.*;

public class StackBasicProblem01 {





    private boolean solution(String s){
        Stack<Character> stack = new Stack<>();

        for(int i =0; i < s.length();i++){

            char ch = s.charAt(i);

            if(ch=='('){
                stack.push(ch);
            }
            else{
                if(stack.isEmpty()){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }



        return stack.isEmpty(); //((( 이 경우도 생각해야함
    }
}
