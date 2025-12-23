package baekjoon.queue;

import java.util.*;

public class BaekJoon_2075 {

    public static void main(String[] args) {

        /*PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b-a);
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int temp = sc.nextInt();
                pq.add(temp);
            }
        }


        for (int i = 0; i <N-1; i++) {
            pq.poll();
        }

        System.out.println(pq.poll());*/

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        Scanner sc = new Scanner(System.in);
        int N;
        N = sc.nextInt();

        for (int i = 0; i < N*N; i++) {
            int temp = sc.nextInt();
            pq.add(temp);
            if(pq.size()>N){
                pq.poll();
            }
        }


        System.out.println(pq.poll());

    }

}
