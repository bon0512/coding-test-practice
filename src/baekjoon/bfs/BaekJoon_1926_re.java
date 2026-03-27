package baekjoon.bfs;

import java.util.*;

public class BaekJoon_1926_re {

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int x, y;
    static int count = 0, size = 0, maxSize = 0;
    static int[][] map;
    static boolean[][] visited;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        y = sc.nextInt();
        x = sc.nextInt();

        map = new int[y][x];
        visited = new boolean[y][x];

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < y; i++) {
            for (int j = 0; j < x; j++) {
                if (map[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    count++;
                    bfs(i, j);
                    maxSize = Math.max(maxSize, size);
                }
            }

        }
        System.out.println(count);
        System.out.println(maxSize);
    }

    static void bfs(int i, int j) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        size = 1;

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            int tempY = temp[0];
            int tempX = temp[1];

            for (int k = 0; k < 4; k++) {
                int nx = tempX + dx[k];
                int ny = tempY + dy[k];
                if (ny >= 0 && nx >= 0 && nx < x && ny < y) {
                    if (map[ny][nx] == 1 && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        queue.add(new int[]{ny,nx});
                        size++;

                    }

                }
            }

        }
    }
}
