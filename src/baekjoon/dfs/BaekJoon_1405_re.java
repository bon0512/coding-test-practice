package baekjoon.dfs;

import java.util.Scanner;

public class BaekJoon_1405_re {
    static int N;
    static double answer;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static double[] dir;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        visited = new boolean[(N * 2)+1][(N * 2)+1];


        dir = new double[4];

        for (int i = 0; i < 4; i++) {
            dir[i] = (double) sc.nextInt() / 100;
        }

        int cur = N;
        visited[cur][cur] = true;
        dfs(0, cur, cur, 1);

        System.out.println(answer);
    }

    private static void dfs(int count, int curY, int curX, double temp) {
        if (count == N) {
            answer += temp;
            return;
        }

        for (int i = 0; i < 4; i++) {
            int ny = curY + dy[i];
            int nx = curX + dx[i];

            if (!visited[ny][nx] && dir[i] > 0) {
                visited[ny][nx] = true;
                dfs(count + 1, ny, nx, temp * dir[i]);
                visited[ny][nx] = false;
            }
        }


    }
}
