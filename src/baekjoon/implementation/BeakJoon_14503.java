package baekjoon.implementation;

import java.util.Scanner;

public class BeakJoon_14503 {

    static int N, M;
    static int x, y, d;
    static int[][] grid;
    static boolean[][] cleaned;
    static int count;

    // 방향: 북, 동, 남, 서
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        y = sc.nextInt(); // 시작 y
        x = sc.nextInt(); // 시작 x
        d = sc.nextInt(); // 시작 방향

        grid = new int[N][M];
        cleaned = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        count = 0;

        while (true) {
            // 1. 현재 칸 청소
            if (!cleaned[y][x]) {
                cleaned[y][x] = true;
                count++;
            }

            // 2. 주변에 청소할 칸이 있는지 확인
            if (check(x, y)) {

                d = (d + 3) % 4;
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (grid[ny][nx] == 0 && !cleaned[ny][nx]) {
                        x = nx;
                        y = ny;

                    }
                }

            } else {

                int backDir = (d + 2) % 4;
                int ny = y + dy[backDir];
                int nx = x + dx[backDir];

                if (nx >= 0 && nx < M && ny >= 0 && ny < N && grid[ny][nx] == 0) {
                    x = nx;
                    y = ny;
                } else {
                    break;
                }
            }
        }

        System.out.println(count);
    }

    public static boolean check(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (!cleaned[ny][nx] && grid[ny][nx] == 0) {
                    return true;
                }
            }
        }
        return false;
    }
}
