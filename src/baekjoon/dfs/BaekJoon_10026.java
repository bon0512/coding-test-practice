package baekjoon.dfs;

import java.util.Scanner;

public class BaekJoon_10026 {

    static char[][] grid;
    static boolean[][] redGreen;
    static boolean[][] noRedGreen;
    static int N;
    static int redGreenCount = 0;
    static int noRedGreenCount = 0;
    static int[] dx = {1, -1, 0, 0}; //동서남북
    static int[] dy = {0, 0, -1, 1}; //동서남북

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        sc.nextLine();

        grid = new char[N][N];
        redGreen = new boolean[N][N];
        noRedGreen = new boolean[N][N];


        for (int i = 0; i < N; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < N; j++) {
                grid[i][j] = s.charAt(j);
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {

                if (redGreen[i][j] == false) {
                    redGreenCount++;
                    dfs(j, i, grid[i][j]);
                }

            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (noRedGreen[i][j] == false) {
                    noRedGreenCount++;
                    noDfs(j, i, grid[i][j]);
                }
            }
        }


        System.out.println(redGreenCount + " " + noRedGreenCount);


    }


    static public void dfs(int x, int y, char color) {
        redGreen[y][x] = true;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                if (grid[ny][nx] == color && !redGreen[ny][nx]) {
                    redGreen[ny][nx] = true;
                    dfs(nx, ny, color);
                }
            }
        }
    }

    static public void noDfs(int x, int y, char color) {
        noRedGreen[y][x] = true;

        if (color == 'R' || color == 'G') {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if ((grid[ny][nx] == 'R' || grid[ny][nx] == 'G') && noRedGreen[ny][nx] == false) {
                        noDfs(nx, ny, grid[ny][nx]);
                    }
                }
            }
        } else {
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                    if (grid[ny][nx] == 'B' && !noRedGreen[ny][nx]) {
                        noDfs(nx, ny, grid[ny][nx]);
                    }
                }
            }
        }
    }

}

