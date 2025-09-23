package baekjoon.implementation;

import java.util.Scanner;

public class BaekJoon_14500 {

    static int N, M;
    static int[][] grid;
    static int max = -1;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        numberOne();
        numberTwo();
        numberThree();
        numberFour();
        numberFive();
        System.out.println(max);


    }


    private static void numberOne() {

        int n1 = 0, n2 = 0, n3 = 0, n4 = 0;
        int temp;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                n1 = j;
                n2 = j + 1;
                n3 = j + 2;
                n4 = j + 3;
                if (n4 >= 0 && n4 < M) {
                    temp = grid[i][n1] + grid[i][n2] + grid[i][n3] + grid[i][n4];
                    max = Math.max(temp, max);

                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                n1 = i;
                n2 = i + 1;
                n3 = i + 2;
                n4 = i + 3;
                if (n4 >= 0 && n4 < N) {
                    temp = grid[n1][j] + grid[n2][j] + grid[n3][j] + grid[n4][j];
                    max = Math.max(temp, max);
                }
            }
        }


    }

    private static void numberTwo() {

        int x1, y1, x2, y2, x3, y3, x4, y4;
        int temp = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                x1 = j;
                y1 = i;

                x2 = j + 1;
                y2 = i;

                x3 = j;
                y3 = i + 1;

                x4 = j + 1;
                y4 = i + 1;

                if (x4 < M && y4 < N) {
                    temp = grid[y1][x1] + grid[y2][x2] + grid[y3][x3] + grid[y4][x4];
                    max = Math.max(max, temp);
                }

            }

        }


    }

    private static void numberThree() {
        int temp;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 2 < N && j + 1 < M) {
                    temp = grid[i][j] + grid[i + 1][j] + grid[i + 2][j] + grid[i + 2][j + 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < N && j - 1 >= 0) {
                    temp = grid[i][j] + grid[i + 1][j] + grid[i + 2][j] + grid[i + 2][j - 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < N && j + 1 < M) {
                    temp = grid[i][j] + grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < N && j - 1 >= 0) {
                    temp = grid[i][j] + grid[i][j - 1] + grid[i + 1][j - 1] + grid[i + 2][j - 1];
                    max = Math.max(max, temp);
                }
                if (i + 1 < N && j + 2 < M) {
                    temp = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j];
                    max = Math.max(max, temp);
                }
                if (i + 1 < N && j + 2 < M) {
                    temp = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 2];
                    max = Math.max(max, temp);
                }
                if (i + 1 < N && j + 2 < M) {
                    temp = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] + grid[i][j];
                    max = Math.max(max, temp);
                }
                if (i + 1 < N && j + 2 < M) {
                    temp = grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 1][j + 2] + grid[i][j + 2];
                    max = Math.max(max, temp);
                }
            }
        }
    }

    private static void numberFour() {
        int temp;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 1 < N && j + 2 < M) {
                    temp = grid[i][j] + grid[i][j + 1] + grid[i + 1][j + 1] + grid[i + 1][j + 2];
                    max = Math.max(max, temp);
                }
                if (i + 1 < N && j - 1 >= 0 && j + 1 < M) {
                    temp = grid[i][j] + grid[i][j + 1] + grid[i + 1][j] + grid[i + 1][j - 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < N && j + 1 < M) {
                    temp = grid[i][j] + grid[i + 1][j] + grid[i + 1][j + 1] + grid[i + 2][j + 1];
                    max = Math.max(max, temp);
                }
                if (i + 2 < N && j - 1 >= 0) {
                    temp = grid[i][j] + grid[i + 1][j] + grid[i + 1][j - 1] + grid[i + 2][j - 1];
                    max = Math.max(max, temp);
                }
            }
        }
    }

    private static void numberFive() {
        int temp;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (i + 1 < N && j - 1 >= 0 && j + 1 < M) {
                    temp = grid[i][j] + grid[i + 1][j - 1] + grid[i + 1][j] + grid[i + 1][j + 1];
                    max = Math.max(max, temp);
                }
                if (i - 1 >= 0 && i + 1 < N && j + 1 < M) {
                    temp = grid[i][j] + grid[i - 1][j + 1] + grid[i][j + 1] + grid[i + 1][j + 1];
                    max = Math.max(max, temp);
                }
                if (i - 1 >= 0 && j - 1 >= 0 && j + 1 < M) {
                    temp = grid[i][j] + grid[i - 1][j - 1] + grid[i - 1][j] + grid[i - 1][j + 1];
                    max = Math.max(max, temp);
                }
                if (i - 1 >= 0 && i + 1 < N && j - 1 >= 0) {
                    temp = grid[i][j] + grid[i - 1][j - 1] + grid[i][j - 1] + grid[i + 1][j - 1];
                    max = Math.max(max, temp);
                }
            }
        }
    }
}
