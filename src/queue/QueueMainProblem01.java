package queue;

import java.util.*;

public class QueueMainProblem01 {


    private static String solution(String[] cards1, String[] cards2, String[] goal){

        //카드1 카드 2 골 각각 큐로 작성

        //카드원에서 하나빼오고 카드2에서 하나빼오고 골에서 하나 poll한다

        //만약 카드원에서 맞으면 poll  카드 투에서 맞으면 poll 골에있는것도 poll

        //결국 3개가 다 비어있어야한다.


        ArrayDeque<String> cards1Q = new ArrayDeque<>();
        ArrayDeque<String> cards2Q = new ArrayDeque<>();
        ArrayDeque<String> goalQ = new ArrayDeque<>();

        for(String s : cards1){
            cards1Q.addLast(s);
        }
        for(String s : cards2){
            cards2Q.addLast(s);
        }
        for(String s : goal){
            goalQ.addLast(s);
        }
        String card1Tmp = cards1Q.pollFirst();
        String card2Tmp = cards2Q.pollFirst();
        //중요 null.equals는 널포인트이셉션 뜨는데
        // abce.equals(null)은 널포인트이셉션 안뜬다.

        while(!goalQ.isEmpty()){
            String goalTmp = goalQ.pollFirst();
            if(goalTmp.equals(card1Tmp)){
                card1Tmp = cards1Q.pollFirst();
                goalTmp = goalQ.pollFirst();
            }
            else if(goalTmp.equals(card2Tmp) ){
                card2Tmp = cards2Q.pollFirst();
                goalTmp = goalQ.pollFirst();
            }
            else{
                return "No";
            }

        }
        return cards1Q.isEmpty()&&cards2Q.isEmpty()?"Yes":"No";

    }
}
