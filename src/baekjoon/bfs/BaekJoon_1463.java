package baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_1463 {

    static int X;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        X = sc.nextInt();

        bfs();

        System.out.println(answer);

    }

    private static void bfs() {
        Queue<int[]> queue = new LinkedList<>();

        boolean[] visited = new boolean[X+1];

        visited[X] = true;

        queue.add(new int[]{X, 0});

        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
            int curX = poll[0];
            int count = poll[1];

            if (curX == 1) {
                answer = count;
                return;

            }

            if (curX % 3 == 0 && !visited[curX/3]) {
                visited[curX/3]= true;
                queue.add(new int[]{curX / 3, count + 1});
            }
            if (curX % 2 == 0 && !visited[curX/2]) {
                visited[curX/2] = true;
                queue.add(new int[]{curX / 2, count + 1});
            }
            if (curX > 1 && !visited[curX-1])  {
                visited[curX-1] =true;
                queue.add(new int[]{curX - 1, count + 1});
            }
        }
    }
}
