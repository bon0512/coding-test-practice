package practice.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListMainProblem01 {
    public static void main(String[] args) {
        int[] answer = {1,3,2,4,2};

        int[] a = {1,2,3,4,5};
        int[] b = {2,1,2,3,2,4,2,5};
        int[] c = {3,3,1,1,2,2,4,4,5,5};

        int[] score = new int[3];

        for(int i =0; i<answer.length;i++){
            if(answer[i] == a[i%a.length]) score[0]++;
            if(answer[i] == b[i%b.length]) score[1]++;
            if(answer[i] == c[i%c.length]) score[2]++;
        }

        int max = Math.max(score[0],Math.max(score[1],score[2]));

        List<Integer> list = new ArrayList<>();
        int number=1;
        for(int i :score){
            if(i==max) list.add(number++);
        }
        int[] result = new int[list.size()];
        int index= 0;
        for (Integer i : list) {
            result[index++]=i;
        }

        System.out.println(Arrays.toString(result));

        /**
         * 각 학생의 패턴을 파악 후 정답과 차례대로 비교
         * 문제 수가 더 많으면 인덱스 연산에서 나머지를 이용해 계속 비교할 수 있다.
         */

    }
}
