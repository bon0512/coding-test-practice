package baekjoon.bruteforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BaekJoon_18428 {
    static int N;
    static String[][] grid;

    static boolean[][] visited;
    static List<int[]> listX = new ArrayList<>();
    static List<int[]> listT = new ArrayList<>();

    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static boolean answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        grid = new String[N][N];

        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.next();
                if (grid[i][j].equals("X")) {
                    listX.add(new int[]{i, j});
                } else if (grid[i][j].equals("T")) {
                    listT.add(new int[]{i, j});
                }
            }
        }


        dfs(0, 0);

        if(answer){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }


    }

    private static void dfs(int start, int depth) {

        if(answer) return;

        if (depth == 3) {

            //배열 체크하고 만약 감시 피할 시 정답 answer = true;
            for (int i = 0; i < listT.size(); i++) {
                int[] ints = listT.get(i);
                int curY = ints[0];
                int curX = ints[1];

                for (int j = 0; j < 4; j++) {

                    int ny = curY + dy[j];
                    int nx = curX + dx[j];

                    while (true) {

                        if (nx < 0 || ny < 0 || nx >= N || ny >= N) break;
                        if (grid[ny][nx].equals("O")) break;
                        if (grid[ny][nx].equals("S")) {
                            return;
                        }

                        ny += dy[j];
                        nx += dx[j];
                    }

                }


            }
            answer = true;
            return ;

        }


        for (int i = start; i < listX.size(); i++) {
            int[] ints = listX.get(i);
            grid[ints[0]][ints[1]] = "O";
            dfs(i + 1, depth + 1);
            grid[ints[0]][ints[1]] = "X";
        }
    }
}
