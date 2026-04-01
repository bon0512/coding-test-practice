package baekjoon.dfs;

import java.util.*;

/**
 * ==========================
 * 링크 : https://www.acmicpc.net/problem/2468
 * 이름 : 안전영역
 * ==========================
 */
public class BaekJoon_2468_re {

    static int N;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int[][] arr;
    static boolean[][] visited;
    static int count;
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        arr = new int[N][N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
                max = Math.max(max, arr[i][j]);
            }
        }

        for (int h = 0; h <= max; h++) {
            count = 0;
            visited = new boolean[N][N];

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (!visited[i][j] && arr[i][j] > h) {
                        dfs(i, j, h);
                        count++;
                    }
                }
            }

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }

    static void dfs(int x, int y, int h) {
        visited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (!visited[nx][ny] && arr[nx][ny] > h) {
                    dfs(nx, ny, h);
                }
            }
        }
    }
}
