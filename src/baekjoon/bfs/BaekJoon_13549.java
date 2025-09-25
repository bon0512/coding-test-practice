package baekjoon.bfs;

import java.util.*;

/**
 * 13549 숨바꼭질... bfs 너비 우선 탐색
 */
public class BaekJoon_13549 {

    static int[] visited;
    static int N, K;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        visited = new int[100_001];
        Arrays.fill(visited,Integer.MAX_VALUE);

        bfs(N);

        System.out.println(answer);
    }

    private static void bfs(int n) {
        Deque<int[]> deque = new ArrayDeque<>();
        deque.add(new int[]{n, 0});
        visited[n] = 0;

        while (!deque.isEmpty()) {
            int[] poll = deque.poll();
            int cur = poll[0];
            int time = poll[1];

            if (cur == K) {
                answer = Math.min(answer,time);

            }

            if (cur * 2 >= 0 && cur * 2 <= 100_000) {
                if (visited[cur * 2] > time) {
                    visited[cur * 2] = time;
                    deque.addFirst(new int[]{cur * 2, time});
                }
            }

            if (cur + 1 >= 0 && cur + 1 <= 100_000) {
                if (visited[cur + 1] > time) {
                    visited[cur + 1] = time+1;
                    deque.addLast(new int[]{cur + 1, time+1});
                }
            }


            if (cur - 1 >= 0 && cur - 1 <= 100_000) {
                if (visited[cur - 1] > time) {
                    visited[cur - 1] = time-1;
                    deque.addLast(new int[]{cur - 1, time+1});
                }
            }


        }
    }
}


