package baekjoon.implementation;

import java.util.Arrays;
import java.util.Scanner;

public class BaekJoon_21610 {

    static int[][] grid;
    static boolean[][] isCloud;
    static int N, M;
    static int dir;
    static int street;

    static int[] dx = {0, -1, -1, 0, 1, 1, 1, 0, -1};
    static int[] dy = {0, 0, -1, -1, -1, 0, 1, 1, 1};
    static int[] numberFour = {2, 4, 6, 8};

    public static void main(String[] args) {

        System.out.println(-8 % 5);
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        grid = new int[N][N];

        isCloud = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < 1; i++) {

            dir = sc.nextInt();
            street = sc.nextInt();
            int y1 = N - 1, x1 = 0;
            int y2 = N - 1, x2 = 1;
            int y3 = N - 2, x3 = 0;
            int y4 = N - 2, x4 = 1;
            int[] cols = new int[]{y1, y2, y3, y4};
            int[] rows = new int[]{x1, x2, x3, x4};


            //1번
            for (int j = 0; j < 4; j++) {
                cols[j] = (cols[j]+dy[dir] * street) %N;
                rows[j] = (rows[j]+dx[dir] * street)%N;

                if(cols[j]<0)cols[j] = (cols[j]+N)%N;
                if(rows[j]<0)rows[j] = (rows[j]+N)%N;

            }

            //2번


            for (int j = 0; j < 4; j++) {
                isCloud[cols[j]][rows[j]] = true;
            }

            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (isCloud[j][k]) grid[j][k]++;
                }
            }


            for (int j = 0; j < 4; j++) {
                int tempY = cols[j];
                int tempX = rows[j];
                isCloud[tempY][tempX] = true;
            }

            for (int j = 0; j < 4; j++) {

                int curY = cols[j];
                int curX = rows[j];


                for (int k = 2; k <= 8; k += 2) {

                    int ny = curY + dy[k];
                    int nx = curX + dx[k];

                    if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                        if (grid[ny][nx] > 0) grid[curY][curX]++;
                    }

                }


            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (grid[j][k] >= 2) {
                        if ((j == cols[0] || j == cols[1] || j == cols[2] || j == cols[3]) && (
                                k == rows[0] || k == rows[1] || k == rows[2] || k == rows[3])) {
                            continue;
                        } else {
                            isCloud[j][k] = true;
                            grid[j][k] -= 2;
                        }
                    }
                }
            }

            for (int j = 0; j < 4; j++) {
                int tempY = cols[i];
                int tempX = rows[i];
                isCloud[tempY][tempX] = false;
            }

            System.out.println("마지막 배열");
            for (int[] ints : grid) {
                System.out.println(Arrays.toString(ints));
            }
            ;
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                answer += grid[i][j];
            }
        }


        System.out.println(answer);

    }
}
