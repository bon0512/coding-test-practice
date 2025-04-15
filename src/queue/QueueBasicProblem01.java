package queue;

import java.util.ArrayDeque;
import java.util.Queue;

public class QueueBasicProblem01 {


    public static void main(String[] args) {
        System.out.println(solution(5,2));
    }

    private static int solution(int n, int k){
        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        for(int i =1; i <=n;i++){
            arrayDeque.addLast(i);
        }

        while(arrayDeque.size()>1){
            for(int i =0; i <k-1;i++){
                arrayDeque.add(arrayDeque.pollFirst());
            }

            arrayDeque.pollFirst();
            System.out.println(arrayDeque);
        }

        return arrayDeque.pollFirst();



    }
}
