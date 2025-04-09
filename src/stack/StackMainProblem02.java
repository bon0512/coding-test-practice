package stack;

import java.util.Stack;

public class StackMainProblem02 {




    private static int solution(String s){

        Stack<Character> stack = new Stack<>();

        for(int i =0; i<s.length();i++){
            char tmp = s.charAt(i);
            if(stack.isEmpty()){
                stack.push(tmp);
            }
            else{
                if(stack.peek()==tmp){
                    stack.pop();
                }
                else{
                    stack.push(tmp);
                }
            }
        }

        if(stack.isEmpty()) return 1;
        else return 0;
    }
}
