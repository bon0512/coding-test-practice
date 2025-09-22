package baekjoon.bfs;

import java.util.*;

/**
 * 백준 토마토 문제
 * 토마토심어져있는 위치 찾아서 한번에 큐에 넣어야댐 하나하나 위치 따로구한다음 각각 bfs 돌리면안된다... 문제 이해를 잘 못했음;
 */
public class BaekJoon_7576 {

    static int M, N;
    static int[][] grid;
    static int[][] days;
    static Queue<int[]> queue = new LinkedList<>();

    static int[] dx = new int[]{1, -1, 0, 0};
    static int[] dy = new int[]{0, 0, -1, 1};

    static int min = Integer.MAX_VALUE;
    static int tempMin = 0;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();


        grid = new int[N][M];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        boolean noZero = true;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 0) {
                    noZero = false;
                    break;
                }
            }
        }



        if (noZero) {
            System.out.println(0);
            return;
        }

        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i,j});
                }
            }
        }


        bfs();


    }

    private static void bfs() {
        days = new int[N][M];

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();

            int curX = temp[1];
            int curY = temp[0];



            for (int i = 0; i < 4; i++) {

                int nx = curX + dx[i];
                int ny = curY + dy[i];

                if (nx >= 0 && ny >= 0 && nx < M && ny < N ) {
                    if(grid[ny][nx] == -1) continue;
                    if (grid[ny][nx] == 0) {
                        grid[ny][nx] = 1;
                        days[ny][nx] = days[curY][curX] + 1;
                        queue.add(new int[]{ny,nx});
                    }
                }

            }



        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(grid[i][j]==0){
                    System.out.println(-1);
                    return;
                }
            }
        }

        int max = -1;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                max = Math.max(days[i][j],max);
            }
        }

        System.out.println(max);
    }
}
