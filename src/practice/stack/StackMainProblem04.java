package practice.stack;
import java.util.*;
public class StackMainProblem04 {


    private static int solution(int[][] board, int[] moves){

        Stack<Integer>[] stackLane = new Stack[board.length];

        for(int i =0;i<stackLane.length;i++){
            stackLane[i] = new Stack<>();
        }

        for(int i = board.length-1; i>=0;i--){
            for(int j = 0; j<board[i].length; j++){
                if(board[i][j]>0){
                    stackLane[j].push(board[i][j]);
                }
            }
        }


        Stack<Integer> bucket = new Stack<>();
        int answer = 0;

        for(int i =0; i<moves.length;i++){

            if(stackLane[moves[i]-1].isEmpty()) continue;

            int doll = stackLane[moves[i] - 1].pop();

            if(bucket.isEmpty()){
                bucket.push(doll);
            }
            else{
                if(bucket.peek()==doll){
                    bucket.pop();
                    answer+=2;
                }
                else{
                    bucket.push(doll);
                }

            }


        }





        return answer;
    }

}
