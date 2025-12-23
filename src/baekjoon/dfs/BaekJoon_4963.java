package baekjoon.dfs;

import java.util.Scanner;

public class BaekJoon_4963 {

    static int w, h;
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1}; // 오른쪽부터 대각선 시작
    static int[] dy = {0, -1, -1, -1, 0, 1, 1, 1}; // 오른쪽부터 대각선 시작
    static int[][] grid;
    static boolean[][] visited;
    static int count;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {
            w = sc.nextInt();
            h = sc.nextInt();

            if (w == 0 && h == 0) break;

            grid = new int[h][w];
            visited = new boolean[h][w];
            count = 0;

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }

            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    if (!visited[i][j] && grid[i][j] == 1) {
                        visited[i][j] = true;
                        dfs(i, j);
                        count++;
                    }
                }
            }
            System.out.println(count);
        }

    }

    private static void dfs(int y, int x) {

        for (int i = 0; i < 8; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];

            if (ny >= 0 && nx >= 0 && ny < h && nx < w) {
                if (!visited[ny][nx] && grid[ny][nx] == 1) {
                    visited[ny][nx] = true;
                    dfs(ny, nx);
                }
            }
        }


    }
}
