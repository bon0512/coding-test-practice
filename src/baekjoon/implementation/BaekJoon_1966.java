package baekjoon.implementation;

import java.util.*;

/**
 * 프린터 큐
 */

public class BaekJoon_1966 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {

            int N = sc.nextInt();
            int M = sc.nextInt();

            Integer[] importances = new Integer[N];
            Queue<int[]> queue = new LinkedList<>();// [0] 인덱스,[1] 중요도
            int max = -1; //최대 중요도 체크변수

            for (int j = 0; j < N; j++) {
                int importance = sc.nextInt();
                importances[j] = importance;
                queue.add(new int[]{j, importance});
            }

            Arrays.sort(importances,(t1,t2) -> t2 - t1);

            int k = 0;
            int count = 0;

            while (true) {

                int[] peek = queue.peek();

                if (peek[1] < importances[k]) {

                    int[] poll = queue.poll();
                    queue.add(poll);

                } else {

                    int[] poll = queue.poll();
                    k++;
                    count++;

                    if (poll[0] == M) {
                        break;
                    }
                }
            }

            System.out.println(count);

        }
    }
}
