package stack;

import java.util.Stack;

public class StackBasicProblem02 {



    private static String solution(int decimal){
        int remain = 0;

        Stack<Integer> stack = new Stack<>();


        while(decimal>0){
            remain = decimal%2;
            decimal /= 2;
            stack.push(remain);
        }
        StringBuilder sc = new StringBuilder();

        while(!stack.isEmpty()){
            sc.append(stack.pop());
        }



        return sc.toString();
    }

}
