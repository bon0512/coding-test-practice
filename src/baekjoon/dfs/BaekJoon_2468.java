package baekjoon.dfs;

import java.util.Map;
import java.util.Scanner;

public class BaekJoon_2468 {
    static int N;
    static int[][] grid;
    static boolean[] mem;
    static boolean[][] visited;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int maxCount = -1;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        grid = new int[N][N];
        mem = new boolean[101];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!mem[grid[i][j]]) {
                    dfs_limit(grid[i][j]);
                    mem[grid[i][j]] = true;
                }
            }
        }
        System.out.println(maxCount);
    }

    static private void dfs_limit(int limit) {
        count = 0;
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && grid[i][j] > limit) {
                    count++;
                    dfs(j, i, limit);
                }
            }
        }
        maxCount = Math.max(count, maxCount);
    }

    static private void dfs(int x, int y, int limit) {
        visited[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[ny][nx] && grid[ny][nx] > limit) {
                    dfs(nx, ny, limit);
                }
            }
        }
    }
}