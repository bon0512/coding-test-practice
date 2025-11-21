package baekjoon.implementation;

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

        System.out.println(answerX+1+" "+answerY+1+" "+answerBridge);

    }

    private static void dfs(int curX, int curY, char block, int dir) {



        int nx = curX;
        int ny = curY;

        if (block == '.') {
            answerBridge = choiceBlock(nx, ny);
            answerX = curX;
            answerY = curY;
        }

        if (block == '-') {
            if (dir == 0) { // 동쪽에서 들어왔으면 오른쪽으로 나감
                nx = curX - 1;
            } else if (dir == 1) { // 서쪽에서 들어왔으면 왼쪽으로 나감
                nx = curX + 1;
            }
            if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                dfs(nx, ny, grid[ny][nx], dir); // dir는 현재 진행 방향
            }
        } else if (block == '|') {
            if (dir == 3) {   //북쪽에서 왔으면 아래로 나감
                ny++;
            } else if (dir == 2) {
                ny--;
            }
            if (nx >= 0 && nx < C && ny >= 0 && ny < R) {
                dfs(nx, ny, grid[ny][nx], dir);
            }
        } else if (block == '+') {

            if (dir == 0) {
                nx++;
            } else if (dir == 1) {
                nx--;
            } else if (dir == 2) {
                ny++;
            } else if (dir == 3) {
                ny--;
            }
        } else if (block == '1') {
            if (dir == 1) {
                dir = 2;
                ny++;
            } else if (dir == 3) {
                dir = 0;
                nx++;
            }

        } else if (block == '2') {
            if (dir == 2) {
                nx++;
                dir = 0;
            } else if (dir == 1) {
                ny--;
                dir = 3;
            }

        } else if (block == '3') {

            if (dir == 2) {
                nx--;
                dir = 1;
            } else if (dir == 0) {
                ny--;
                dir = 3;
            }

        } else if (block == '4') {

            if (dir == 0) {
                ny++;
                dir = 2;
            } else if (dir == 3) {
                nx--;
                dir = 2;
            }

        }

        if (nx >= 0 & nx < C && ny >= 0 && ny < R) {
            dfs(nx, ny, grid[ny][nx], dir);
        }


    }

    private static int choiceBlock(int curX, int curY) {

        boolean[] open = new boolean[4];

        for (int i = 0; i < 4; i++) {
            int nx = curX + dx[i];
            int ny = curY + dy[i];
            if (nx < 0 || nx >= C || ny < 0 || ny >= R) continue;
            char temp = grid[ny][nx];
            if (temp == '.' || temp == 'M' || temp == 'Z') continue;

            if (temp == '|') {
                if (i == 2 || i == 3) {
                    open[i] = true;
                }
            } else if (temp == '-') {
                if (i == 0 || i == 1) {
                    open[i] = true;
                }
            } else if (temp == '+') {
                open[i] = true;
            } else if (temp == '1') {
                if (i == 1 || i == 3) {
                    open[i] = true;
                }
            } else if (temp == '2') {
                if (i == 1 || i == 2) {
                    open[i] = true;
                }
            } else if (temp == '3') {
                if (i == 0 || i == 2) {
                    open[i] = true;
                }
            } else if (temp == '4') {
                if (i == 0 || i == 3) {
                    open[i] = true;
                }
            }

        }

        if (open[0] && open[1] && open[2] && open[3]) return '+';
        if (open[0] && open[1]) return '-';
        if (open[2] && open[3]) return '|';
        if (open[2] && open[0]) return '1';
        if (open[3] && open[0]) return '2';
        if (open[3] && open[1]) return '3';
        if (open[2] && open[1]) return '4';

        return '*';

    }


}
