package baekjoon.bfs;

import java.util.*;

/**
 * 13549 숨바꼭질... bfs 너비 우선 탐색
 */
public class BaekJoon_13549 {

    static int[] visited;
    static int N, K;
    static int answer = Integer.MAX_VALUE;
    static List<Integer> answerList ;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        visited = new int[100_001];
        Arrays.fill(visited,Integer.MAX_VALUE);

        bfs(N);


        System.out.println(answer);
        for (int i = 2; i < answerList.size(); i++) {
            System.out.print(answerList.get(i)+" ");

        }
    }

    private static void bfs(int n) {
        Deque<List<Integer>> deque = new ArrayDeque<>();
        List<Integer > list = new ArrayList<>();
        list.add(n);
        list.add(0);
        deque.add(list);
        visited[n] = 0;

        while (!deque.isEmpty()) {
            List<Integer> poll = deque.poll();
            int cur = poll.get(0);
            int time = poll.get(1);

            if (cur == K) {
                answer = time;
                answerList = new ArrayList<>(poll);
                break;

            }

            if (cur * 2 >= 0 && cur * 2 <= 100_000) {
                if (visited[cur * 2] > time) {
                    visited[cur * 2] = time;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(cur);
                    temp.add(0);
                    for (int i = 2; i <poll.size() ; i++) {
                        temp.add(poll.get(i));
                    }
                    deque.addFirst(temp);
                }
            }

            if (cur + 1 >= 0 && cur + 1 <= 100_000) {
                if (visited[cur + 1] > time) {
                    visited[cur + 1] = time+1;

                    List<Integer> temp = new ArrayList<>();
                    temp.add(cur);
                    temp.add(time+1);
                    for (int i = 2; i <poll.size() ; i++) {
                        temp.add(poll.get(i));
                    }


                    deque.addLast(temp);
                }
            }


            if (cur - 1 >= 0 && cur - 1 <= 100_000) {
                if (visited[cur - 1] > time) {
                    visited[cur - 1] = time-1;
                    List<Integer> temp = new ArrayList<>();
                    temp.add(cur);
                    temp.add(time-1);
                    for (int i = 2; i <poll.size() ; i++) {
                        temp.add(poll.get(i));
                    }
                    deque.addLast(temp);
                }
            }


        }
    }
}


