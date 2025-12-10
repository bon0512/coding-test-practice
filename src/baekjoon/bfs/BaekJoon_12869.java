package baekjoon.bfs;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_12869 {

    static int N;
    static int[] arr;
    static int[][] dm;
    static boolean[][][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[3];

        dm = new int[6][3];
        dm[0] = new int[]{9, 3, 1};
        dm[1] = new int[]{3, 9, 1};
        dm[2] = new int[]{1, 3, 9};
        dm[3] = new int[]{1, 9, 3};
        dm[4] = new int[]{9, 1, 3};
        dm[5] = new int[]{3, 1, 9};

        visited = new boolean[61][61][61];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }


        System.out.println(bfs());

    }

    private static int bfs() {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{arr[0], arr[1], arr[2], 0});

        int result = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] mue = queue.poll();
            int a = mue[0];
            int b = mue[1];
            int c = mue[2];
            int count = mue[3];

            if (a == 0 && b == 0 && c == 0) {
                return count;
            }

            for (int i = 0; i < 6; i++) {
                int tempA = Math.max(0, a - dm[i][0]);
                int tempB = Math.max(0, b - dm[i][1]);
                int tempC = Math.max(0, c - dm[i][2]);

                if (!visited[tempA][tempB][tempC]) {
                    visited[tempA][tempB][tempC] = true;
                    queue.add(new int[]{tempA, tempB, tempC, count + 1});
                }

            }


        }

        return result;

    }

}
