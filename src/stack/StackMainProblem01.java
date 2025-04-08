package stack;

import java.util.Stack;

public class StackMainProblem01 {


    private static int solution(String s){

        int score = 0;


        for(int i =0; i<s.length();i++){

            String tmp = s.substring(i) + s.substring(0,i);

            if(correctString(tmp)){
                score++;
            }
        }
        return score;
    }
    private static boolean correctString(String tmp){
        Stack<Character> stack = new Stack<>();

        for(int i =0; i<tmp.length();i++){
            char tmpChar = tmp.charAt(i);

            if(tmpChar=='{'||tmpChar=='('||tmpChar=='['){
                stack.push(tmpChar);

            }else{
                if(stack.isEmpty()){
                    return false;
                }
                Character peek = stack.peek();
                if(tmpChar=='}' && peek=='{') stack.pop();
                if(tmpChar==']' && peek=='[') stack.pop();
                if(tmpChar==')' && peek=='(') stack.pop();
            }

        }
        return stack.isEmpty();
    }


}
