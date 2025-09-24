package baekjoon.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * 12851 숨바꼭질... bfs 너비 우선 탐색 boolean으로 하면안된다.
 * 한번 방문처리된 지역은 다시 방문이 안되기 때문에 int로 바꾸고 지역에 도착한 시간을 관리해야한다.
 * 이동해서 도착한 지역에 시간을 확인한뒤 내 시간보다 짧거나 같으면 넣고 아니면 큐에 넣지 않는다.
 */
public class BaekJoon_12851 {

    static int[] visited;
    static int N, K;
    static int answer = 0;
    static int count = 0;
    static Queue<int[]> queue;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        K = sc.nextInt();

        visited = new int[100_001];

        for (int i = 0; i < visited.length; i++) {
            visited[i] = -1;
        }

        bfs(N);

        System.out.println(answer);
        System.out.println(count);

        for (int[] ints : queue) {
            System.out.println(Arrays.toString(ints));
        }
    }

    private static void bfs(int n) {
        queue = new LinkedList<>();
        queue.add(new int[]{n, 0}); //현재위치, 도착 시간
        visited[n] = 0;

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int cur = poll[0];
            int time = poll[1];

            if (cur == K) {
                if(answer==0){
                    answer = time;
                    count =1;
                }else if(time == answer){
                    count++;
                }
            }

            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    if (cur - 1 >= 0 && cur - 1 <= 100_000) {
                        if (visited[cur - 1] == -1) {
                            visited[cur - 1] = time + 1;
                            queue.add(new int[]{cur - 1, time + 1});
                        } else if (visited[cur - 1] >= time + 1) {
                            queue.add(new int[]{cur - 1, time + 1});
                        }
                    }
                } else if (i == 1) {
                    if (cur + 1 >= 0 && cur + 1 <= 100_000) {
                        if (visited[cur + 1] == -1) {
                            visited[cur + 1] = time + 1;
                            queue.add(new int[]{cur + 1, time + 1});
                        } else if (visited[cur + 1] >= time + 1) {
                            queue.add(new int[]{cur + 1, time + 1});
                        }
                    }
                } else {
                    if (cur * 2 >= 0 && cur * 2 <= 100_000) {
                        if (visited[cur * 2] == -1) {
                            visited[cur * 2] = time + 1;
                            queue.add(new int[]{cur * 2, time + 1});
                        } else if (visited[cur * 2] >= time + 1) {
                            queue.add(new int[]{cur * 2, time + 1});
                        }
                    }
                }
            }
        }


    }
}
