package baekjoon.greedy;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BaekJoon_15903 {
    static int N, M;
    static PriorityQueue<Long> pq;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        pq = new PriorityQueue<>();


        for (int i = 0; i < N; i++) {
            pq.add(sc.nextLong());
        }

        while (M-- > 0){
            long x = pq.poll();
            long y = pq.poll();

            pq.add(x+y);
            pq.add(x+y);
        }

        long answer = 0;
        for(long x : pq){
            answer+=x;
        }

        System.out.println(answer);
    }
}
