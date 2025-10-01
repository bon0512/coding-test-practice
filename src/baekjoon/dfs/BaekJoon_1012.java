package baekjoon.dfs;

import java.util.Scanner;

public class BaekJoon_1012 {

    static int T, N, M, K;
    static int[][] grid;
    static boolean[][] visited;

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();


        while (T-- > 0) {
            M = sc.nextInt();
            N = sc.nextInt();
            K = sc.nextInt();
            int count = 0;

            grid = new int[N][M];
            visited = new boolean[N][M];

            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                grid[y][x] = 1;
            }


            for (int y = 0; y < N; y++) {
                for (int x = 0; x < M; x++) {
                    if (grid[y][x] == 1 && !visited[y][x]) {
                        count++;
                        dfs(x, y);
                    }
                }
            }
            System.out.println(count);

        }

    }

    private static void dfs(int x, int y) {

        visited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (grid[ny][nx] == 1 && !visited[ny][nx]) {
                    dfs(nx, ny);
                }
            }

        }

    }
}
