package practice.queue;

import java.util.*;

public class QueueBasicProblem02 {



    private static int[] solution(int[] progresses, int[] speeds){

        List<Integer> answer=  new ArrayList<>();
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();



        for(int i =0;i<progresses.length;i++){
            int remainTime = 100 - progresses[i];
            if(remainTime%speeds[i]==0){
               arrayDeque.addLast(remainTime/speeds[i]);
            }
            else{
               arrayDeque.addLast((remainTime/speeds[i]) + 1);
            }
        }
        int count=1;
        int tmpTime = arrayDeque.pollFirst();
        while(!arrayDeque.isEmpty()){

            if(arrayDeque.peek()<=tmpTime){
                count++;
                tmpTime=arrayDeque.pollFirst();
            }
            else{
                answer.add(count);
                tmpTime = arrayDeque.pollFirst();
                count=1;

            }
        }

        answer.add(count);



        int[] answer1 = new int[answer.size()];
        for (int i = 0; i < answer1.length; i++) {
            answer1[i] = answer.get(i);
        }
        return answer1;
    }
}
