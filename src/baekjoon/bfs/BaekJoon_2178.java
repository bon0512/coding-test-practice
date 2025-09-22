package baekjoon.bfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon_2178 {

    static int N, M;
    static int[][] grid;
    static boolean[][] visited;
    static int [][] distance;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        grid = new int[N][M];
        visited = new boolean[N][M];
        distance = new int[N][M];

        sc.nextLine();

        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < M; j++) {
                grid[i][j] = s.charAt(j) - '0';
            }
        }

        bfs(0, 0);




    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();

        int prev = 1;
        visited[y][x] = true;
        distance[y][x] =1;
        queue.add(new int[]{y, x});

        while (!queue.isEmpty()) {

            count++;
            int[] temp = queue.poll();
            if (temp[0] == N - 1 && temp[1] == M - 1) {
                System.out.println(distance[temp[0]][temp[1]]);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int nx = temp[1] + dx[i];
                int ny = temp[0] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                    if (!visited[ny][nx] && grid[ny][nx] == 1) {
                        visited[ny][nx] = true;
                        distance[ny][nx] = distance[temp[0]][temp[1]] +1;
                        queue.add(new int[]{ny, nx});

                    }
                }

            }
        }


    }
}
