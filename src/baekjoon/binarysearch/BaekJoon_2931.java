package baekjoon.binarysearch;

import java.util.Scanner;

public class BaekJoon_2931 {

    /**
     * 0번이 동쪽 1번이 서쪽 2번이 남쪽 3번이 북쪽
     */
    static int R, C;
    static char[][] grid;
    static int My, Mx;
    static int Zy, Zx;
    static int answerX, answerY, answerBridge;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        R = sc.nextInt();
        C = sc.nextInt();

        grid = new char[R][C];
        sc.nextLine();

        for (int i = 0; i < R; i++) {
            String s = sc.nextLine();
            for (int j = 0; j < C; j++) {
                grid[i][j] = s.charAt(j);

                if (s.charAt(j) == 'M') {
                    My = i;
                    Mx = j;
                } else if (s.charAt(j) == 'Z') {
                    Zy = i;
                    Zx = j;
                }

            }
        }

        for (int i = 0; i < 4; i++) {
            int nx = Mx + dx[i];
            int ny = My + dy[i];
            if (ny >= 0 && ny < R && nx < C && nx >= 0) {
                if (i == 0 && (grid[ny][nx] == '-' || grid[ny][nx] == '+' || grid[ny][nx] == '3' || grid[ny][nx] == '4')) {
                    dfs(nx, ny, grid[ny][nx], i);
                } else if (i == 1 && (grid[ny][nx] == '-' || grid[ny][nx] == '1' || grid[ny][nx] == '2' || grid[ny][nx] == '+')) {
                    dfs(nx, ny, grid[ny][nx], i);
                } else if (i == 2 && (grid[ny][nx] == '|' || grid[ny][nx] == '2' || grid[ny][nx] == '3' || grid[ny][nx] == '+')) {
                    dfs(nx, ny, grid[ny][nx], i);
                } else if (i == 3 && (grid[ny][nx] == '|' || grid[ny][nx] == '+' || grid[ny][nx] == '4' || grid[ny][nx] == '1')) {
                    dfs(nx, ny, grid[ny][nx], i);
                }
            }
        }

    }

    private static void dfs(int curX, int curY, char block, int dir) {
        if (curX == Zx && curY == Zy) {

            return;
        }


        if (block == '-') {
            int nx = curX;
            int ny = curY;
            if (dir == 0) { // 동쪽에서 들어왔으면 오른쪽으로 나감
                nx = curX + 1;
            } else if (dir == 1) { // 서쪽에서 들어왔으면 왼쪽으로 나감
                nx = curX - 1;
            }
            if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                dfs(nx, ny, grid[ny][nx], dir); // dir는 현재 진행 방향
            }
        } else if (block == '|') {
            int nx = curX;
            int ny = curY;
            if(dir == 3){

            }
            if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                dfs(nx, ny, grid[ny][nx], 2);
            }
        } else if (block == '+') {

        }


    }


}
