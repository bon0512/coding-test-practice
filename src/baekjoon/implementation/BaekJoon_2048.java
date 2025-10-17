package baekjoon.implementation;

import java.util.Scanner;

public class BaekJoon_2048 {

    static int N;
    static int[][] grid;
    static int answer = Integer.MIN_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        grid = new int[N][N];
        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                grid[i][j] = sc.nextInt();

        dfs(0, grid); // 초기 배열 그대로 넘김
        System.out.println(answer);
    }

    private static void dfs(int depth, int[][] temp) {
        if (depth == 5) {
            for (int[] row : temp)
                for (int v : row)
                    answer = Math.max(answer, v);
            return;
        }

        // 0: 오른쪽, 1: 왼쪽, 2: 아래, 3: 위
        for (int i = 0; i < 4; i++) {
            int[][] next = copyArray(temp);
            if (i == 0) dfs(depth + 1, moveRight(next));
            else if (i == 1) dfs(depth + 1, moveLeft(next));
            else if (i == 2) dfs(depth + 1, moveDown(next));
            else dfs(depth + 1, moveUp(next));
        }
    }

    private static int[][] moveLeft(int[][] arr) {
        for (int i = 0; i < N; i++) {
            int point = 0; // 0이 아닌 숫자를 채울 위치
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    grid[i][point] = grid[i][j];
                    if (point != j) grid[i][j] = 0;
                    point++;
                }
            }
        }

        // 합치기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N - 1; j++) {
                if (arr[i][j] != 0 && arr[i][j] == arr[i][j + 1]) {
                    arr[i][j] *= 2;
                    arr[i][j + 1] = 0;
                }
            }
        }

        // 다시 밀기
        for (int i = 0; i < N; i++) {
            int point = 0; // 0이 아닌 숫자를 채울 위치
            for (int j = 0; j < N; j++) {
                if (grid[i][j] != 0) {
                    grid[i][point] = grid[i][j];
                    if (point != j) grid[i][j] = 0;
                    point++;
                }
            }
        }

        return arr;
    }

    private static int[][] moveRight(int[][] arr) {
        for (int i = 0; i < N; i++) {
            int point = N - 1; // 0이 아닌 숫자를 채울 위치
            for (int j = N - 1; j >= 0; j--) {
                if (grid[i][j] != 0) {
                    grid[i][point] = grid[i][j];
                    if (point != j) grid[i][j] = 0;
                    point--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = N - 1; j > 0; j--) {
                if (arr[i][j] != 0 && arr[i][j] == arr[i][j - 1]) {
                    arr[i][j] *= 2;
                    arr[i][j - 1] = 0;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            int point = N - 1; // 0이 아닌 숫자를 채울 위치
            for (int j = N - 1; j >= 0; j--) {
                if (grid[i][j] != 0) {
                    grid[i][point] = grid[i][j];
                    if (point != j) grid[i][j] = 0;
                    point--;
                }
            }
        }

        return arr;
    }

    private static int[][] moveUp(int[][] arr) {
        for (int j = 0; j < N; j++) {
            int point = 0;
            for (int i = 0; i < N; i++) {
                if (grid[i][j] != 0) {
                    grid[point][j] = grid[i][j];
                    if (point != i) grid[i][j] = 0;
                    point++;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            for (int i = 0; i < N - 1; i++) {
                if (arr[i][j] != 0 && arr[i][j] == arr[i + 1][j]) {
                    arr[i][j] *= 2;
                    arr[i + 1][j] = 0;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            int point = 0;
            for (int i = 0; i < N; i++) {
                if (grid[i][j] != 0) {
                    grid[point][j] = grid[i][j];
                    if (point != i) grid[i][j] = 0;
                    point++;
                }
            }
        }

        return arr;
    }

    private static int[][] moveDown(int[][] arr) {
        for (int j = 0; j < N; j++) {
            int point = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (grid[i][j] != 0) {
                    grid[point][j] = grid[i][j];
                    if (point != i) grid[i][j] = 0;
                    point--;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            for (int i = N - 1; i > 0; i--) {
                if (arr[i][j] != 0 && arr[i][j] == arr[i - 1][j]) {
                    arr[i][j] *= 2;
                    arr[i - 1][j] = 0;
                }
            }
        }

        for (int j = 0; j < N; j++) {
            int point = N - 1;
            for (int i = N - 1; i >= 0; i--) {
                if (grid[i][j] != 0) {
                    grid[point][j] = grid[i][j];
                    if (point != i) grid[i][j] = 0;
                    point--;
                }
            }
        }

        return arr;
    }

    private static int[][] copyArray(int[][] arr) {
        int[][] copy = new int[N][N];
        for (int i = 0; i < N; i++)
            System.arraycopy(arr[i], 0, copy[i], 0, N);
        return copy;
    }
}
