package baekjoon.dfs;

import java.util.Scanner;

public class BaekJoon_11403 {

    static int N;
    static int[][] grid;
    static int[][] result;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        grid = new int[N][N];
        result = new int[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < N; i++) {
            visited = new boolean[N];
            dfs(i, i);
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }

    static void dfs(int start, int now) {
        for (int next = 0; next < N; next++) {
            if (grid[now][next] == 1 && !visited[next]) {
                visited[next] = true;
                result[start][next] = 1;
                dfs(start, next);
            }
        }
    }
}
