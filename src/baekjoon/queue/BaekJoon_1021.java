package baekjoon.queue;


import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 회전하는 큐
 * <a href="https://www.acmicpc.net/problem/1021">...</a>
 */
public class BaekJoon_1021 {

    static int N,M;
    static int count =0;

    public static void main(String[] args) {
        Deque<Integer> deque = new ArrayDeque<>();

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        for (int i = 1; i <=N; i++) {
            deque.add(i);
        }


        for (int i = 0; i < M; i++) {
            int number = sc.nextInt();

            int idx = 0;
            for (Integer x : deque) {
                if(x==number) break;
                idx++;
            }

            if(idx<=deque.size()/2){
                for(int j = 0; j<idx; j++){
                    Integer temp = deque.pollFirst();
                    deque.addLast(temp);
                    count++;
                }
            }else{
                int rotate = deque.size() - idx;
                for (int j = 0 ; j <rotate;j++){
                    Integer temp = deque.pollLast();
                    deque.addFirst(temp);
                    count++;
                }
            }

            deque.pollFirst();

        }

        System.out.println(count);
    }
}
