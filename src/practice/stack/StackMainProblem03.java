package practice.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackMainProblem03 {


    public static void main(String[] args) {

        System.out.println(Arrays.toString(solution(new int[]{1,2,3,2,3})));
    }

    /*private static int[] solution(int [] practice.array){
        int[] answer = new int[practice.array.length];

        for(int i =0; i<practice.array.length; i++){
            if(i==practice.array.length-1){
                answer[i]=0;
                break;
            }

            for(int j= i+1;j<practice.array.length;j++){
                answer[i]++;
                if(practice.array[i]>practice.array[j]) {
                    break;
                }


            }
        }

        return answer;
    }*/

    /**
     * 스택 풀이방법
     */
    private static int[] solution(int [] array){
        int[] answer = new int[array.length];
        Stack<Integer> stack = new Stack<>();

        for(int i =0; i<array.length;i++){
            if(!stack.isEmpty() && array[i]<array[stack.peek()]){
                int index = stack.pop();

                answer[index] = i-index;
            }

            stack.push(i);
        }

        while(!stack.isEmpty()){
            int index =stack.pop();
            answer[index] = array.length - 1 - index;
        }


        return answer;
    }
}
